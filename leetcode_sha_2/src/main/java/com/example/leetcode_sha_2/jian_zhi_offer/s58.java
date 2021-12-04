package com.example.leetcode_sha_2.jian_zhi_offer;

import java.util.Arrays;

public class s58 {

    public static void main(String[] args) {
        String s = "  hello world!  ";
        System.out.println(Arrays.toString(s.trim().split(" ")));
    }

//    输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变。为简单起见，标点符号和普通字母一样处理。例如输入字符串"I am a student. "，则输出"student. a am I"。
//
//    来源：力扣（LeetCode）
//    链接：https://leetcode-cn.com/problems/fan-zhuan-dan-ci-shun-xu-lcof
//    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

    public static String reverseWords(String s) {
        s = s.trim();
        int n = s.length();
        int left = n-1;
        int right = n-1;
        StringBuilder sb = new StringBuilder();

        while(left>=0){
            while(left>=0 && s.charAt(left)!=' '){
                left--;
            }
            sb.append(s, left+1, right+1).append(" ");
            while(left>=0 && s.charAt(left)==' '){
                left--;
            }
            right = left;
        }

        return sb.toString().trim();

    }


}
