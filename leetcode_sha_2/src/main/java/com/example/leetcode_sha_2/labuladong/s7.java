package com.example.leetcode_sha_2.labuladong;

import java.util.Arrays;

public class s7 {

    public static void main(String[] args) {
        int[] nums = {3,2,4,6,5,1};
        mergeSort(nums, 0, nums.length-1);
        System.out.println(Arrays.toString(nums));
    }

    // 归并排序

    public static void mergeSort(int[] nums, int l, int r){
        if(l>=r){
            return;
        }

        int mid = l + (r-l)/2;

        mergeSort(nums, l, mid);
        mergeSort(nums, mid+1, r);

        int[] tmp = new int[r-l+1];
        int i = l;
        int j = mid + 1;
        int index = 0;
        while(i<=mid && j<=r){
            if(nums[i]<nums[j]){
                tmp[index++] = nums[i++];
            }else{
                tmp[index++] = nums[j++];
            }
        }
        while(i<=mid){
            tmp[index++] = nums[i++];
        }
        while(j<=r){
            tmp[index++] = nums[j++];
        }

        for(i=l, j=0; i<=r; i++, j++){
            nums[i] = tmp[j];
        }

    }

}
