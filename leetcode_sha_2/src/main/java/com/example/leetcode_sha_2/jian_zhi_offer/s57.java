package com.example.leetcode_sha_2.jian_zhi_offer;

public class s57 {

    public static void main(String[] args) {

    }

//    输入一个递增排序的数组和一个数字s，在数组中查找两个数，使得它们的和正好是s。如果有多对数字的和等于s，则输出任意一对即可。
    public static int[] twoSum(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;

        while(left<right){
            int sum = nums[left] + nums[right];
            if(sum<target){
                left++;
            }else if(sum>target){
                right--;
            }else{
                return new int[]{nums[left], nums[right]};
            }
        }

        return new int[0];

    }

}
