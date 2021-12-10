package com.example.leetcode_sha_2.leetcode_origin;

import java.util.*;

public class s743 {

    public static void main(String[] args) {
        int[][] times = {{2,1,1}, {2,3,1}, {3,4,1}};
        int n = 4;
        int k = 2;

        System.out.println(networkDelayTime(times, n, k));
    }

//    有 n 个网络节点，标记为 1 到 n。
//
//    给你一个列表 times，表示信号经过 有向 边的传递时间。 times[i] = (ui, vi, wi)，其中 ui 是源节点，vi 是目标节点， wi 是一个信号从源节点传递到目标节点的时间。
//
//    现在，从某个节点 K 发出一个信号。需要多久才能使所有节点都收到信号？如果不能使所有节点收到信号，返回 -1 。
//
//    来源：力扣（LeetCode）
//    链接：https://leetcode-cn.com/problems/network-delay-time
//    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

//    public static int networkDelayTime(int[][] times, int n, int k) {
//        // 节点编号是从 1 开始的，所以要一个大小为 n + 1 的邻接表
//        List<int[]>[] graph = new LinkedList[n + 1];
//        for (int i = 1; i <= n; i++) {
//            graph[i] = new LinkedList<>();
//        }
//        // 构造图
//        for (int[] edge : times) {
//            int from = edge[0];
//            int to = edge[1];
//            int weight = edge[2];
//            // from -> List<(to, weight)>
//            // 邻接表存储图结构，同时存储权重信息
//            graph[from].add(new int[]{to, weight});
//        }
//        // 启动 dijkstra 算法计算以节点 k 为起点到其他节点的最短路径
//        int[] distTo = dijkstra(k, graph);
//
//        // 找到最长的那一条最短路径
//        int res = 0;
//        for (int i = 1; i < distTo.length; i++) {
//            if (distTo[i] == Integer.MAX_VALUE) {
//                // 有节点不可达，返回 -1
//                return -1;
//            }
//            res = Math.max(res, distTo[i]);
//        }
//        return res;
//    }
//
//    // 输入一个起点 start，计算从 start 到其他节点的最短距离
//    public static int[] dijkstra(int start, List<int[]>[] graph) {
//        // 定义：distTo[i] 的值就是起点 start 到达节点 i 的最短路径权重
//        int[] distTo = new int[graph.length];
//        Arrays.fill(distTo, Integer.MAX_VALUE);
//        // base case，start 到 start 的最短距离就是 0
//        distTo[start] = 0;
//
//        // 优先级队列，distFromStart 较小的排在前面
//        Queue<State> pq = new PriorityQueue<>((a, b) -> {
//            return a.distFromStart - b.distFromStart;
//        });
//        // 从起点 start 开始进行 BFS
//        pq.offer(new State(start, 0));
//
//        while (!pq.isEmpty()) {
//            State curState = pq.poll();
//            int curNodeID = curState.id;
//            int curDistFromStart = curState.distFromStart;
//
//            if (curDistFromStart > distTo[curNodeID]) {
//                continue;
//            }
//
//            // 将 curNode 的相邻节点装入队列
//            for (int[] neighbor : graph[curNodeID]) {
//                int nextNodeID = neighbor[0];
//                int distToNextNode = distTo[curNodeID] + neighbor[1];
//                // 更新 dp table
//                if (distTo[nextNodeID] > distToNextNode) {
//                    distTo[nextNodeID] = distToNextNode;
//                    pq.offer(new State(nextNodeID, distToNextNode));
//                }
//            }
//        }
//        return distTo;
//    }


    public static int networkDelayTime(int[][] times, int n, int k) {
        List<int[]>[] graph = new LinkedList[n+1];
        for(int i=1; i<=n; i++){
            graph[i] = new LinkedList<>();
        }
        for(int[] tmp : times){
            int src = tmp[0];
            int tar = tmp[1];
            int weight = tmp[2];
            graph[src].add(new int[]{tar, weight});
        }
        int[] todist = dijkstra(k, graph);
        int res = 0;
        for(int i=1; i<=n; i++){
            int tmp = todist[i];
            if(tmp==Integer.MAX_VALUE){
                return -1;
            }
            res = Math.max(res, tmp);
        }
        return res;
    }

    public static int[] dijkstra(int start, List<int[]>[] graph){
        int[] todist = new int[graph.length];
        Arrays.fill(todist, Integer.MAX_VALUE);
        todist[start] = 0;
        PriorityQueue<State> pq = new PriorityQueue<>((o1, o2) -> {
            return Integer.compare(o1.distFromStart, o2.distFromStart);
        });
        pq.add(new State(start, 0));
        while(!pq.isEmpty()){
            State cur = pq.poll();
            int curid = cur.id;
            int curdistfromstart = cur.distFromStart;
            if(curdistfromstart>todist[curid]){
                continue;
            }
            for(int[] neighbours : graph[curid]){
                int neighbourid = neighbours[0];
                int distfromcurtonei = neighbours[1];
                int now = todist[curid] + distfromcurtonei;
                if(now<todist[neighbourid]){
                    todist[neighbourid] = now;
                    pq.offer(new State(neighbourid, now));
                }
            }
        }

        return todist;


    }

}


class State {
    // 图节点的 id
    int id;
    // 从 start 节点到当前节点的距离
    int distFromStart;

    State(int id, int distFromStart) {
        this.id = id;
        this.distFromStart = distFromStart;
    }
}
