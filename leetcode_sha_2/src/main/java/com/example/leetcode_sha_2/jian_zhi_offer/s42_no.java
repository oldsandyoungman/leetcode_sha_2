package com.example.leetcode_sha_2.jian_zhi_offer;

public class s42_no {

    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(nums));
    }

//    输入一个整型数组，数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。
//
//    要求时间复杂度为O(n)。

    public static int maxSubArray(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];

        int max_sha = nums[0];

        for(int i=1; i<n; i++){
            int tmp = nums[i] + Math.max(dp[i-1], 0);
            dp[i] = tmp;
            max_sha = Math.max(max_sha, tmp);
        }

        return max_sha;

    }

}
