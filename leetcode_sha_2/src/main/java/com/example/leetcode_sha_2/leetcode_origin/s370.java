package com.example.leetcode_sha_2.leetcode_origin;

import java.util.Arrays;

public class s370 {

    public static void main(String[] args) {
        int n = 5;
        int[] nums = new int[n];

        int[][] updates = {{1,3,2}, {2,4,3}, {0,2,-2}};

        Difference diff = new Difference(nums);
        for(int[] tmp : updates){
            diff.increment(tmp[0], tmp[1], tmp[2]);
        }

        System.out.println(Arrays.toString(diff.result()));

    }

//    假设你有一个长度为n的数组，初始情况下所有的数字均为О，你将会被给出k个更新的操作。其中，每个操作会被表示为一个三元组:[startIndex, endIndex, inc]，你需要将子数
//    组A[startlndex ... endIndex](包括startIndex和endIndex)增加inc。
//    请你返回k次操作后的数组。


}


class Difference{

    int[] dif;

    public Difference(int[] nums){
        int n = nums.length;
        dif = new int[n];
        dif[0] = nums[0];
        for (int i=1; i<n; i++){
            dif[i] = nums[i] - nums[i-1];
        }
    }

    // [left, right]之间增加val
    public void increment(int left, int right, int val){
        dif[left] += val;
        if(right+1<dif.length){
            dif[right+1] -= val;
        }
    }

    public int[] result(){
        int[] res = new int[dif.length];
        res[0] = dif[0];
        for(int i=1; i<dif.length; i++){
            res[i] = res[i-1] + dif[i];
        }
        return res;
    }

}
