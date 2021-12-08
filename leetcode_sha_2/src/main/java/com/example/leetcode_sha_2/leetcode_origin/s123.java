package com.example.leetcode_sha_2.leetcode_origin;

public class s123 {

    public static void main(String[] args) {

    }

//    给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。
//
//    设计一个算法来计算你所能获取的最大利润。你最多可以完成 两笔 交易。
//
//    注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
//
//    来源：力扣（LeetCode）
//    链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iii
//    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

    public int maxProfit(int[] prices) {
        int n = prices.length;
        int min_sha = Integer.MIN_VALUE/2;


        // // int[i][j][k]
        // // i:第i天晚上结束（从第0天开始算，并且第i天的股价是prices[i-1]）
        // // j:手上是否持有股票
        // // k:还有几次购买机会
        // int[][][] dp = new int[n+1][2][3];


        // dp[0][0][0] = min_sha;
        // dp[0][0][1] = min_sha;
        // dp[0][0][2] = 0;
        // dp[0][1][0] = min_sha;
        // dp[0][1][1] = min_sha;
        // dp[0][1][2] = min_sha;


        // for(int i=1; i<=n; i++){
        //     dp[i][0][0] = Math.max(dp[i-1][0][0], dp[i-1][1][0]+prices[i-1]);
        //     dp[i][0][1] = Math.max(dp[i-1][0][1], dp[i-1][1][1]+prices[i-1]);
        //     // dp[i][0][2] = 0;
        //     dp[i][1][0] = Math.max(dp[i-1][1][0], dp[i-1][0][1]-prices[i-1]);
        //     dp[i][1][1] = Math.max(dp[i-1][1][1], dp[i-1][0][2]-prices[i-1]);
        //     // dp[i][1][2] = min_sha;
        // }

        // return Math.max(Math.max(dp[n][0][0], dp[n][0][1]), dp[n][0][2]);



        // int[i][j][k]
        // i:第i天晚上结束（从第0天开始算）
        // j:手上是否持有股票（0是未持有）
        // k:还有几次购买机会
        // int[][][] dp = new int[n+1][2][2];


        int dp00 = min_sha;
        int dp01 = min_sha;
        int dp02 = 0;
        int dp10 = min_sha;
        int dp11 = min_sha;
        int dp12 = min_sha;

        for(int i=1; i<=n; i++){
            dp00 = Math.max(dp00, dp10+prices[i-1]);
            dp01 = Math.max(dp01, dp11+prices[i-1]);
            // dp[i][0][2] = 0;
            dp10 = Math.max(dp10, dp01-prices[i-1]);
            dp11 = Math.max(dp11, dp02-prices[i-1]);
            // dp[i][1][2] = min_sha;
        }

        return Math.max(Math.max(dp00, dp01), dp02);

    }

}
