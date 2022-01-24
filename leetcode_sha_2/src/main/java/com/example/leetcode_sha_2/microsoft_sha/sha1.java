package com.example.leetcode_sha_2.microsoft_sha;

import java.util.LinkedList;

public class sha1 {

    public static void main(String[] args) {
//        String s = "aaabba";
        String s = "a";

        System.out.println(minNum(s));
    }

    public static int minNum(String src){
        char[] ss = src.toCharArray();
        int n = ss.length;
        LinkedList<Integer> memo = new LinkedList<>();

        int right = 0;
        int left = 0;
        char tar = ss[0];
        int max = 0;
        while(right<n){
            if(ss[right]==tar){
                right++;
            }else{
                max = Math.max(max, right-left);
                memo.addLast(right-left);
                left = right;
                tar = ss[left];
                right++;
            }
        }
        max = Math.max(max, right-left);
        memo.addLast(right-left);

        int res = 0;
        while(!memo.isEmpty()){
            res += max-memo.removeFirst();
        }

        return  res;

    }


}
