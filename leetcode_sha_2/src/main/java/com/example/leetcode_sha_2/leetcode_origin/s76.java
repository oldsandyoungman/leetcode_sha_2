package com.example.leetcode_sha_2.leetcode_origin;

import java.util.HashMap;

public class s76 {

    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
//        String s = "a";
        String t = "ABC";
//        String t = "a";
//        String t = "aa";
        System.out.println(minWindow(s, t));
    }

//    给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 ""

    public static String minWindow(String s, String t) {
        // int n = t.length();
        char[] char_t = t.toCharArray();
        HashMap<Character, Integer> need = new HashMap<>();
        HashMap<Character, Integer> window = new HashMap<>();
        for(char cc: char_t){
            need.put(cc, need.getOrDefault(cc, 0)+1);
        }

        int n = s.length();
        int left = 0;
        int right = 0;

        int value = 0;

        int res_l = 0;
        int res_r = n+1;
        int min_length_1 = res_r-res_l;


        while(right<n){

            char cur = s.charAt(right);

            if(need.containsKey(cur)){
                window.put(cur, window.getOrDefault(cur, 0)+1);
                if(need.get(cur).equals(window.get(cur))){
                    value++;
                }
            }

            right++;

            while(value==need.size()){
                if(right-left<min_length_1){
                    res_l = left;
                    res_r = right;
                    min_length_1 = right - left;
                }

                cur = s.charAt(left);

                if(need.containsKey(cur)){
                    if(need.get(cur).equals(window.get(cur))){
                        value--;
                    }
                    window.put(cur, window.get(cur)-1);
                }

                left++;

            }

        }

        return res_r==n+1?"":s.substring(res_l, res_r);

    }
}
