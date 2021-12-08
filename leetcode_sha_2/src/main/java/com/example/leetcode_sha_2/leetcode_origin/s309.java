package com.example.leetcode_sha_2.leetcode_origin;

public class s309 {

    public static void main(String[] args) {

    }

//    给定一个整数数组，其中第 i 个元素代表了第 i 天的股票价格 。​
//
//    设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）:
//
//    你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
//    卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。
//
//    来源：力扣（LeetCode）
//    链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-cooldown
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
        // dp[1][0] = 0;
        // dp[1][1] = -prices[0];

        // for(int i=2; i<=n; i++){
        //     dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1]+prices[i-1]);
        //     // dp[i][0][1] = 0;
        //     dp[i][1] = Math.max(dp[i-1][1], dp[i-2][0]-prices[i-1]);
        //     // dp[i][1][1] = min_sha;
        // }

        // return dp[n][0];



        // int[i][j][k]
        // i:第i天晚上结束（从第0天开始算）
        // j:手上是否持有股票
        // k:还有几次购买机会
        // int[][][] dp = new int[n+1][2][2];

        //第1天的结果，而非第0天的结果
        int dp0 = 0;
        int dp1 = -prices[0];

        //第0天的dp0
        int tmp_pre = 0;
        //第1天的dp0
        int tmp_cur = 0;

        for(int i=2; i<=n; i++){

            dp0 = Math.max(dp0, dp1+prices[i-1]);
            // dp[i][0][1] = 0;
            dp1 = Math.max(dp1, tmp_pre-prices[i-1]);
            // dp[i][1][1] = min_sha;
            tmp_pre = tmp_cur;
            tmp_cur = dp0;

        }

        return dp0;
    }


}
