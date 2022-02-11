package com.example.leetcode_sha_2.leetcode_origin;

import java.util.Arrays;
import java.util.HashMap;

public class s698 {

    public static void main(String[] args) {
//        int[] nums = {1,1,1,1,2,2,2,2};
//        int[] nums = {4, 3, 2, 3, 5, 2, 1};
//        int k = 4;

//        int[] nums = {10,1,10,9,6,1,9,5,9,10,7,8,5,2,10,8};
//        int k = 11;

//        int[] nums = {2,2,2,2,3,4,5};
//        int k = 4;


        int[] nums = {4,3,2,3,5,2,1};
        int k = 4;



        System.out.println(canPartitionKSubsets(nums, k));
    }

//    给定一个整数数组  nums 和一个正整数 k，找出是否有可能把这个数组分成 k 个非空子集，其总和都相等。


//    public static boolean canPartitionKSubsets(int[] nums, int k) {
//        int n = nums.length;
//        selected = new boolean[n];
//        buckets = new int[k];
//        ok = new boolean[k];
//
//        int sum = 0;
//        for(int num : nums){
//            sum += num;
//        }
//
//        if(sum%k!=0){
//            return false;
//        }
//        int target = sum/k;
//
//        for(int i=0; i<k; i++){
//            backtrack(nums, i, 0, target);
//            if(!ok[i]){
//                return false;
//            }
//        }
//
//        return true;
//
//    }
//    public static boolean[] selected;
//    public static int[] buckets;
//    public static boolean[] ok;
//
//    public static void backtrack(int[] nums, int index_bucket, int index_num, int target){
//        int n = nums.length;
//        if(index_num>=n){
//            if(buckets[index_bucket]==target){
//                ok[index_bucket] = true;
//            }
//            return;
//        }
//
//        if(selected[index_num]){
//            backtrack(nums, index_bucket, index_num+1, target);
//        }else{
//            if(buckets[index_bucket]+nums[index_num]<=target){
//                // 选
//                selected[index_num] = true;
//                buckets[index_bucket] += nums[index_num];
//
//                backtrack(nums, index_bucket, index_num+1, target);
//
//                selected[index_num] = false;
//                buckets[index_bucket] -= nums[index_num];
//            }
//
//            //不选
//            backtrack(nums, index_bucket, index_num+1, target);
//
//        }
//
//    }


//    public static boolean canPartitionKSubsets(int[] nums, int k) {
//        int[] buckets = new int[k];
//        boolean[] used = new boolean[nums.length];
//
//        int sum = 0;
//        for(int num : nums){
//            sum += num;
//        }
//        if(sum%k!=0){
//            return false;
//        }
//        int target = sum/k;
//
//        Arrays.sort(nums);
//        int left = 0;
//        int right = nums.length-1;
//        while(left<right){
//            int tmp = nums[left];
//            nums[left] = nums[right];
//            nums[right] = tmp;
//            left++;
//            right--;
//        }
//
//        return dfs(nums, 0, 0, 0, target, k, used);
//
//    }
//
//
//    public static boolean dfs(int[] nums, int start_num, int sum, int start_bucket, int target, int k, boolean[] used){
//        if(start_bucket==k){
//            return true;
//        }
//        if(start_num==nums.length){
//            if(sum==target){
//                return dfs(nums, 0, 0, start_bucket+1, target, k, used);
//            }
//            return false;
//        }
//
//        // 选
//        if(!used[start_num]){
//            if(sum+nums[start_num]<=target){
//                sum += nums[start_num];
//                used[start_num] = true;
//                if(dfs(nums, start_num+1, sum, start_bucket, target, k, used)){
//                    return true;
//                }
//                sum -= nums[start_num];
//                used[start_num] = false;
//            }
//        }
//
//        // 不选
//        if(dfs(nums, start_num+1, sum, start_bucket, target, k, used)){
//            return true;
//        }
//
//        return false;
//
//
//    }



// 加位图的备忘录
    public static boolean canPartitionKSubsets(int[] nums, int k) {
        m = new HashMap<>();
        // boolean[] used = new boolean[nums.length];

        int sum = 0;
        int max = 0;
        for(int num : nums){
            sum += num;
            max = Math.max(max, num);
        }
        if(sum%k!=0){
            return false;
        }
        int target = sum/k;
        if(max>target){
            return false;
        }

        Arrays.sort(nums);
        int left = 0;
        int right = nums.length-1;
        while(left<right){
            int tmp = nums[left];
            nums[left] = nums[right];
            nums[right] = tmp;
            left++;
            right--;
        }

        return dfs(nums, 0, 0, 0, target, k, 0);

    }

    public static HashMap<Integer, Boolean> m;


    public static boolean dfs(int[] nums, int start_num, int sum, int start_bucket, int target, int k, int used){
        if(start_bucket==k){
            return true;
        }
        if(start_num==nums.length){
            if(sum==target){
                return dfs(nums, 0, 0, start_bucket+1, target, k, used);
            }
            return false;
        }

        if(m.containsKey(used)){
            return m.get(used);
        }

        // 选
        if((used>>start_num&1) == 0){
            if(sum+nums[start_num]<=target){
                sum += nums[start_num];
                used |= 1<<start_num;
                if(dfs(nums, start_num+1, sum, start_bucket, target, k, used)){
                    m.put(used, true);
                    return true;
                }
                sum -= nums[start_num];
                used ^= 1<<start_num;
            }
        }

        // 不选
        if(dfs(nums, start_num+1, sum, start_bucket, target, k, used)){
            m.put(used, true);
            return true;
        }

        m.put(used, false);
        return false;

    }

}
