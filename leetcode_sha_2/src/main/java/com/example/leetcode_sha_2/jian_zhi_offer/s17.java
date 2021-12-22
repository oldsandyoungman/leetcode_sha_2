package com.example.leetcode_sha_2.jian_zhi_offer;

import java.util.Arrays;

public class s17 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(printNumbers(2)));
    }

//    输入数字 n，按顺序打印出从 1 到最大的 n 位十进制数。比如输入 3，则打印出 1、2、3 一直到最大的 3 位数 999。

    static int[] res;
    static int nine = 0, count = 0, start, n1;
    static char[] num, loop = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
    public static int[] printNumbers(int n) {
        n1 = n;
        res = new int[(int)Math.pow(10, n) - 1];
        num = new char[n];
        start = n - 1;
        dfs(0);
        return res;
    }
    static void dfs(int x) {
        if(x == n1) {
            String s = String.valueOf(num).substring(start);
            if(!s.equals("0")) res[count++] = Integer.parseInt(s);
            if(n1 - start == nine) start--;
            return;
        }
        for(char i : loop) {
            if(i == '9') nine++;
            num[x] = i;
            dfs(x + 1);
        }
        nine--;
    }


}
