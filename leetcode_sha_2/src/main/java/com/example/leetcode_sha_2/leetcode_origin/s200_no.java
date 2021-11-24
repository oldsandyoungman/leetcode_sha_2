package com.example.leetcode_sha_2.leetcode_origin;

public class s200_no {

    public static void main(String[] args) {
        char[][] grids = {
                {'1','1','1','1','0'},
                {'1','1','0','1','0'},
                {'1','1','0','0','0'},
                {'0','0','0','0','0'}
        };

        System.out.println(numIslands(grids));

    }

//    给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
//
//    岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
//
//    此外，你可以假设该网格的四条边均被水包围。
//
//    来源：力扣（LeetCode）
//    链接：https://leetcode-cn.com/problems/number-of-islands
//    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。


    public static int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int res = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j]=='1'){
                    res++;
                    dfs(grid, i, j);
                }
            }
        }

        return res;

    }
//    public static int[][] dir = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public static void dfs(char[][] grid, int i, int j){
        int m = grid.length;
        int n = grid[0].length;
        if (i<0 || j<0 || i>=m || j>=n){
            return;
        }
        if (grid[i][j]=='0'){
            return;
        }
        grid[i][j] = '0';
//        for (int[] ints : dir) {
//            int next_i = i + ints[0];
//            int next_j = j + ints[1];
//            dfs(grid, next_i, next_j);
//        }

        dfs(grid, i+1, j);
        dfs(grid, i-1, j);
        dfs(grid, i, j+1);
        dfs(grid, i, j-1);


    }

}
