package com.example.leetcode_sha_2.leetcode_origin;

public class s122 {

    public static void main(String[] args) {

    }

//    给定一个数组 prices ，其中 prices[i] 是一支给定股票第 i 天的价格。
//
//    设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
//
//    注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
//
//    来源：力扣（LeetCode）
//    链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii
//    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

    public int maxProfit(int[] prices) {
        int n = prices.length;
        int min_sha = Integer.MIN_VALUE/2;


        // // int[i][j][k]
        // // i:第i天晚上结束（从第0天开始算）
        // // j:手上是否持有股票（0是未持有）
        // // k:还有几次购买机会
        // int[][] dp = new int[n+1][2];


        // dp[0][0] = 0;
        // dp[0][1] = min_sha;



        // for(int i=1; i<=n; i++){
        //     dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1]+prices[i-1]);
        //     // dp[i][0][1] = 0;
        //     dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0]-prices[i-1]);
        //     // dp[i][1][1] = min_sha;
        // }

        // return dp[n][0];



        // int[i][j][k]
        // i:第i天晚上结束（从第0天开始算）
        // j:手上是否持有股票
        // k:还有几次购买机会
        // int[][][] dp = new int[n+1][2][2];


        int dp0 = 0;
        int dp1 = min_sha;


        for(int i=1; i<=n; i++){
            int tmp = dp0;
            dp0 = Math.max(dp0, dp1+prices[i-1]);
            // dp[i][0][1] = 0;
            dp1 = Math.max(dp1, tmp-prices[i-1]);
            // dp[i][1][1] = min_sha;
        }

        return dp0;

    }

}
