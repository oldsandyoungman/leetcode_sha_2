package com.example.leetcode_sha_2.microsoft_sha;

import java.util.HashMap;

public class ma2 {

    public int cal(String s, int[] x, int[] y){
        char[] ss = s.toCharArray();
        int n = x.length;

        Long min = Long.MAX_VALUE;

        HashMap<Character, Long> memo = new HashMap<>();

        for (int i = 0; i < n; i++) {

            char c = ss[i];

            long dist = (long) x[i] *x[i]+ (long) y[i] *y[i];

            if(memo.containsKey(ss[i])){
                if(memo.get(c)<dist){
                    min = Math.min(min, dist);
                }else{
                    min = memo.get(c);
                    memo.put(c, dist);
                }
            }else{
                memo.put(ss[i], dist);
            }

        }

        int res = 0;

        for (Character character : memo.keySet()) {
            if(memo.get(character)<min){
                res++;
            }
        }

        return res;


    }

}
