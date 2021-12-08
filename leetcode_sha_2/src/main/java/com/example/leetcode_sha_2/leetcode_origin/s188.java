package com.example.leetcode_sha_2.leetcode_origin;

public class s188 {

    public static void main(String[] args) {

    }

//    给定一个整数数组 prices ，它的第 i 个元素 prices[i] 是一支给定的股票在第 i 天的价格。
//
//    设计一个算法来计算你所能获取的最大利润。你最多可以完成 k 笔交易。
//
//    注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
//
//    来源：力扣（LeetCode）
//    链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iv
//    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。


    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        int min_sha = Integer.MIN_VALUE/2;


        // // int[i][j][k]
        // // i:第i天晚上结束（从第0天开始算，并且第i天的股价是prices[i-1]）
        // // j:手上是否持有股票
        // // k:还有几次购买机会
        int[][][] dp = new int[n+1][2][k+1];

        for(int i=0; i<=k; i++){
            dp[0][0][i] = min_sha;
            dp[0][1][i] = min_sha;
        }
        dp[0][0][k] = 0;

        for(int i=1; i<=n; i++){

            for(int j=0; j<k; j++){
                dp[i][0][j] = Math.max(dp[i-1][0][j], dp[i-1][1][j]+prices[i-1]);
                dp[i][1][j] = Math.max(dp[i-1][1][j], dp[i-1][0][j+1]-prices[i-1]);
            }

            // dp[i][0][0] = Math.max(dp[i-1][0][0], dp[i-1][1][0]+prices[i-1]);
            // dp[i][0][1] = Math.max(dp[i-1][0][1], dp[i-1][1][1]+prices[i-1]);
            // // dp[i][0][2] = 0;
            // dp[i][1][0] = Math.max(dp[i-1][1][0], dp[i-1][0][1]-prices[i-1]);
            // dp[i][1][1] = Math.max(dp[i-1][1][1], dp[i-1][0][2]-prices[i-1]);
            // // dp[i][1][2] = min_sha;
        }

        int res = 0;
        for(int i=0; i<=k; i++){
            res = Math.max(res, dp[n][0][i]);
        }

        return res;
    }

}
