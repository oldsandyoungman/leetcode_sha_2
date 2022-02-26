package com.example.leetcode_sha_2.labuladong;

import java.util.List;
import java.util.PriorityQueue;

public class s6 {

    public static void main(String[] args) {

    }

    // prim最小生成树
//    https://labuladong.gitee.io/algo/2/19/41/


}



class Prim{

    PriorityQueue<int[]> q;
    boolean[] inMst;
    List<int[]>[] graph;
    int weightSum;

    public Prim(List<int[]>[] graph){
        this.graph = graph;
        q = new PriorityQueue<>((o1, o2) -> {
            return Integer.compare(o1[2], o2[2]);
        });

        int n = graph.length;
        inMst = new boolean[n];
        weightSum = 0;

        inMst[0] = true;
        cut(0);

        while(!q.isEmpty()){
            int[] cur = q.poll();
            if (inMst[cur[1]]){
                continue;
            }

            weightSum += cur[2];
            inMst[cur[1]] = true;
            cut(cur[1]);

        }


    }

    // 最小生成树的权重和
    public int weightSum() {
        return weightSum;
    }

    public boolean allConnected() {
        for (int i = 0; i < inMst.length; i++) {
            if (!inMst[i]) {
                return false;
            }
        }
        return true;
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







}
