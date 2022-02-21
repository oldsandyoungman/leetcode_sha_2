package com.example.leetcode_sha_2.leetcode_origin;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class s1584 {

    public static void main(String[] args) {
        int[][] points = {{0,0},{2,2},{3,10},{5,2},{7,0}};
        System.out.println(minCostConnectPoints(points));
    }

//    给你一个points 数组，表示 2D 平面上的一些点，其中 points[i] = [xi, yi] 。
//
//    连接点 [xi, yi] 和点 [xj, yj] 的费用为它们之间的 曼哈顿距离 ：|xi - xj| + |yi - yj| ，其中 |val| 表示 val 的绝对值。
//
//    请你返回将所有点连接的最小总费用。只有任意两点之间 有且仅有 一条简单路径时，才认为所有点都已连接。
//
//    来源：力扣（LeetCode）
//    链接：https://leetcode-cn.com/problems/min-cost-to-connect-all-points
//    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

    public static int minCostConnectPoints(int[][] points) {
        int n = points.length;

        UF1584 uf = new UF1584(n);

        PriorityQueue<int[]> q = new PriorityQueue<>((o1, o2) -> {
            return Integer.compare(o1[2], o2[2]);
        });

        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                int dist = Math.abs(points[i][0]-points[j][0]) + Math.abs(points[i][1]-points[j][1]);
                q.offer(new int[]{i, j, dist});
            }
        }

        List<int[]> edges = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int xi = points[i][0], yi = points[i][1];
                int xj = points[j][0], yj = points[j][1];
                // 用坐标点在 points 中的索引表示坐标点
                edges.add(new int[] {
                        i, j, Math.abs(xi - xj) + Math.abs(yi - yj)
                });
            }
        }



        int res = 0;

        for(int[] cur : edges){
            if(uf.isConnected(cur[0], cur[1])){
                continue;
            }
            uf.union(cur[0], cur[1]);
            res += cur[2];
            if(uf.count()==1){
                return res;
            }
        }

        return res;

    }
}
class UF1584{

    int count;
    int[] parent;
    int[] size;

    public UF1584(int n){
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