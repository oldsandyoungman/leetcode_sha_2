package com.example.leetcode_sha_2.leetcode_origin;

public class s14 {

    public static void main(String[] args) {
        String[] strs = {"flower","flow","flight"};
        System.out.println(longestCommonPrefix(strs));
    }

//    编写一个函数来查找字符串数组中的最长公共前缀。
//
//    如果不存在公共前缀，返回空字符串 ""。

    public static String longestCommonPrefix(String[] strs) {
        int n = strs.length;

        if(n==0){
            return "";
        }

        int minsize = Integer.MAX_VALUE;
        for(int i=0; i<n; i++){
            minsize = Math.min(minsize, strs[i].length());
        }

        int index = 0;

        while(index<minsize){
            boolean flag = true;
            char cur = strs[0].charAt(index);
            for(int i=1; i<n; i++){
                if(strs[i].charAt(index)==cur){
                    flag = false;
                    break;
                }
            }
            if(!flag){
                break;
            }
            index++;
        }

        return strs[0].substring(0, index);

    }

}
