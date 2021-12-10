package com.example.leetcode_sha_2.jian_zhi_offer;

public class s64 {

    public static void main(String[] args) {

    }


//    求 1+2+...+n ，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。

    public int res;
    public int sumNums(int n) {
        boolean x = n>0 && sumNums(n-1)>0;
        res += n;
        return res;
    }

}
