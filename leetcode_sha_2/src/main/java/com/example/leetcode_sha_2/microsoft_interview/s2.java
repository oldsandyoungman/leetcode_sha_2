package com.example.leetcode_sha_2.microsoft_interview;

public class s2 {

    public static void main(String[] args) {
//        int[] nums = {1,2,0};
//        int[] nums = {3,4,-1,1};
//        int[] nums = {7,8,9,11,12};
//        int[] nums = {1};
//        int[] nums = {};
//        int[] nums = {2};
//        int[] nums = {-1};
        int[] nums = {1,1};
//        System.out.println(findMin(nums));

        System.out.println(firstMissingPositive(nums));


//        int[] nums = {1,3,5,2};
//        int[] nums = {1};
//        int[] nums = {};
//        System.out.println(calMax(nums));



    }

    public static int findMin(int[] nums){
        int n = nums.length;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]<=0){
                nums[i] = Integer.MAX_VALUE;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i])-1;
            if(index<n){
                if(nums[index]>0) {
                    nums[index] = -nums[index];
                }
            }
        }

        for(int i=0; i<n; i++){
            if(nums[i]>0){
                return i+1;
            }
        }

        return n+1;

    }

    public static int calMax(int[] nums){
        int n = nums.length;
        int[] dp = new int[n+2];
        for(int i=n-1; i>=0; i--){
            dp[i] = Math.max(dp[i+1], dp[i+2]+nums[i]);
        }

        return dp[0];

    }



    public static int firstMissingPositive(int[] nums) {

        int n = nums.length;

        for(int i=0; i<n; i++){

            while(nums[i]>0 && nums[i]<=n && nums[nums[i]-1]!=nums[i]){
                swap(nums, i, nums[i]-1);
            }

        }

        for (int i=0; i<n; i++){
            if(nums[i]-1!=i){
                return i+1;
            }
        }

        return n+1;


    }

    private static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }


//    public static int firstMissingPositive(int[] nums) {
//        int len = nums.length;
//
//        for (int i = 0; i < len; i++) {
//            while (nums[i] > 0 && nums[i] <= len && nums[nums[i] - 1] != nums[i]) {
//                // 满足在指定范围内、并且没有放在正确的位置上，才交换
//                // 例如：数值 3 应该放在索引 2 的位置上
//                swap(nums, nums[i] - 1, i);
//            }
//        }
//
//        // [1, -1, 3, 4]
//        for (int i = 0; i < len; i++) {
//            if (nums[i] != i + 1) {
//                return i + 1;
//            }
//        }
//        // 都正确则返回数组长度 + 1
//        return len + 1;
//    }
//
//    private static void swap(int[] nums, int index1, int index2) {
//        int temp = nums[index1];
//        nums[index1] = nums[index2];
//        nums[index2] = temp;
//    }



}
