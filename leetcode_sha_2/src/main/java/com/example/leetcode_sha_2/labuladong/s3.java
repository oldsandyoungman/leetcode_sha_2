package com.example.leetcode_sha_2.labuladong;

public class s3 {

    public static void main(String[] args) {
        int N = 3;
        int W = 4;
        int[] wt = {2, 1, 3};
        int[] val = {4, 2, 3};

        System.out.println(maxVal(N, W, wt, val));

    }

    // 0/1背包问题
    // https://labuladong.gitee.io/algo/3/25/85/

//    private static int maxVal(int N, int W, int[] wt, int[] val) {
//        // dp[i][j]: 前i个物品背包容量为j时，能装的最大价值
//        int[][] dp = new int[N+1][W+1];
//        // 初始化 dp[0][j] 和 dp[i][0] 都为 0
////        for(int i=0; i<=N; i++){
////            dp[i][0] = 0;
////        }
////        for(int i=0; i<=N; i++){
////            dp[i][0] = 0;
////        }
//
//        for(int i=1; i<=N; i++){
//            for(int j=1; j<=W; j++){
//                if(j>=wt[i-1]){
//                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-wt[i-1]]+val[i-1]);
//                }else{
//                    dp[i][j] = dp[i-1][j];
//                }
//            }
//        }
//
//        return dp[N][W];
//
//    }


    private static int maxVal(int N, int W, int[] wt, int[] val) {
        // dp[i][j]: 从0~i-1个物品里选择，在重量不超过W的条件，取得的最大价值
        int[][] dp = new int[N+1][W+1];
        // base: dp[i][0]=0，dp[0][i]=0;
//        for(int i=0; i<=N; i++){
//            dp[i][0] = 0;
//        }
//        for(int i=0; i<=W; i++){
//            dp[i][0] = 0;
//        }

        for(int i=1; i<=N; i++){
            for(int j=1; j<=W; j++){
                if(wt[i-1]<=j){
                    dp[i][j] = Math.max(dp[i-1][j-wt[i-1]]+val[i-1], dp[i-1][j]);
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        return dp[N][W];

    }



}
