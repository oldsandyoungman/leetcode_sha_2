package com.example.leetcode_sha_2.jian_zhi_offer;

public class s53 {

    public static void main(String[] args) {
        int[] nums = {5,7,7,8,8,10};
//        int target = 8;
        int target = 6;

        System.out.println(search(nums, target));
    }

//    统计一个数字在排序数组中出现的次数

    public static int search(int[] nums, int target) {
        int n = nums.length;
        if (n==0){
            return 0;
        }
        int left = 0;
        int right = n - 1;
        int mid = 0;

        while (left <= right) {
            mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                break;
            }
        }

        int left1 = 0;
        int right1 = mid;
        int mid1;

        while (left1 <= right1) {
            mid1 = left1 + (right1 - left1) / 2;
            if (nums[mid1] < target) {
                left1 = mid1 + 1;
            } else
                right1 = mid1 - 1;
        }

        // if(left1==0 || nums[left1]!=target){

        // }

        int left2 = mid;
        int right2 = n - 1;
        int mid2;

        while (left2 <= right2) {
            mid2 = left2 + (right2 - left2) / 2;
            if (nums[mid2] > target) {
                right2 = mid2 - 1;
            } else
                left2 = mid2 + 1;
        }


        return right2 - left1 + 1;

    }




}
