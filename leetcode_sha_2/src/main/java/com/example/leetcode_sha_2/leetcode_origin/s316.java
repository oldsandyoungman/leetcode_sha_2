package com.example.leetcode_sha_2.leetcode_origin;

import java.util.ArrayDeque;
import java.util.List;

public class s316 {

    public static void main(String[] args) {
        String s = "cbacdcbc";
        System.out.println(removeDuplicateLetters(s));
    }

//    给你一个字符串 s ，请你去除字符串中重复的字母，使得每个字母只出现一次。需保证 返回结果的字典序最小（要求不能打乱其他字符的相对位置）。
//
//    注意：该题与 1081 https://leetcode-cn.com/problems/smallest-subsequence-of-distinct-characters 相同
//
//    来源：力扣（LeetCode）
//    链接：https://leetcode-cn.com/problems/remove-duplicate-letters
//    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

    public static String removeDuplicateLetters(String s) {
        char[] ss = s.toCharArray();
        boolean[] isInStack = new boolean[26];
        int[] count = new int[26];
        for(char cur : ss){
            int index = cur - 'a';
            count[index]++;
        }


        ArrayDeque<Character> q = new ArrayDeque<>();

        for(char cur : ss){
            int index = cur - 'a';
            count[index]--;
            if(isInStack[index]){
                continue;
            }

            while(!q.isEmpty() && q.getLast()>cur){
                char tmp = q.getLast();
                if(count[tmp-'a']>0){
                    q.removeLast();
                    isInStack[tmp-'a'] = false;
                }else{
                    break;
                }
            }

            q.addLast(cur);
            isInStack[cur-'a'] = true;

        }

        StringBuilder sb = new StringBuilder();
        while(!q.isEmpty()){
            sb.append(q.removeFirst());
        }

        return sb.toString();

    }

}
