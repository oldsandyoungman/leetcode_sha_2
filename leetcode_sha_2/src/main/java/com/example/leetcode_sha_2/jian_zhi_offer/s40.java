package com.example.leetcode_sha_2.jian_zhi_offer;

import java.util.Arrays;
import java.util.PriorityQueue;

public class s40 {

    public static void main(String[] args) {

    }

//    输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。

    public int[] getLeastNumbers(int[] arr, int k) {
        if (k == 0 || arr.length == 0) {
            return new int[0];
        }
        // 最后一个参数表示我们要找的是下标为k-1的数
        return quickSearch(arr, 0, arr.length - 1, k - 1);
    }

    private int[] quickSearch(int[] nums, int lo, int hi, int k) {
        // 每快排切分1次，找到排序后下标为j的元素，如果j恰好等于k就返回j以及j左边所有的数；
        int j = partition(nums, lo, hi);
        if (j == k) {
            return Arrays.copyOf(nums, j + 1);
        }
        // 否则根据下标j与k的大小关系来决定继续切分左段还是右段。
        return j > k? quickSearch(nums, lo, j - 1, k): quickSearch(nums, j + 1, hi, k);
    }

    // 快排切分，返回下标j，使得比nums[j]小的数都在j的左边，比nums[j]大的数都在j的右边。
    private int partition(int[] nums, int lo, int hi) {
        int v = nums[lo];
        int i = lo, j = hi + 1;
        while (true) {
            while (++i <= hi && nums[i] < v);
            while (--j >= lo && nums[j] > v);
            if (i >= j) {
                break;
            }
            int t = nums[j];
            nums[j] = nums[i];
            nums[i] = t;
        }
        nums[lo] = nums[j];
        nums[j] = v;
        return j;
    }



    public int[] getLeastNumbers2(int[] arr, int k) {
        if(k==0 || arr.length==0){
            return new int[]{};
        }

        PriorityQueue<Integer> q = new PriorityQueue<>((o1, o2) ->{
            return Integer.compare(o2, o1);
        });

        for(int num : arr){
            if(q.size()<k){
                q.offer(num);
            }else if(q.peek()>num){
                q.poll();
                q.offer(num);
            }
        }

        // 返回堆中的元素
        int[] res = new int[q.size()];
        int idx = 0;
        for(int num: q) {
            res[idx++] = num;
        }
        return res;

    }

}
