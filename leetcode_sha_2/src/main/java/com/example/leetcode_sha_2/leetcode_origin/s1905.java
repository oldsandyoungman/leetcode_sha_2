package com.example.leetcode_sha_2.leetcode_origin;

public class s1905 {

    public static void main(String[] args) {
        int[][] grid1 = {
                {1,1,1,0,0},
                {0,1,1,1,1},
                {0,0,0,0,0},
                {1,0,0,0,0},
                {1,1,0,1,1}
        };

        int[][] grid2 = {
                {1,1,1,0,0},
                {0,0,1,1,1},
                {0,1,0,0,0},
                {1,0,1,1,0},
                {0,1,0,1,0}
        };

        System.out.println(countSubIslands(grid1, grid2));

    }

//    给你两个 m x n 的二进制矩阵 grid1 和 grid2 ，它们只包含 0 （表示水域）和 1 （表示陆地）。一个 岛屿 是由 四个方向 （水平或者竖直）上相邻的 1 组成的区域。任何矩阵以外的区域都视为水域。
//
//    如果 grid2 的一个岛屿，被 grid1 的一个岛屿 完全 包含，也就是说 grid2 中该岛屿的每一个格子都被 grid1 中同一个岛屿完全包含，那么我们称 grid2 中的这个岛屿为 子岛屿 。
//
//    请你返回 grid2 中 子岛屿 的 数目 。
//
//    来源：力扣（LeetCode）
//    链接：https://leetcode-cn.com/problems/count-sub-islands
//    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。






    public static int countSubIslands(int[][] grid1, int[][] grid2) {
        int m = grid1.length;
        int n = grid1[0].length;
        int res = 0;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid2[i][j]==1){
                    boolean flag = dfs(grid1, grid2, i, j);
                    if(flag){
                        res++;
                    }
                }
            }
        }
        return res;
    }
    public static boolean dfs(int[][] grid1, int[][] grid2, int i, int j){
        int m = grid1.length;
        int n = grid1[0].length;
        if(i<0 || i>=m || j<0 || j>=n){
            return true;
        }
        if(grid2[i][j]==0){
            return true;
        }

        grid2[i][j] = 0;
        if(grid1[i][j]==0){
            return false;
        }

        boolean f1 = dfs(grid1, grid2, i-1, j);
        boolean f2 = dfs(grid1, grid2, i+1, j);
        boolean f3 = dfs(grid1, grid2, i, j-1);
        boolean f4 = dfs(grid1, grid2, i, j+1);
        return f1 && f2 && f3 && f4;

    }






//    public static int countSubIslands(int[][] grid1, int[][] grid2) {
//        int m = grid1.length;
//        int n = grid1[0].length;
//
//        for (int i = 0; i < m; i++) {
//            for (int j = 0; j < n; j++) {
//                if (grid1[i][j]==0 && grid2[i][j]==1){
//                    dfs(grid2, i, j);
//                }
//            }
//        }
//
//        int res = 0;
//
//        for (int i = 0; i < m; i++) {
//            for (int j = 0; j < n; j++) {
//                if (grid2[i][j] == 1){
//                    res++;
//                    dfs(grid2, i, j);
//                }
//            }
//        }
//
//        return res;
//
//
//    }
//
//    public static void dfs(int[][] grid, int i, int j){
//        int m = grid.length;
//        int n = grid[0].length;
//
//        if (i<0 || j<0 || i>=m || j>=n){
//            return;
//        }
//        if (grid[i][j]==0){
//            return;
//        }
//        grid[i][j] = 0;
//        dfs(grid, i+1, j);
//        dfs(grid, i-1, j);
//        dfs(grid, i, j+1);
//        dfs(grid, i, j-1);
//
//    }



}
