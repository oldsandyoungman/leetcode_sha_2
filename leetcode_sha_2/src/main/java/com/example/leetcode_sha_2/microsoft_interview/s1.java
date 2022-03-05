package com.example.leetcode_sha_2.microsoft_interview;

import java.util.ArrayList;
import java.util.List;

public class s1 {

    public static void main(String[] args) {
        int n = 4;
        List<Integer>[] graph = new ArrayList[n];
        for(int i=0; i<n; i++){
            graph[i] = new ArrayList<>();
        }
        graph[0].add(1);
//        graph[0].add(1);
        graph[0].add(2);
//        graph[1].add(2);
        graph[3].add(2);
//        graph[1].add(2);
//        graph[2].add(0);

        System.out.println(judge(graph, n));

    }

    public static boolean judge(List<Integer>[] graph, int n){
        visited = new boolean[n];
        onPath = new boolean[n];
        hasCycle = false;
        l = new ArrayList<>();

        for(int i=0; i<n; i++){
            dfs(graph, i);
        }

        System.out.println(l);

        return hasCycle;

    }

    static boolean[] visited;
    static boolean[] onPath;
    static boolean hasCycle;
    static List<Integer> l;

    public static void dfs(List<Integer>[] graph, int start){
        if(hasCycle){
            return;
        }

        if(onPath[start]){
            hasCycle = true;
            return;
        }

        if(visited[start]){
            return;
        }

        onPath[start] = true;
        visited[start] = true;



        for(int next : graph[start]){
            dfs(graph, next);
        }

        l.add(start);

        onPath[start] = false;


    }

}
