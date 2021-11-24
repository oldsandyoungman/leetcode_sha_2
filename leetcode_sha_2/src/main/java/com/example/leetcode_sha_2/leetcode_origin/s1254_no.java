package com.example.leetcode_sha_2.leetcode_origin;

public class s1254_no {

    public static void main(String[] args) {
        int[][] grid = {
                {1,1,1,1,1,1,1,0},
                {1,0,0,0,0,1,1,0},
                {1,0,1,0,1,1,1,0},
                {1,0,0,0,0,1,0,1},
                {1,1,1,1,1,1,1,0}
        };

        System.out.println(closedIsland(grid));

    }

//    有一个二维矩阵 grid ，每个位置要么是陆地（记号为 0 ）要么是水域（记号为 1 ）。
//
//    我们从一块陆地出发，每次可以往上下左右 4 个方向相邻区域走，能走到的所有陆地区域，我们将其称为一座「岛屿」。
//
//    如果一座岛屿 完全 由水域包围，即陆地边缘上下左右所有相邻区域都是水域，那么我们将其称为 「封闭岛屿」。
//
//    请返回封闭岛屿的数目。
//
//    来源：力扣（LeetCode）
//    链接：https://leetcode-cn.com/problems/number-of-closed-islands
//    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。


    public static int closedIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        for (int i = 0; i < m; i++) {
            dfs(grid, i, 0);
            dfs(grid, i, n-1);
        }

        for (int i = 0; i < n; i++) {
            dfs(grid, 0, i);
            dfs(grid, m-1, i);
        }

        int res = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j]==0){
                    res++;
                    dfs(grid, i, j);
                }
            }
        }

        return res;

    }

    public static void dfs(int[][] grid, int i, int j){
        int m = grid.length;
        int n = grid[0].length;
        if (i<0 || j<0 || i>=m || j>=n){
            return;
        }
        if (grid[i][j] == 1){
            return;
        }
        grid[i][j] = 1;
        dfs(grid, i+1, j);
        dfs(grid, i-1, j);
        dfs(grid, i, j+1);
        dfs(grid, i, j-1);

    }


}
