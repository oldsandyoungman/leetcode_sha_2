package com.example.leetcode_sha_2.microsoft_sha;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.LinkedList;

public class sha3 {

    public static void main(String[] args) {
        int[] A = {0, 1, 1, 3, 0};
        int[] B = {1, 2, 3, 4, 5};
        int[] H = {2, 4};
        System.out.println(solution(6, A, B, H));
    }


    public static int solution(int N, int[] A, int[] B, int[] H) {
        // write your code in Java SE 8

        LinkedList<Integer>[] graph = new LinkedList[N];

        for(int i=0; i<N; i++){
            graph[i] = new LinkedList<>();
        }

        for(int i=0; i<A.length; i++){
            graph[A[i]].addLast(B[i]);
            graph[B[i]].addLast(A[i]);
        }

        int[] res = new int[N];
        Arrays.fill(res, N+1);

        for(int start : H){
            int[] tmp_res = minDis(N, graph, start);

            for(int i=0; i<N; i++){
                res[i] = Math.min(res[i], tmp_res[i]);
            }

        }

        int max_res = 0;
        for(int tmp : res){
            max_res = Math.max(max_res, tmp);
        }

        return  max_res==(N+1)?-1:max_res;

    }


    public static int[] minDis(int N, LinkedList<Integer>[] graph, int start) {
        int[] res = new int[N];
        ArrayDeque<State> q = new ArrayDeque<>();
        q.addLast(new State(start, 0));
        Arrays.fill(res, N+1);
        res[start] = 0;

        while(!q.isEmpty()){
            State cur = q.removeFirst();
            int curId = cur.id;
            int disFromCurToStart = cur.disFromStart;

            if(res[curId]<disFromCurToStart){
                continue;
            }

            for(int next : graph[curId]){
                int disFromNextToStart =  disFromCurToStart + 1;
                if(disFromNextToStart<res[next]){
                    res[next] = disFromNextToStart;
                    q.addLast(new State(next, disFromNextToStart));
                }
            }

        }

        return res;

    }

}

class State{
    int id;
    int disFromStart;

    public State(int aa, int bb){
        id = aa;
        disFromStart = bb;
    }


}
