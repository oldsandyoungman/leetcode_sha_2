package com.example.leetcode_sha_2.leetcode_origin;

public class s121 {

    public static void main(String[] args) {

    }

//    给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。
//
//    你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
//
//    返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。
//
//    来源：力扣（LeetCode）
//    链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock
//    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。


    public int maxProfit(int[] prices) {
        int n = prices.length;
        int min_sha = Integer.MIN_VALUE/2;


        // // int[i][j][k]
        // // i:第i天晚上结束（从第0天开始算）
        // // j:手上是否持有股票
        // // k:还有几次购买机会
        // int[][][] dp = new int[n+1][2][2];


        // dp[0][0][0] = min_sha;
        // dp[0][0][1] = 0;
        // dp[0][1][0] = min_sha;
        // dp[0][1][1] = min_sha;


        // for(int i=1; i<=n; i++){
        //     dp[i][0][0] = Math.max(dp[i-1][0][0], dp[i-1][1][0]+prices[i-1]);
        //     // dp[i][0][1] = 0;
        //     dp[i][1][0] = Math.max(dp[i-1][1][0], -prices[i-1]);
        //     // dp[i][1][1] = min_sha;
        // }

        // return Math.max(dp[n][0][0], dp[n][0][1]);



        // int[i][j][k]
        // i:第i天晚上结束（从第0天开始算）
        // j:手上是否持有股票（0是未持有）
        // k:还有几次购买机会
        // int[][][] dp = new int[n+1][2][2];


        int dp00 = min_sha;
        int dp01 = 0;
        int dp10 = min_sha;
        int dp11 = min_sha;


        for(int i=1; i<=n; i++){
            dp00 = Math.max(dp00, dp10+prices[i-1]);
            // dp[i][0][1] = 0;
            dp10 = Math.max(dp10, -prices[i-1]);
            // dp[i][1][1] = min_sha;
        }

        return Math.max(dp00, dp01);


    }

}
