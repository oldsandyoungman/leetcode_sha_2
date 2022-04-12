package com.example.leetcode_sha_2.leetcode_origin;

public class s41 {

    public static void main(String[] args) {
//        int[] nums = {1,2,0};
        int[] nums = {1,1};
        System.out.println(firstMissingPositive(nums));
    }

    public static int firstMissingPositive(int[] nums) {
        int n = nums.length;

        for(int i=0; i<n; i++){
            if(nums[i]<=0 || nums[i]>n || nums[i]==i+1){
                continue;
            }
            int index = nums[i]-1;
            swap(nums, index, i);
            i--;
        }

        for(int i=0; i<n; i++){
            if(nums[i]!=i+1){
                return i+1;
            }
        }

        return n+1;

    }

    public static void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

}
