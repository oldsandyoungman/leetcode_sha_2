package com.example.leetcode_sha_2.jian_zhi_offer;

public class s39 {

    public static void main(String[] args) {
        int[] nums = {1,2,2,2,3,3};
    }

//    数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
//
//
//
//    你可以假设数组是非空的，并且给定的数组总是存在多数元素。

    public static int majorityElement(int[] nums) {
        int x = 0;
        int votes = 0;

        for(int num : nums){
            if(votes==0){
                x = num;
            }
            if(num==x){
                votes++;
            }else{
                votes--;
            }
        }

        return x;
    }

}
