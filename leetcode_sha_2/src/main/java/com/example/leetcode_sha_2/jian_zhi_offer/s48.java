package com.example.leetcode_sha_2.jian_zhi_offer;

import java.util.HashMap;

public class s48 {

    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(s));
    }

//    请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。

    public static int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> m = new HashMap<>();
        char[] ss = s.toCharArray();

        int n = s.length();
        int left = 0;
        int right = 0;
        int max_len = 0;
        int error_num = 0;

        while(right<n){

            char cur = ss[right];
            int tmp = m.getOrDefault(cur, 0);
            if(tmp>0){
                error_num++;
            }
            m.put(cur, tmp+1);

            right++;


            while(error_num>0){
                cur = ss[left];
                tmp = m.get(cur);
                if(tmp==2){
                    error_num--;
                }
                m.put(cur, tmp-1);

                left++;
            }

            max_len = Math.max(max_len, right-left);

        }

        return max_len;



    }

}
