package com.example.leetcode_sha_2.leetcode_origin;

public class s695_no {

    public static void main(String[] args) {
        int[][] grid = {
                {0,0,1,0,0,0,0,1,0,0,0,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,1,1,0,1,0,0,0,0,0,0,0,0},
                {0,1,0,0,1,1,0,0,1,0,1,0,0},
                {0,1,0,0,1,1,0,0,1,1,1,0,0},
                {0,0,0,0,0,0,0,0,0,0,1,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,0,0,0,0,0,0,1,1,0,0,0,0}
        };

        System.out.println(maxAreaOfIsland(grid));

    }

//    给你一个大小为 m x n 的二进制矩阵 grid 。
//
//    岛屿 是由一些相邻的 1 (代表土地) 构成的组合，这里的「相邻」要求两个 1 必须在 水平或者竖直的四个方向上 相邻。你可以假设 grid 的四个边缘都被 0（代表水）包围着。
//
//    岛屿的面积是岛上值为 1 的单元格的数目。
//
//    计算并返回 grid 中最大的岛屿面积。如果没有岛屿，则返回面积为 0
//
//    来源：力扣（LeetCode）
//    链接：https://leetcode-cn.com/problems/max-area-of-island
//    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。


    public static int maxAreaOfIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int res = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j]==1){
                    res = Math.max(res, dfs(grid, i, j));
                }
            }
        }

        return res;
    }

    public static int dfs(int[][] grid, int i, int j){
        int m = grid.length;
        int n = grid[0].length;
        if (i<0 || j<0 || i>=m || j>=n){
            return 0;
        }
        if (grid[i][j]==0){
            return 0;
        }
        grid[i][j] = 0;
//        for (int[] ints : dir) {
//            int next_i = i + ints[0];
//            int next_j = j + ints[1];
//            dfs(grid, next_i, next_j);
//        }

        return dfs(grid, i+1, j) +
                dfs(grid, i-1, j) +
                dfs(grid, i, j+1) +
                dfs(grid, i, j-1) + 1;

    }


}
