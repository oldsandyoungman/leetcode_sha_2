package com.example.leetcode_sha_2.leetcode_origin;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class s787 {

    public static void main(String[] args) {

//        int n = 3;
//        int[][] flights = {{0,1,100},{1,2,100},{0,2,500}};
//        int src = 0;
//        int dst = 2;
//        int k = 0;


//        int n = 4;
//        int[][] flights = {{0,1,1},{0,2,5},{1,2,1},{2,3,1}};
//        int src = 0;
//        int dst = 3;
//        int k = 1;

        int n = 5;
        int[][] flights = {{0,1,5},{1,2,5},{0,3,2},{3,1,2}, {1,4,1}, {4,2,1}};
        int src = 0;
        int dst = 2;
        int k = 2;

        System.out.println(findCheapestPrice(n, flights, src, dst, k));

    }




//    有 n 个城市通过一些航班连接。给你一个数组 flights ，其中 flights[i] = [fromi, toi, pricei] ，表示该航班都从城市 fromi 开始，以价格 pricei 抵达 toi。
//
//    现在给定所有的城市和航班，以及出发城市 src 和目的地 dst，你的任务是找到出一条最多经过 k 站中转的路线，使得从 src 到 dst 的 价格最便宜 ，并返回该价格。 如果不存在这样的路线，则输出 -1。
//
//    来源：力扣（LeetCode）
//    链接：https://leetcode-cn.com/problems/cheapest-flights-within-k-stops
//    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。


// dijkstra方法
//    public static int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
//        List<int[]>[] graph = new LinkedList[n];
//        for(int i=0; i<n; i++){
//            graph[i] = new LinkedList<>();
//        }
//
//        for(int[] tmp : flights){
//            int ss = tmp[0];
//            int tt = tmp[1];
//            int dis = tmp[2];
//            graph[ss].add(new int[]{tt, dis});
//        }
//
//        int[] res = new int[n];
//        Arrays.fill(res, Integer.MAX_VALUE);
//        res[src] = 0;
//
//        int[] nodes = new int[n];
//        Arrays.fill(nodes, Integer.MAX_VALUE);
//        nodes[src] = 0;
//
//        PriorityQueue<State787> q = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.disFromStart, o2.disFromStart));
//        q.offer(new State787(src, 0, 0));
//        // int res_k = -1;
//
//        while(!q.isEmpty()){
//            State787 cur = q.poll();
//
//            // if(cur.disFromStart>res[cur.id]){
//            //     continue;
//            // }
//
//            if(cur.id==dst){
//                // if(cur.k>=0){
//                //     res_k = cur.k;
//                // }
//                break;
//            }
//
//            if (cur.k==k+1){
//                continue;
//            }
//
//
//            for(int[] next : graph[cur.id]){
//                int distFromStartToNext = next[1] + cur.disFromStart;
//
//                if(distFromStartToNext > res[next[0]] && cur.k+1>nodes[next[0]]){
//                    continue;
//                }
//
//                if(res[next[0]]>distFromStartToNext){
//                    res[next[0]] = distFromStartToNext;
//                    nodes[next[0]] = cur.k + 1;
//                }
//
//                q.offer(new State787(next[0], distFromStartToNext, cur.k+1));
//            }
//
//        }
//
//        return res[dst]==Integer.MAX_VALUE?-1:res[dst];
//
//
//    }


//    public static int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
//        List<int[]>[] graph = new LinkedList[n];
//        for(int i=0; i<n; i++){
//            graph[i] = new LinkedList<>();
//        }
//
//        for(int[] tmp : flights){
//            int ss = tmp[0];
//            int tt = tmp[1];
//            int dis = tmp[2];
//            graph[ss].add(new int[]{tt, dis});
//            graph[tt].add(new int[]{ss, dis});
//        }
//
//        memo = new int[n][k+2];
//        for(int[] tmp : memo){
//            Arrays.fill(tmp, Integer.MAX_VALUE);
//        }
//
//        sss = src;
//        ddd = dst;
//
//        int res = traverse(graph, dst, k+1);
//
//        // System.out.println(Arrays.deepToString(memo));
//
//        return res==Integer.MAX_VALUE?-1:res;
//
//    }
//
//    public static int[][] memo;
//    public static int sss;
//    public static int ddd;
//
//    // 状态：目标点，k步之内
//    public static int traverse(List<int[]>[] graph, int dst, int k) {
//
//        if(dst==sss){
//            memo[dst][k] = 0;
//            return 0;
//        }
//
//        if(k<=0){
//            return Integer.MAX_VALUE;
//        }
//
//        if(memo[dst][k]!=Integer.MAX_VALUE){
//            return memo[dst][k];
//        }
//
//        int res = Integer.MAX_VALUE;
//
//        for(int[] next : graph[dst]){
//            int tmp = traverse(graph, next[0], k-1);
//            if(tmp!=Integer.MAX_VALUE){
//                tmp += next[1];
//                res = Math.min(res, tmp);
//            }
//        }
//
//        memo[dst][k] = res;
//
//        return res;
//
//    }


    public static int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        LinkedList<int[]>[] graph = new LinkedList[n];
        for(int i=0; i<n; i++){
            graph[i] = new LinkedList<>();
        }
        for(int[] tmp : flights){
            int ss = tmp[0];
            int tt = tmp[1];
            int pp = tmp[2];
            graph[ss].addLast(new int[]{tt, pp});
        }

        memo = new int[n][k+2];
        for(int[] tmp : memo){
            Arrays.fill(tmp, Integer.MAX_VALUE);
        }

        int res = dfs(graph, src, dst, k+1);

        System.out.println(Arrays.deepToString(memo));

        return res;


    }

    public static int[][] memo;

    public static int dfs(LinkedList<int[]>[] graph, int src, int dst, int k){
        if(src==dst){
            memo[src][k] = 0;
            return 0;
        }
        if(k==0){
            memo[src][k] = -1;
            return -1;
        }

        if(memo[src][k]!=Integer.MAX_VALUE){
            return memo[src][k];
        }

        int res = Integer.MAX_VALUE;
        for(int[] next_info : graph[src]){
            int tmp_res = dfs(graph, next_info[0], dst, k-1);
            if(tmp_res==-1){
                continue;
            }
            tmp_res += next_info[1];
            res = Math.min(res, tmp_res);
        }

        if(res==Integer.MAX_VALUE){
            res = -1;
        }

        memo[src][k] = res;

        return res;


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