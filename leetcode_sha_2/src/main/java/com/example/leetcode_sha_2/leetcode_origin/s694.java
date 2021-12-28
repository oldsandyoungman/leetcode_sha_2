package com.example.leetcode_sha_2.leetcode_origin;

import java.util.HashMap;
import java.util.HashSet;

public class s694 {

    public static void main(String[] args) {
        int[][] grid = {
                {1,1,0,1,1},
                {1,0,0,0,0},
                {0,0,0,0,1},
                {1,1,0,1,1}
        };

        System.out.println(numDistinctIslands(grid));

        HashMap<Character, Integer> m = new HashMap<>();


    }

//    力扣第 694 题「不同的岛屿数量」，题目还是输入一个二维矩阵，0 表示海水，1 表示陆地，这次让你计算 不同的 (distinct) 岛屿数量，函数签名如下：
//    https://labuladong.gitee.io/algo/1/7/



    public static int numDistinctIslands(int[][] grid){
        int m = grid.length;
        int n = grid[0].length;

        HashSet<String> s = new HashSet<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j]==1) {
                    StringBuilder sb = new StringBuilder();
                    dfs(grid, i, j, sb, 0);
                    s.add(sb.toString());
                }
            }
        }
        return s.size();

    }

    public static void dfs(int[][] grid, int i, int j, StringBuilder sb, int dir){
        int m = grid.length;
        int n = grid[0].length;
        if(i<0 || i>=m || j<0 || j>=n){
            return;
        }
        if (grid[i][j]==0) {
            return;
        }
        grid[i][j] = 0;
        sb.append(dir).append(",");

        dfs(grid, i-1, j, sb, 1);
        dfs(grid, i+1, j, sb, 2);
        dfs(grid, i, j-1, sb, 3);
        dfs(grid, i, j+1, sb, 4);

    }



//    public static int numDistinctIslands(int[][] grid){
//        int m = grid.length;
//        int n = grid[0].length;
//
//        HashSet<String> s = new HashSet<>();
//
//        for (int i = 0; i < m; i++) {
//            for (int j = 0; j < n; j++) {
//                if (grid[i][j]==1){
//                    StringBuilder sb = new StringBuilder();
//                    dfs(grid, i, j, sb, 666);
//                    s.add(sb.toString());
//                }
//            }
//        }
//
//        return s.size();
//
//    }
//
//    public static void dfs(int[][] grid, int i, int j, StringBuilder sb, int dir){
//        int m = grid.length;
//        int n = grid[0].length;
//
//        if (i<0 || j<0 || i>=m || j>=n){
//            return;
//        }
//        if (grid[i][j]==0){
//            return;
//        }
//
//        grid[i][j] = 0;
//        sb.append(dir);
//        sb.append(",");
//
//        dfs(grid, i+1, j, sb, 1);
//        dfs(grid, i-1, j, sb, 2);
//        dfs(grid, i, j+1, sb, 3);
//        dfs(grid, i, j-1, sb, 4);
//
////        sb.append(-dir);
////        sb.append(",");
//
//    }


}
