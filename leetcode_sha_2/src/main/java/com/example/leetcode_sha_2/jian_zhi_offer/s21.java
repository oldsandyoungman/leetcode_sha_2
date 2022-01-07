package com.example.leetcode_sha_2.jian_zhi_offer;

import java.util.ArrayList;
import java.util.Arrays;

public class s21 {

    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
//        int[] nums = {1,2,3,4,5,6};
        System.out.println(Arrays.toString(exchange(nums)));

    }

//    输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数在数组的前半部分，所有偶数在数组的后半部分。

    public static int[] exchange(int[] nums) {
//        int i = 0, j = nums.length - 1, tmp;
//        while(i < j) {
//            while(i < j && (nums[i] & 1) == 1) i++;
//            while(i < j && (nums[j] & 1) == 0) j--;
//            tmp = nums[i];
//            nums[i] = nums[j];
//            nums[j] = tmp;
//        }
//        return nums;
        int n = nums.length;
        int left = 0;
        int right = n-1;
        while(left<right){
            while(left<right && (nums[left]&1)==1){
                left++;
            }
            while(left<right && (nums[right]&1)==0){
                right--;
            }
            int tmp = nums[right];
            nums[right] = nums[left];
            nums[left] = tmp;
            left++;
            right--;
        }
        return nums;
    }
}
