package com.example.leetcode_sha_2.leetcode_origin;

import java.util.LinkedList;

public class s207 {

    public static void main(String[] args) {
        int numCourses = 2;
        int[][] prerequisites = {{1,0}};
        System.out.println(canFinish(numCourses, prerequisites));
    }


// 返回值类型是boolean
//    public static boolean canFinish(int numCourses, int[][] prerequisites) {
//        path = new boolean[numCourses];
//        visited = new boolean[numCourses];
//
//
//        LinkedList<Integer>[] graph = new LinkedList[numCourses];
//        for(int i=0; i<numCourses; i++){
//            graph[i] = new LinkedList<>();
//        }
//        for(int[] tmp : prerequisites){
//            graph[tmp[1]].addLast(tmp[0]);
//        }
//
//        for(int i=0; i<numCourses; i++){
//            if(!dfs(graph, i)){
//                return false;
//            }
//        }
//
//        return true;
//
//    }
//
//    static boolean[] path;
//    static boolean[] visited;
//
//    public static boolean dfs(LinkedList<Integer>[] graph, int cur){
//
//
//        if(path[cur]){
//            return false;
//        }
//
//        if(visited[cur]){
//            return true;
//        }
//
//        path[cur] = true;
//        visited[cur] = true;
//
//        for(int next : graph[cur]){
//            if(!dfs(graph, next)){
//                return false;
//            }
//        }
//
//        path[cur] = false;
//        // visited[cur] = false;
//
//        return true;
//
//    }



// 返回值类型是 void

    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        path = new boolean[numCourses];
        visited = new boolean[numCourses];
        hasCycle = false;

        LinkedList<Integer>[] graph = new LinkedList[numCourses];
        for(int i=0; i<numCourses; i++){
            graph[i] = new LinkedList<>();
        }
        for(int[] tmp : prerequisites){
            graph[tmp[1]].addLast(tmp[0]);
        }

        for(int i=0; i<numCourses; i++){
            dfs(graph, i);
        }

        return !hasCycle;

    }

    static boolean[] path;
    static boolean[] visited;
    static boolean hasCycle;

    public static void dfs(LinkedList<Integer>[] graph, int cur){

        if(hasCycle){
            return;
        }

        if(path[cur]){
            hasCycle = true;
            return;
        }

        if(visited[cur]){
            return;
        }

        path[cur] = true;
        visited[cur] = true;

        for(int next : graph[cur]){
            dfs(graph, next);
        }

        path[cur] = false;
        // visited[cur] = false;


    }


}
