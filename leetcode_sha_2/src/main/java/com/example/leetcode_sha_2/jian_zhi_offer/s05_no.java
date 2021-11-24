package com.example.leetcode_sha_2.jian_zhi_offer;

public class s05_no {

    public static void main(String[] args) {
//        String s = "We are happy.";
        String s = "     ";
        System.out.println(replaceSpace(s));
    }

//    请实现一个函数，把字符串 s 中的每个空格替换成"%20"。

    public static String replaceSpace(String s) {

        int n = s.length();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            char cur = s.charAt(i);
            if (cur ==' '){
                sb.append("%20");
            }else {
                sb.append(cur);
            }
        }

        return sb.toString();



//        String[] s1 = s.split(" ");
//        StringBuilder sb = new StringBuilder();
//        int n = s1.length;
//
//        sb.append(s1[0]);
//
//        for (int i = 1; i < n; i++) {
//            sb.append("%20");
//            sb.append(s1[i]);
//
//        }
//
//        return sb.toString();

    }



}
