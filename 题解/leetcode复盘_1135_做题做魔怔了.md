很多题目还是一错再错，决定做个复盘，记录下自己哪里写错了



[TOC]

#### [1135. 最低成本联通所有城市](https://leetcode-cn.com/problems/connecting-cities-with-minimum-cost/)


> 想象一下你是个城市基建规划者，地图上有Ⅳ座城市，它们按以1到N的次序编号。
>
> 给你一些可连接的选项conections ，其中每个选项conections [i] =[ city1, city2, cost]表示将城市city1和城市city2连接所要的成本为cost。(连接是双向的，也就是说城市city1和城市city2相连也同样意味着城市city2和城市city1相连)。
>
> 计算连通所有城市最小成本。如果无法连通所有城市，则请你返回-1。



##### 思路

方法一：Kruskal方法

利用Union-Find，对于排序好的 conections，每次加入时判断是否相连，相连的话跳过



方法二：Prim方法

利用切分定理，**对于任意一种「切分」，其中权重最小的那条「横切边」一定是构成最小生成树的一条边**。

所以，以任意节点开始进行切分（遍历该节点的邻边，如果邻边的另一个节点未访问过，那么将该边加入优先级队列中，这些操作就是一次切分），之后再循环取出队列头元素，如果头元素的另外一端节点未遍历过，则更新weightSum，并将该节点状态inMst置为访问过，再将该节点进行切分，直到队列元素为空

最后判断是否全部连通，就是遍历inMst数组是否全为true即可



##### 注意点

方法一中

- 注意序号是从1开始的，所以UF创建时要加一，最后判断时大小是否为2
- conections 从小到大排序，直接用一个 Arrays.sort()，不用再创建一个优先级队列，别魔怔了

方法二中

- 过段时间忘干净了再写，不然暴露不了问题



##### 代码

1. 方法一：

```java
package com.example.leetcode_sha_2.leetcode_origin;

import java.util.Arrays;
import java.util.PriorityQueue;

public class s1135 {

    public static void main(String[] args) {

    }

//    想象一下你是个城市基建规划者，地图上有Ⅳ座城市，它们按以1到N的次序编号。
//    给你一些可连接的选项conections ，其中每个选项conections [i] =[ city1, city2, cost]表示将城市city1和城市city2连接所要的成本为cost。(连接是双向的，也就是说城市city1和城市city2相连也同样意味着城市city2和城市city1相连)。
//    计算连通所有城市最小成本。如果无法连通所有城市，则请你返回-1。

    public static int minimumCost(int n, int[][] connections) {
        UF1135 uf = new UF1135(n+1);

//        PriorityQueue<int[]> q = new PriorityQueue<>((o1, o2) -> {
//            return Integer.compare(o1[2], o2[2]);
//        });
//
//        for(int[] tmp : connections){
//            q.offer(tmp);
//        }
        Arrays.sort(connections, ((o1, o2) -> {
            return Integer.compare(o1[2], o2[2]);
        }));

        int res = 0;

        for(int[] cur : connections){

            if(uf.isConnected(cur[0], cur[1])){
                continue;
            }
            uf.union(cur[0], cur[1]);
            res += cur[2];
            if(uf.count==2){
                return res;
            }
        }

        return -1;

    }


}


class UF1135{

    int count;
    int[] parent;
    int[] size;

    public UF1135(int n){
        count = n;
        parent = new int[n];
        size = new int[n];
        for(int i=0; i<n; i++){
            parent[i] = i;
            size[i] = 1;
        }
    }

    public int findRoot(int x){
        while(parent[x]!=x){
            parent[x] = parent[parent[x]];
            x = parent[x];
        }
        return x;
    }

    public void union(int i, int j){
        int root_i = findRoot(i);
        int root_j = findRoot(j);
        if(root_i==root_j){
            return;
        }
        if(size[root_i]>size[root_j]){
            parent[root_j] = root_i;
            size[root_i] += size[root_j];
        }else{
            parent[root_i] = root_j;
            size[root_j] += size[root_i];
        }
        count--;
    }

    public boolean isConnected(int i, int j){
        int root_i = findRoot(i);
        int root_j = findRoot(j);
        return root_i==root_j;
    }

    public int count(){
        return count;
    }



}
```

2. 方法二：

```java
public class s1135 {

    public static void main(String[] args) {

    }

//    想象一下你是个城市基建规划者，地图上有Ⅳ座城市，它们按以1到N的次序编号。
//    给你一些可连接的选项conections ，其中每个选项conections [i] =[ city1, city2, cost]表示将城市city1和城市city2连接所要的成本为cost。(连接是双向的，也就是说城市city1和城市city2相连也同样意味着城市city2和城市city1相连)。
//    计算连通所有城市最小成本。如果无法连通所有城市，则请你返回-1。
    
    
//    prim方法
    public static int minimumCost2(int n, int[][] connections) {
        List<int[]>[] graph = new LinkedList[n];

        for (int i=0; i<n; i++){
            graph[i] = new LinkedList<>();
        }

        for(int[] tmp : connections){
            int from = tmp[0] - 1;
            int to = tmp[1] - 1;
            int weight = tmp[2];

            graph[from].add(new int[]{from, to, weight});
            graph[to].add(new int[]{to, from, weight});

        }

        Prim prim = new Prim(graph);
        if(!prim.isAllConnected()){
            return -1;
        }
        return prim.getWeightSum();

    }
}



class Prim{
    List<int[]>[] graph;
    PriorityQueue<int[]> q;
    boolean[] inMst;
    int weightSum;

    public Prim(List<int[]>[] graph){
        int n = graph.length;
        this.graph = graph;
        q = new PriorityQueue<>(((o1, o2) -> {
            return Integer.compare(o1[2], o2[2]);
        }));
        inMst = new boolean[n];
        weightSum = 0;

        inMst[0] = true;
        cut(0);

        while(!q.isEmpty()){
            int[] cur = q.poll();
            int next = cur[1];
            int weight = cur[2];

            if(inMst[next]){
                continue;
            }
            weightSum += weight;
            inMst[next] = true;
            cut(next);

        }

    }

    public void cut(int i){

        for(int[] cur : graph[i]){
            int next = cur[1];
            if(inMst[next]){
                continue;
            }
            q.add(cur);
        }

    }

    public boolean isAllConnected(){
        for (int i=0; i<graph.length; i++){
            if (!inMst[i]){
                return false;
            }
        }
        return true;
    }

    public int getWeightSum(){
        return weightSum;
    }

}


```

