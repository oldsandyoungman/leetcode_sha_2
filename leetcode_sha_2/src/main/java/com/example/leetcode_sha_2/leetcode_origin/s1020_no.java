package com.example.leetcode_sha_2.leetcode_origin;

public class s1020_no {

    public static void main(String[] args) {
        int[][] grid = {
                {0,0,0,0},
                {1,0,1,0},
                {0,1,1,0},
                {0,0,0,0}
        };

        System.out.println(numEnclaves(grid));

    }

//    给出一个二维数组 A，每个单元格为 0（代表海）或 1（代表陆地）。
//
//    移动是指在陆地上从一个地方走到另一个地方（朝四个方向之一）或离开网格的边界。
//
//    返回网格中无法在任意次数的移动中离开网格边界的陆地单元格的数量。
//
//    来源：力扣（LeetCode）
//    链接：https://leetcode-cn.com/problems/number-of-enclaves
//    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

    public static int numEnclaves(int[][] grid) {
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
                if (grid[i][j]==1){
                    res++;
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
        if (grid[i][j] == 0){
            return;
        }
        grid[i][j] = 0;
        dfs(grid, i+1, j);
        dfs(grid, i-1, j);
        dfs(grid, i, j+1);
        dfs(grid, i, j-1);

    }

}
