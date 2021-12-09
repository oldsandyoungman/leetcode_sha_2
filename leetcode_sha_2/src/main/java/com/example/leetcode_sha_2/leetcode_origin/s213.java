package com.example.leetcode_sha_2.leetcode_origin;

public class s213 {

    public static void main(String[] args) {

    }

//    你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。这个地方所有的房屋都 围成一圈 ，这意味着第一个房屋和最后一个房屋是紧挨着的。同时，相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警 。
//
//    给定一个代表每个房屋存放金额的非负整数数组，计算你 在不触动警报装置的情况下 ，今晚能够偷窃到的最高金额。
//
//    来源：力扣（LeetCode）
//    链接：https://leetcode-cn.com/problems/house-robber-ii
//    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。


    public int rob(int[] nums) {
        int n = nums.length;
        if(n==1){
            return nums[0];
        }

        //第一家不抢
        int[] dp1 = new int[n+2];
        for(int i=n-1; i>=1; i--){
            dp1[i] = Math.max(dp1[i+1], dp1[i+2]+nums[i]);
        }
        // return dp1[1];

        //最后一家不抢
        int[] dp2 = new int[n+2];
        for(int i=n-2; i>=0; i--){
            dp2[i] = Math.max(dp2[i+1], dp2[i+2]+nums[i]);
        }
        // return dp2[0];
        return Math.max(dp1[1], dp2[0]);
    }

}
