package com.example.leetcode_sha_2.leetcode_origin;

import java.util.Arrays;

public class s416 {

    public static void main(String[] args) {
        int[] nums = {1,5,11,5};
        System.out.println(canPartition(nums));
    }

    // dp[i][j]定义为前i个物品质量不超过j的最大质量和
    public static boolean canPartition(int[] nums) {
        int n = nums.length;

        int sum = 0;

        for(int tmp : nums){
            sum += tmp;
        }

        if(sum%2==1){
            return false;
        }

        Arrays.sort(nums);
        int left = 0;
        int right = n-1;
        while(left<right){
            int tmp = nums[left];
            nums[left] = nums[right];
            nums[right] = tmp;
            left++;
            right--;
        }

        int target = sum/2;


        int[][] dp = new int[n+1][target+1];
        // dp[0][i] = 0, dp[0][0] = 0

        for(int i=1; i<=n; i++){
            for(int j=0; j<=target; j++){
                if(j>=nums[i-1]){
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-nums[i-1]]+nums[i-1]);
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        return dp[n][target]==target;


    }

    // dp[i][j]定义为前i个物品是否能凑到质量等于j

    public boolean canPartition2(int[] nums) {
        int n = nums.length;

        int sum = 0;

        for(int tmp : nums){
            sum += tmp;
        }

        if(sum%2==1){
            return false;
        }

        Arrays.sort(nums);
        int left = 0;
        int right = n-1;
        while(left<right){
            int tmp = nums[left];
            nums[left] = nums[right];
            nums[right] = tmp;
            left++;
            right--;
        }

        int target = sum/2;

        // // dp[i][j]：前i个物品，容量上限为j的背包，最多能装多少
        // int[][] dp = new int[n+1][target+1];
        // // dp[0][i] = 0, dp[0][0] = 0

        // for(int i=1; i<=n; i++){
        //     for(int j=0; j<=target; j++){
        //         if(j>=nums[i-1]){
        //             dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-nums[i-1]]+nums[i-1]);
        //             // int tmp = dp[i-1][j-nums[i-1]]+nums[i-1];
        //             // if(tmp<=target){
        //             //     dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-nums[i-1]]+nums[i-1]);
        //             // }
        //         }else{
        //             dp[i][j] = dp[i-1][j];
        //         }
        //     }
        // }

        // return dp[n][target]==target;

        // dp[i][j]：前i个物品，容量上限为j的背包，是否能装满
        boolean[][] dp = new boolean[n+1][target+1];
        // dp[0][i] = false, dp[0][0] = true
        dp[0][0] = true;

        for(int i=1; i<=n; i++){
            for(int j=0; j<=target; j++){
                if(j>=nums[i-1]){
                    dp[i][j] = dp[i-1][j] || dp[i-1][j-nums[i-1]];
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        return dp[n][target];

    }

}
