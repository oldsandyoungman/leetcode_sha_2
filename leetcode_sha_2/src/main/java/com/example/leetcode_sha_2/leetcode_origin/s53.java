package com.example.leetcode_sha_2.leetcode_origin;

import java.util.Arrays;

public class s53 {

    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(nums));
    }

    public static int maxSubArray(int[] nums) {
//         int n = nums.length;
//         // dp[i]: 以nums[i]结尾的最大子数组和
//         int[] dp = new int[n];
//         Arrays.fill(dp, -10001);
//         dp[0] = nums[0];
//
//         for(int i=1; i<n; i++){
//             dp[i] = Math.max(dp[i-1], 0) + nums[i];
//         }
//
//         int res = -10001;
//         for(int i=0; i<n; i++){
//             res = Math.max(res, dp[i]);
//         }
//
//         return res;



        // 空间压缩
        int n = nums.length;
        // dp[i]: 以nums[i]结尾的最大子数组和
        // int[] dp = new int[n];
        // Arrays.fill(dp, -10001);
        // dp[0] = nums[0];

        int dp = nums[0];
        int res = nums[0];

        for(int i=1; i<n; i++){
            int tmp = dp;
            dp = Math.max(dp, 0) + nums[i];
            res = Math.max(res, dp);
        }

        return res;

    }

}
