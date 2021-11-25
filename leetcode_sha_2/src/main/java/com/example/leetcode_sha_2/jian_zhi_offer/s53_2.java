package com.example.leetcode_sha_2.jian_zhi_offer;

public class s53_2 {

    public static void main(String[] args) {

    }

//    一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围0～n-1之内。在范围0～n-1内的n个数字中有且只有一个数字不在该数组中，请找出这个数字。
//
//    来源：力扣（LeetCode）
//    链接：https://leetcode-cn.com/problems/que-shi-de-shu-zi-lcof
//    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

    public static int missingNumber(int[] nums) {
        int n = nums.length;
        int sum = 0;
        int sum_target = 0;
        for(int i = 0; i < n; i++){
            sum += nums[i];
            sum_target += i;
        }

        return sum_target + n - sum;

    }

}
