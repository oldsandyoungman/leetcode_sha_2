package com.example.leetcode_sha_2.pinduoduo_sha;

import java.util.Scanner;

public class mi1 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        System.out.println(encode(s));
    }

    public static String encode(String s){
        int n = s.length();
        char[] ss = s.toCharArray();

        int left = 0;
        int right = 0;
        char cur = ss[0];
        StringBuilder sb = new StringBuilder();
        while(right<n){
            char tmp = ss[right];
            if(tmp==cur){
                right++;
            }else{
                int num = right-left;
                sb.append(num).append(cur);
                cur = tmp;
                left = right;
            }
        }

        int num = right-left;
        sb.append(num).append(cur);

        return sb.toString();


    }



}
