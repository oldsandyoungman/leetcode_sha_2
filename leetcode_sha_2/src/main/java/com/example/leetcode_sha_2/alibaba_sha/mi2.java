package com.example.leetcode_sha_2.alibaba_sha;

import java.util.Arrays;

public class mi2 {

    public static void main(String[] args) {
        int[] nums1 = {1,2,3,0,0,0};
        int[] nums2 = {2,5,6};
        merge(nums1, nums2);
        System.out.println(Arrays.toString(nums1));
    }

    public static void merge(int[] nums1, int[] nums2) {
        int m_n = nums1.length;
        int n = nums2.length;
        int m =  m_n - n;

        int i = m-1;
        int j = n-1;
        int k = m+n-1;
        while(i>=0 && j>=0){
            if(nums1[i]<nums2[j]){
                nums1[k] = nums2[j];
                k--;
                j--;
            }else{
                nums1[k] = nums1[i];
                k--;
                i--;
            }
        }

        if (i==-1) {
            while(j>=0){
                nums1[k] = nums2[j];
                j--;
                k--;
            }
        }

    }

}
