package com.example.leetcode_sha_2.leetcode_origin;

import java.util.ArrayList;

public class s215 {

    public static void main(String[] args) {
        int[] nums = {3,2,1,5,6,4};
        int k = 2;

        ArrayList<int[]> ll = new ArrayList<>();
        ll.toArray();

    }

    // 快速选择

//    给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。
//
//    请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。

    public static int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        k = n - k + 1;
        int left = 0;
        int right = n-1;
        while(left<=right){
            int mid = partition(nums, left, right);
            if(mid<k){
                left = mid + 1;
            }else if(mid>k){
                right = mid - 1;
            }else{
                return nums[k];
            }
        }
        return -1;
    }


    public static int partition(int[] nums, int lo, int hi){
        if(lo>=hi){
            return lo;
        }
        int pivot = nums[lo];
        int i = lo;
        int j = hi+1;
        while(true){
            while(nums[++i]<pivot){
                if(i>=hi){
                    break;
                }
            }
            while(nums[--j]>pivot){
                if(j<=lo){
                    break;
                }
            }
            if(i>=j){
                break;
            }
            swap(nums, i, j);
        }
        swap(nums, lo, j);
        return j;

    }

    public static void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

}
