package com.example.leetcode_sha_2.jian_zhi_offer;

import java.util.Arrays;

public class s56_no {

    public static void main(String[] args) {
//        int[] nums = {4,1,4,6};
        int[] nums = {1,2,10,4,1,4,3,3};
        System.out.println(Arrays.toString(singleNumbers(nums)));
    }

//    一个整型数组 nums 里除两个数字之外，其他数字都出现了两次。请写程序找出这两个只出现一次的数字。要求时间复杂度是O(n)，空间复杂度是O(1)。

    public static int[] singleNumbers(int[] nums) {

        int sum = 0;

        for(int num : nums){
            sum ^= num;
        }

        int m = 1;
        while((sum&m)==0){
            m <<= 1;
        }

        int x = 0;
        int y = 0;

        for(int num : nums){
            if((num&m)==0){
                x ^= num;
            }else{
                y ^= num;
            }
        }

        return new int[]{x, y};

    }

}
