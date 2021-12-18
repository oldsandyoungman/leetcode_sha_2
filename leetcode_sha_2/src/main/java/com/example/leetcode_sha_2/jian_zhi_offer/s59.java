package com.example.leetcode_sha_2.jian_zhi_offer;

import java.util.ArrayDeque;
import java.util.Arrays;

public class s59 {

    public static void main(String[] args) {
//        int[] nums = {1,3,-1,-3,5,3,6,7};
//        int k = 3;
        int[] nums = {1,3,1,2,0,5};
        int k = 3;
        System.out.println(Arrays.toString(maxSlidingWindow(nums, k)));
    }

//    给定一个数组 nums 和滑动窗口的大小 k，请找出所有滑动窗口里的最大值。


    public static int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        if(n==0){
            return new int[0];
        }
        ArrayDeque<Integer> q = new ArrayDeque<>();
        int[] res = new int[n-k+1];

        for(int i=0; i<k; i++){
            while(!q.isEmpty() && q.getLast()<nums[i]){
                q.removeLast();
            }
            q.addLast(nums[i]);
        }

        res[0] = q.getFirst();

        for(int i=k; i<n; i++){
            if(nums[i-k]==q.getFirst()){
                q.removeFirst();
            }

            while(!q.isEmpty() && q.getLast()<nums[i]){
                q.removeLast();
            }
            q.addLast(nums[i]);

            res[i-k+1] = q.getFirst();

        }

        return res;
    }

}
