package com.example.leetcode_sha_2.leetcode_origin;

public class s877 {

    public static void main(String[] args) {
        int[] piles = {2, 8, 3, 5};
        System.out.println(stoneGame(piles));
    }

//    Alice 和 Bob 用几堆石子在做游戏。一共有偶数堆石子，排成一行；每堆都有 正 整数颗石子，数目为 piles[i] 。
//
//    游戏以谁手中的石子最多来决出胜负。石子的 总数 是 奇数 ，所以没有平局。
//
//    Alice 和 Bob 轮流进行，Alice 先开始 。 每回合，玩家从行的 开始 或 结束 处取走整堆石头。 这种情况一直持续到没有更多的石子堆为止，此时手中 石子最多 的玩家 获胜 。
//
//    假设 Alice 和 Bob 都发挥出最佳水平，当 Alice 赢得比赛时返回 true ，当 Bob 赢得比赛时返回 false 。
//
//    来源：力扣（LeetCode）
//    链接：https://leetcode-cn.com/problems/stone-game
//    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

    public static boolean stoneGame(int[] piles) {
        int n = piles.length;

        int[][][] dp = new int[n][n][2];

        for(int i=0; i<n; i++){
            dp[i][i][0] = piles[i];
            dp[i][i][1] = 0;
        }

        for(int i=n-2; i>=0; i--){
            for(int j=i+1; j<n; j++){

                // 如果选左边
                int left = dp[i+1][j][1]+piles[i];
                int right = dp[i][j-1][1]+piles[j];

                if(left>right){
                    dp[i][j][0] = left;
                    dp[i][j][1] = dp[i+1][j][0];
                }else{
                    dp[i][j][0] = right;
                    dp[i][j][1] = dp[i][j-1][0];
                }
            }
        }

        return dp[0][n-1][0] > dp[0][n-1][1];

    }

}
