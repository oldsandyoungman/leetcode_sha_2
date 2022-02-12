package com.example.leetcode_sha_2.leetcode_origin;

import java.util.LinkedList;

public class s392 {

    public static void main(String[] args) {

    }

    public boolean isSubsequence(String s, String t) {

        // int m = s.length();
        // int n = t.length();

        // int i = 0;
        // int j = 0;

        // while(i<m && j<n){
        //     if(s.charAt(i)==t.charAt(j)){
        //         i++;
        //     }
        //     j++;
        // }

        // return i==m;


        LinkedList<Integer>[] memo = new LinkedList[26];
        char[] ss = s.toCharArray();
        char[] tt = t.toCharArray();
        int m = ss.length;
        int n = tt.length;
        for(int i=0; i<n; i++){
            if(memo[tt[i]-'a']==null){
                memo[tt[i]-'a'] = new LinkedList<>();
            }
            memo[tt[i]-'a'].addLast(i);
        }

        // 当前要判断的s[i]
        int i = 0;
        // 在t中已经判断到的位置
        int j = -1;

        while(i<m){
            char cur = ss[i];
            LinkedList<Integer> list = memo[cur-'a'];

            if(list==null){
                return false;
            }

            int left = 0;
            int right = list.size()-1;
            while(left<=right){
                int mid = left + (right-left)/2;
                if(list.get(mid)<=j){
                    left = mid + 1;
                }else{
                    right = mid - 1;
                }
            }
            if(left>=list.size()){
                return false;
            }

            j = list.get(left);
            i++;

        }

        return true;

    }

}
