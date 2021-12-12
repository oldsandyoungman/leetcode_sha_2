package com.example.leetcode_sha_2.jian_zhi_offer;

public class s65 {

    public static void main(String[] args) {

    }

//    写一个函数，求两个整数之和，要求在函数体内不得使用 “+”、“-”、“*”、“/” 四则运算符号。

    public int add(int a, int b) {
        while(b!=0){
            int c = (a&b)<<1;
            a = a^b;
            b = c;
        }
        return a;
    }


}
