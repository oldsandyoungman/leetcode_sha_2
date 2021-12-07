package com.example.leetcode_sha_2.jian_zhi_offer;

import java.util.Arrays;
import java.util.HashSet;

public class s61 {

    public static void main(String[] args) {

    }

//    从若干副扑克牌中随机抽 5 张牌，判断是不是一个顺子，即这5张牌是不是连续的。2～10为数字本身，A为1，J为11，Q为12，K为13，而大、小王为 0 ，可以看成任意数字。A 不能视为 14。
//
//    来源：力扣（LeetCode）
//    链接：https://leetcode-cn.com/problems/bu-ke-pai-zhong-de-shun-zi-lcof
//    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

    public boolean isStraight(int[] nums) {
        HashSet<Integer> s = new HashSet<>();
        int max = 0;
        int min = 14;
        for(int cur : nums){
            if(cur!=0){
                max = Math.max(max, cur);
                min = Math.min(min, cur);
                if(s.contains(cur)){
                    return false;
                }
                s.add(cur);
            }
        }
        return max-min<5;

    }

    public boolean isStraight2(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int jokers = 0;
        for(int i=0; i<n-1; i++){
            if(nums[i]==0){
                jokers++;
            }else{
                if(nums[i]==nums[i+1]){
                    return false;
                }
            }
        }
        return nums[n-1]-nums[jokers]<5;

    }


}
