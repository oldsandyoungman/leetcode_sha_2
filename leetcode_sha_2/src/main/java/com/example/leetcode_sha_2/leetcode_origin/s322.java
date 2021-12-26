package com.example.leetcode_sha_2.leetcode_origin;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class s322 {

    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
//        int[] coins = {2};
        int amount = 11;
//        int amount = 3;

//        System.out.println(coinChange(coins, amount));
        System.out.println(coinChange3(coins, amount));


//        List<String> panel = new LinkedList<>();
//        String a = "111";
//        panel.add(a);
//        String z = panel.get(0);
//        z.charAt()

    }

//    给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。
//
//    计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回 -1 。
//
//    你可以认为每种硬币的数量是无限的。
//
//    来源：力扣（LeetCode）
//    链接：https://leetcode-cn.com/problems/coin-change
//    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。




    public static int coinChange3(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        Arrays.fill(dp, amount+1);
        dp[0] = 0;
        for(int i=1; i<=amount; i++){
            int res = amount+1;
            for(int coin : coins){
                if(coin<=i){
                    res = Math.min(res, dp[i-coin]+1);
                }
            }
            dp[i] = res;
        }
        return dp[amount]==(amount+1)?-1:dp[amount];
    }


//    dp table 方法
    public static int coinChange2(int[] coins, int amount) {
        int[] dp = new int[amount+1];

        for (int i = 1; i <= amount; i++) {
            int min_temp = 10001;
            for (int coin : coins) {
                if (i>=coin){
                    min_temp = Math.min(min_temp, dp[i-coin] + 1);
                }
            }
            dp[i] = min_temp;
        }
        if (dp[amount]!=10001){
            return dp[amount];
        }
        return -1;
    }

//    memo 方法
    public static int[] memo;
    public static int coinChange(int[] coins, int amount) {
        memo = new int[amount+1];
        traverse(coins, amount);
        return memo[amount];

    }
    public static int traverse(int[] coins, int amount){
        if (amount==0){
            return 0;
        }
        if (memo[amount]!=0){
            return memo[amount];
        }
        int res = 10001;
        for (int coin : coins) {
            if (amount>=coin){
                int temp = traverse(coins, amount-coin);
                if (temp>=0){
                    res = Math.min(res, 1+temp);
                }
            }

        }
        res = res==10001?-1:res;
        memo[amount] = res;
        return res;

    }

}
