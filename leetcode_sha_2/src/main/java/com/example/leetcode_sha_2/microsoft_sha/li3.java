package com.example.leetcode_sha_2.microsoft_sha;

import java.util.Arrays;

public class li3 {

    public static void main(String[] args) {
        int[] nums = {5,2,4,6,3,7};
        System.out.println(cal(nums));
    }

    public static int cal(int[] nums){

        int n = nums.length;
        int[] leftmin = new int[n];
        int[] rightmin = new int[n];

        Arrays.fill(leftmin, Integer.MAX_VALUE);
        Arrays.fill(rightmin, Integer.MAX_VALUE);

        int ll = leftmin[0];
        for(int i=1; i<n-1; i++){
            ll = Math.min(nums[i], ll);
            leftmin[i] = ll;
        }

        int rr = rightmin[n-1];
        for(int i=n-1; i>=1; i--){
            rr = Math.min(nums[i], rr);
            rightmin[i] = rr;
        }
        int res = Integer.MAX_VALUE;
        for(int i=2; i<n-2; i++){
            int cur = leftmin[i]*rightmin[i];
            res = Math.min(res, cur);
        }

        return res;

    }

}
