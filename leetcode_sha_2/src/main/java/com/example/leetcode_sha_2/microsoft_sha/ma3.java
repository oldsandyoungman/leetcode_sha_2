package com.example.leetcode_sha_2.microsoft_sha;

import java.util.LinkedList;

public class ma3 {

    public int cal(int[] nums, int m){
        int n = nums.length;
        int[] res = new int[m];
        for(int num : nums){
            int cur = Math.floorMod(num, m);
            res[cur]++;
        }
        int max = 0;
        for(int i=0; i<n; i++){
            max = Math.max(max, res[i]);
        }
        return max;
    }

}
