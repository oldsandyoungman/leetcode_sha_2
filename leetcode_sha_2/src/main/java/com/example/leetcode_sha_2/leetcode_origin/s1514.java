package com.example.leetcode_sha_2.leetcode_origin;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class s1514 {

    public static void main(String[] args) {

        int n = 3;
        int[][] edges = new int[][]{{0,1},{1,2},{0,2}};
        double[] succProb = new double[]{0.5,0.5,0.2};
        int start = 0;
        int end = 2;

        System.out.println(maxProbability(n, edges, succProb, start, end));

    }

//    给你一个由 n 个节点（下标从 0 开始）组成的无向加权图，该图由一个描述边的列表组成，其中 edges[i] = [a, b] 表示连接节点 a 和 b 的一条无向边，且该边遍历成功的概率为 succProb[i] 。
//
//    指定两个节点分别作为起点 start 和终点 end ，请你找出从起点到终点成功概率最大的路径，并返回其成功概率。
//
//    如果不存在从 start 到 end 的路径，请 返回 0 。只要答案与标准答案的误差不超过 1e-5 ，就会被视作正确答案。
//
//    来源：力扣（LeetCode）
//    链接：https://leetcode-cn.com/problems/path-with-maximum-probability
//    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。



    public static double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {

        List<double[]>[] graph = new LinkedList[n];

        for(int i=0; i<n; i++){
            graph[i] = new LinkedList<>();
        }

        int sum = succProb.length;

        for(int i=0; i<sum; i++){
            int from = edges[i][0];
            int to = edges[i][1];
            graph[from].add(new double[]{(double)to, succProb[i]});
            graph[to].add(new double[]{(double)from, succProb[i]});
        }

        PriorityQueue<State3> q = new PriorityQueue<>((o1, o2) -> {
            return Double.compare(o2.distFromStart, o1.distFromStart);
        });

        q.offer(new State3(start, 1));

        double[] todist = new double[n];
        Arrays.fill(todist, -1);
        todist[start] = 1;

        while(!q.isEmpty()){
            State3 cur = q.poll();
            int curid = cur.id;
            double cur_distfromstart = cur.distFromStart;

            if(curid==end){
                return todist[end];
            }
            if(cur_distfromstart < todist[curid]){
                continue;
            }

            for(double[] nei : graph[curid]){
                int neiid = (int)nei[0];
                double neidist = nei[1];

                double tmpres = cur_distfromstart*neidist;

                if(tmpres>todist[neiid]){
                    todist[neiid] = tmpres;
                    q.offer(new State3(neiid, tmpres));
                }

            }

        }

        return 0.0;



    }

}

class State3{
    int id;
    double distFromStart;
    State3(int a, double b){
        id = a;
        distFromStart = b;
    }
}