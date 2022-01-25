package com.example.leetcode_sha_2.leetcode_origin;

public class s698 {

    public static void main(String[] args) {
//        int[] nums = {1,1,1,1,2,2,2,2};
//        int[] nums = {4, 3, 2, 3, 5, 2, 1};
//        int k = 4;

        int[] nums = {10,1,10,9,6,1,9,5,9,10,7,8,5,2,10,8};
        int k = 11;



        System.out.println(canPartitionKSubsets(nums, k));
    }

//    给定一个整数数组  nums 和一个正整数 k，找出是否有可能把这个数组分成 k 个非空子集，其总和都相等。


    public static boolean canPartitionKSubsets(int[] nums, int k) {
        int n = nums.length;
        selected = new boolean[n];
        buckets = new int[k];
        ok = new boolean[k];

        int sum = 0;
        for(int num : nums){
            sum += num;
        }

        if(sum%k!=0){
            return false;
        }
        int target = sum/k;

        for(int i=0; i<k; i++){
            backtrack(nums, i, 0, target);
            if(!ok[i]){
                return false;
            }
        }

        return true;

    }
    public static boolean[] selected;
    public static int[] buckets;
    public static boolean[] ok;

    public static void backtrack(int[] nums, int index_bucket, int index_num, int target){
        int n = nums.length;
        if(index_num>=n){
            if(buckets[index_bucket]==target){
                ok[index_bucket] = true;
            }
            return;
        }

        if(selected[index_num]){
            backtrack(nums, index_bucket, index_num+1, target);
        }else{
            if(buckets[index_bucket]+nums[index_num]<=target){
                // 选
                selected[index_num] = true;
                buckets[index_bucket] += nums[index_num];

                backtrack(nums, index_bucket, index_num+1, target);

                selected[index_num] = false;
                buckets[index_bucket] -= nums[index_num];
            }

            //不选
            backtrack(nums, index_bucket, index_num+1, target);

        }

    }

}
