package com.example.leetcode_sha_2.leetcode_origin;

public class s42 {

    public static void main(String[] args) {
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trap(height));
    }

//    给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。

    public static int trap(int[] height) {
        int n = height.length;

        int l_max = height[0];
        int r_max = height[n-1];
        int l = 0;
        int r = n-1;
        int res = 0;
        while(l<=r){
            l_max = Math.max(l_max, height[l]);
            r_max = Math.max(r_max, height[r]);

            if(l_max>=r_max){
                res += r_max - height[r];
                r--;


            }else{
                res += l_max - height[l];
                l++;

            }

        }

        return res;

    }

}
