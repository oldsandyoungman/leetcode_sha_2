package com.example.leetcode_sha_2.microsoft_sha;

public class ma1 {

    public int[] cal(String s, int[] nums){
        int n = nums.length;
        char[] ss = s.toCharArray();
        int curA = 0;
        int curB = 0;
        int minA = 0;
        int minB = 0;
        for(int i=0; i<n; i++){
            if(ss[i]=='A'){
                curA += nums[i];
                curB -= nums[i];
            }else{
                curB += nums[i];
                curA -= nums[i];
            }
            minA = Math.min(minA, curA);
            minB = Math.min(minB, curB);
        }
        minA = -minA;
        minB = -minB;
        return new int[]{minA, minB};
    }

}
