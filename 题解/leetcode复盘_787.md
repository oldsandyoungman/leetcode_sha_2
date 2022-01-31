很多题目还是一错再错，决定做个复盘，记录下自己哪里写错了



[TOC]

#### [787. K 站中转内最便宜的航班](https://leetcode-cn.com/problems/cheapest-flights-within-k-stops/)

> 有 n 个城市通过一些航班连接。给你一个数组 flights ，其中 flights[i] = [fromi, toi, pricei] ，表示该航班都从城市 fromi 开始，以价格 pricei 抵达 toi。
>
> 现在给定所有的城市和航班，以及出发城市 src 和目的地 dst，你的任务是找到出一条最多经过 k 站中转的路线，使得从 src 到 dst 的 价格最便宜 ，并返回该价格。 如果不存在这样的路线，则输出 -1。
>
> 
>
> 提示：
>
> - 1 <= n <= 100
> - 0 <= flights.length <= (n * (n - 1) / 2)
> - flights[i].length == 3
> - 0 <= fromi, toi < n
> - fromi != toi
> - 1 <= pricei <= 104
> - 航班没有重复，且不存在自环
> - 0 <= src, dst, k < n
> - src != dst



##### 思路

第一眼会觉得是dijkstra，毕竟是最短路径，至于对k个中转的限制，需要额外添加一个数组记录。当然，PriorityQueue本身只能对一种东西排序，所以k中转的限制只能在循环逻辑里添加，具体而言：

> - State中添加中转数量作为成员变量
> - 建立nodes数组，初始化为最大值
> - 循环中，先判断是否达到终点，再判断是否超过k
> - 循环中，对于邻接节点，只有距离更大且中转更多的才被剪枝，任意条件不满足就不必剪枝（因为如果距离虽长但是中转次数正好，那么不必被淘汰）
> - 循环中，对于邻接节点，依然采用距离更短才会被加入队列，不必管中转次数的限制，中转次数如果不满足会在前面被continue掉



当然，这道题也是可以用动态规划来做，几步走：

1. dp函数定义：在可中转k次的情况下，从固定src0到达dst所需要的最小路径
2. 状态（也是memo的坐标）：目标终点dst + 可中转次数k
3. 选择：目标终点的邻接节点（注意是有向边）
4. base0：终点dst==src0，return0；中转次数到达k以上，return Integer.MAX_VALUE





##### 注意点

本题的路径是有向的，而不是双向的



##### 代码

1. dijkstra

```java
class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<int[]>[] graph = new LinkedList[n];
        for(int i=0; i<n; i++){
            graph[i] = new LinkedList<>();
        }

        for(int[] tmp : flights){
            int ss = tmp[0];
            int tt = tmp[1];
            int dis = tmp[2];
            graph[ss].add(new int[]{tt, dis});
        }

        int[] res = new int[n];
        Arrays.fill(res, Integer.MAX_VALUE);
        res[src] = 0;

        int[] nodes = new int[n];
        Arrays.fill(nodes, Integer.MAX_VALUE);
        nodes[src] = 0;

        PriorityQueue<State787> q = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.disFromStart, o2.disFromStart));
        q.offer(new State787(src, 0, 0));
        // int res_k = -1;

        while(!q.isEmpty()){
            State787 cur = q.poll();

            // if(cur.disFromStart>res[cur.id]){
            //     continue;
            // }

            if(cur.id==dst){
                // if(cur.k>=0){
                //     res_k = cur.k;
                // }
                break;
            }

            if (cur.k==k+1){
                continue;
            }


            for(int[] next : graph[cur.id]){
                int distFromStartToNext = next[1] + cur.disFromStart;

                if(distFromStartToNext > res[next[0]] && cur.k+1>nodes[next[0]]){
                    continue;
                }
                
                if(res[next[0]]>distFromStartToNext){
                    res[next[0]] = distFromStartToNext;
                    nodes[next[0]] = cur.k + 1;
                }

                q.offer(new State787(next[0], distFromStartToNext, cur.k+1));
            }

        }

        return res[dst]==Integer.MAX_VALUE?-1:res[dst];


    }
}

class State787{

    int id;
    int disFromStart;
    int k;

    public State787(int a, int b, int c){
        id = a;
        disFromStart = b;
        k = c;
    }


}
```

2. 动态规划

```java
class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<int[]>[] graph = new LinkedList[n];
        for(int i=0; i<n; i++){
            graph[i] = new LinkedList<>();
        }

        for(int[] tmp : flights){
            int ss = tmp[0];
            int tt = tmp[1];
            int dis = tmp[2];
            // graph[ss].add(new int[]{tt, dis});
            graph[tt].add(new int[]{ss, dis});
        }

        memo = new int[n][k+2];
        for(int[] tmp : memo){
            Arrays.fill(tmp, Integer.MAX_VALUE);
        }

        sss = src;
        ddd = dst;

        int res = traverse(graph, dst, k+1);

        // System.out.println(Arrays.deepToString(memo));

        return res==Integer.MAX_VALUE?-1:res;

    }

    public int[][] memo;
    public int sss;
    public int ddd;

    // 状态：目标点，k步之内
    public int traverse(List<int[]>[] graph, int dst, int k) {
        
        if(dst==sss){
            memo[dst][k] = 0;
            return 0;
        }

        if(k<=0){
            return Integer.MAX_VALUE;
        }

        if(memo[dst][k]!=Integer.MAX_VALUE){
            return memo[dst][k];
        }

        int res = Integer.MAX_VALUE;

        for(int[] next : graph[dst]){
            int tmp = traverse(graph, next[0], k-1);
            if(tmp!=Integer.MAX_VALUE){
                tmp += next[1];
                res = Math.min(res, tmp);
            }
        }

        memo[dst][k] = res;

        return res;

    }

}
```

