package com.example.leetcode_sha_2.jian_zhi_offer;

public class s13 {

    public static void main(String[] args) {

    }

//    地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。一个机器人从坐标 [0, 0] 的格子开始移动，它每次可以向左、右、上、下移动一格（不能移动到方格外），也不能进入行坐标和列坐标的数位之和大于k的格子。例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。但它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？
//
//    来源：力扣（LeetCode）
//    链接：https://leetcode-cn.com/problems/ji-qi-ren-de-yun-dong-fan-wei-lcof
//    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

    public static int movingCount(int m, int n, int k) {
        boolean[][] visited = new boolean[m][n];
        return dfs(visited, 0, 0, m, n, k);
    }
    public static int dfs(boolean[][] visited, int i, int j, int m, int n, int k){
        if(i>=m || j>= n || bitSum(i, j)>k || visited[i][j]){
            return 0;
        }
        visited[i][j] = true;
        return 1 + dfs(visited, i+1, j, m, n, k) + dfs(visited, i, j+1, m, n, k);
    }
    public static int bitSum(int i, int j){
        int s = 0;
        while(i>0){
            s += i%10;
            i /= 10;
        }
        while(j>0){
            s += j%10;
            j /= 10;
        }
        return s;
    }


}
