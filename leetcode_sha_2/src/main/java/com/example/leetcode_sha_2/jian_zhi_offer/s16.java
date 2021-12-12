package com.example.leetcode_sha_2.jian_zhi_offer;

public class s16 {

    public static void main(String[] args) {

//        double x = 2;
//        int n = 10;
        double x = 2.00000;
        int n = -2147483648;

        System.out.println(myPow(x, n));
    }


//    实现 pow(x, n) ，即计算 x 的 n 次幂函数（即，xn）。不得使用库函数，同时不需要考虑大数问题。
    public static double myPow(double x, int n) {
        if(x == 0) return 0;
        long b = n;
        double res = 1.0;
        if(b < 0) {
            x = 1 / x;
            b = -b;
        }
        while(b > 0) {
            if((b & 1) == 1) res *= x;
            x *= x;
            b >>= 1;
        }
        return res;
    }
}
