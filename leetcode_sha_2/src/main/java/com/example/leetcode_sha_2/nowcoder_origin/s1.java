package com.example.leetcode_sha_2.nowcoder_origin;

import java.util.Arrays;

public class s1 {

    public static void main(String[] args) {

    }

//    https://labuladong.gitee.io/algo/4/32/133/

    // 输入为三种葡萄的颗数，可能非常大，所以用 long 型
    // 返回吃的最多的人最少要吃多少颗葡萄
    public static long solution(long a, long b, long c){
        long[] nums = {a, b, c};
        Arrays.sort(nums);

        if(nums[0]+nums[1]>nums[2]){
            return (nums[0]+nums[1]+nums[2]+2)/3;
        }

        if(2*(nums[0]+nums[1])<nums[2]){
            return (nums[2]+1)/2;
        }

        return (nums[0]+nums[1]+nums[2]+2)/3;

    }

}
