package com.example.leetcode_sha_2.leetcode_origin;

public class s714 {

    public static void main(String[] args) {

    }

//    给定一个整数数组 prices，其中第 i 个元素代表了第 i 天的股票价格 ；整数 fee 代表了交易股票的手续费用。
//
//    你可以无限次地完成交易，但是你每笔交易都需要付手续费。如果你已经购买了一个股票，在卖出它之前你就不能再继续购买股票了。
//
//    返回获得利润的最大值。
//
//    注意：这里的一笔交易指买入持有并卖出股票的整个过程，每笔交易你只需要为支付一次手续费。
//
//    来源：力扣（LeetCode）
//    链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee
//    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。


    public int maxProfit(int[] prices, int fee) {
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
        //     dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0]-prices[i-1]-fee);
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
            dp1 = Math.max(dp1, tmp-prices[i-1]-fee);
            // dp[i][1][1] = min_sha;
        }

        return dp0;

    }

}
