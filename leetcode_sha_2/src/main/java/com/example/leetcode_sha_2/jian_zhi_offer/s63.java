package com.example.leetcode_sha_2.jian_zhi_offer;

public class s63 {

    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        System.out.println(maxProfit(prices));
    }

//    假设把某股票的价格按照时间先后顺序存储在数组中，请问买卖该股票一次可能获得的最大利润是多少？

    public static int maxProfit2(int[] prices) {
        int n = prices.length;
        int min_sha = Integer.MIN_VALUE/2;
        //dp[i][j][k]:
        //i：第i天
        //j：手里有无股票（有为1）
        //k：还有几次买卖机会
        int[][][] dp = new int[n+1][2][2];

        dp[0][0][1] = 0;
        dp[0][0][0] = min_sha;
        dp[0][1][1] = min_sha;
        dp[0][1][0] = min_sha;

        for(int i=1; i<=n; i++){
            dp[i][0][0] = Math.max(dp[i-1][0][0], dp[i-1][1][0]+prices[i-1]);
            // dp[i][0][1] = 0;
            dp[i][1][0] = Math.max(dp[i-1][1][0], dp[i-1][0][1]-prices[i-1]);
            dp[i][1][1] = min_sha;
        }

        return Math.max(dp[n][0][0], dp[n][0][1]);


    }

    public static int maxProfit(int[] prices) {
        int n = prices.length;
        int min_sha = Integer.MIN_VALUE/2;
        //dp[i][j][k]:
        //i：第i天
        //j：手里有无股票（有为1）
        //k：还有几次买卖机会
        // int[][][] dp = new int[n+1][2][2];

        int dp01 = 0;
        int dp00 = min_sha;
        int dp11 = min_sha;
        int dp10 = min_sha;

        // dp[0][0][1] = 0;
        // dp[0][0][0] = min_sha;
        // dp[0][1][1] = min_sha;
        // dp[0][1][0] = min_sha;

        for(int i=1; i<=n; i++){
            dp00 = Math.max(dp00, dp10+prices[i-1]);
            // dp01 = 0;
            dp10 = Math.max(dp10, dp01-prices[i-1]);
            // dp11 = min_sha;





            // dp[i][0][0] = Math.max(dp[i-1][0][0], dp[i-1][1][0]+prices[i-1]);
            // // dp[i][0][1] = 0;
            // dp[i][1][0] = Math.max(dp[i-1][1][0], dp[i-1][0][1]-prices[i-1]);
            // // dp[i][1][1] = min_sha;
        }

        return Math.max(dp00, dp01);
        // return Math.max(dp[n][0][0], dp[n][0][1]);


    }

}
