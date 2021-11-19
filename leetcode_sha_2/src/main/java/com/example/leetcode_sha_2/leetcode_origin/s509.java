package com.example.leetcode_sha_2.leetcode_origin;

public class s509 {

    public static void main(String[] args) {
        System.out.println(fib(0));
        System.out.println(fib(1));
        System.out.println(fib(2));
        System.out.println(fib(3));
        System.out.println(fib(4));
        System.out.println(fib(5));
        System.out.println(fib2(5));
    }



//    斐波那契数，通常用 F(n) 表示，形成的序列称为 斐波那契数列 。该数列由 0 和 1 开始，后面的每一项数字都是前面两项数字的和。也就是：


//    备忘录方法

    public static int[] memo;
    public static int fib(int n) {
        memo = new int[n+1];
        traverse(n);
        return memo[n];
    }
    public static int traverse(int n){

        if (n==0){
            return 0;
        } else if (n==1) {
            memo[1] = 1;
            return 1;
        }else {
            if (memo[n]>0) {
                return memo[n];
            }
            int res = traverse(n-1) + traverse(n-2);
            memo[n] = res;
            return res;
        }
    }


//    dp table方法
    public static int fib2(int n) {
        if (n==0){
            return 0;
        }
        if (n==1){
            return 1;
        }
        int[] dp = new int[n+1];
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }

}
