package com.example.leetcode_sha_2.leetcode_origin;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class s1135 {

    public static void main(String[] args) {
        int n = 3;
        int[][] connections = {{1,2,5}, {1,3,6}, {2,3,1}};

        System.out.println(minimumCost(n, connections));
        System.out.println(minimumCost2(n, connections));

    }

//    想象一下你是个城市基建规划者，地图上有Ⅳ座城市，它们按以1到N的次序编号。
//    给你一些可连接的选项conections ，其中每个选项conections [i] =[ city1, city2, cost]表示将城市city1和城市city2连接所要的成本为cost。(连接是双向的，也就是说城市city1和城市city2相连也同样意味着城市city2和城市city1相连)。
//    计算连通所有城市最小成本。如果无法连通所有城市，则请你返回-1。



//    kruskal方法
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