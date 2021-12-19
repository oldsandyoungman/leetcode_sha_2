package com.example.leetcode_sha_2.jian_zhi_offer;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class s38 {

    public static void main(String[] args) {
        String s = "abc";
        System.out.println(Arrays.toString(permutation(s)));
    }

//    输入一个字符串，打印出该字符串中字符的所有排列。
//    你可以以任意顺序返回这个字符串数组，但里面不能有重复元素

    public static List<String> res = new LinkedList<>();
    public static char[] c;
    public static String[] permutation(String s) {
        c = s.toCharArray();
        dfs(0);
        return res.toArray(new String[0]);
    }
    public static void dfs(int x) {
        if(x == c.length - 1) {
            res.add(String.valueOf(c));      // 添加排列方案
            return;
        }
        HashSet<Character> set = new HashSet<>();
        for(int i = x; i < c.length; i++) {
            if(set.contains(c[i])) continue; // 重复，因此剪枝
            set.add(c[i]);
            swap(i, x);                      // 交换，将 c[i] 固定在第 x 位
            dfs(x + 1);                      // 开启固定第 x + 1 位字符
            swap(i, x);                      // 恢复交换
        }
    }
    public static void swap(int a, int b) {
        char tmp = c[a];
        c[a] = c[b];
        c[b] = tmp;
    }

}
