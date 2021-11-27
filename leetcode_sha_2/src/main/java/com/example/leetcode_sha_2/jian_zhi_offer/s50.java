package com.example.leetcode_sha_2.jian_zhi_offer;

import java.util.LinkedHashMap;
import java.util.Map;

public class s50 {

    public static void main(String[] args) {

    }

//    在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。

    public static char firstUniqChar(String s) {

        Map<Character, Boolean> m = new LinkedHashMap<>();
//        int n = s.length();
//
//        for (int i = 0; i < n; i++) {
//            char c = s.charAt(i);
//            if (!m.containsKey(c)){
//                m.put(c, true);
//            }else {
//                m.put(c, false);
//            }
//        }

        char[] ss = s.toCharArray();
        for (char c : ss) {
            if (!m.containsKey(c)){
                m.put(c, true);
            }else {
                m.put(c, false);
            }
        }

        for (Map.Entry<Character, Boolean> d : m.entrySet()) {
            if (d.getValue()){
                return d.getKey();
            }
        }

        return ' ';

    }

}
