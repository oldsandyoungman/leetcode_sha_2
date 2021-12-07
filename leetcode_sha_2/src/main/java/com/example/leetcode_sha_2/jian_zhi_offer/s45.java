package com.example.leetcode_sha_2.jian_zhi_offer;

import java.util.Arrays;

public class s45 {

    public static void main(String[] args) {

    }

//    输入一个非负整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。

    public static String minNumber(int[] nums) {
        int n = nums.length;
        String[] strs = new String[n];

        for(int i=0; i<n; i++){
            strs[i] = String.valueOf(nums[i]);
        }

        Arrays.sort(strs, (x, y) -> {
            return (x+y).compareTo(y+x);
        });

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<n; i++){
            sb.append(strs[i]);
        }

        return sb.toString();

    }

}
