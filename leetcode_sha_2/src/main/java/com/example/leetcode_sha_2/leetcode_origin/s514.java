package com.example.leetcode_sha_2.leetcode_origin;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class s514 {

    public static void main(String[] args) {
        String ring = "godding";
        String key = "gd";

        System.out.println(findRotateSteps(ring, key));

    }

    public static int findRotateSteps(String ring, String key) {
        int m = ring.length();
        int n = key.length();
        memo = new int[m][n];
        mm = new HashMap<>();
        char[] rr = ring.toCharArray();
        for(int i=0; i<rr.length; i++){
            mm.putIfAbsent(rr[i], new LinkedList<>());
            mm.get(rr[i]).addLast(i);
        }
        return traverse(ring, 0, key, 0);

    }

    public static int[][] memo;
    public static HashMap<Character, LinkedList<Integer>> mm;

    public static int traverse(String ring, int ring_start, String key, int key_start){
        if(key_start==key.length()){
            return 0;
        }

        if(memo[ring_start][key_start]!=0){
            return memo[ring_start][key_start];
        }

        int m = ring.length();
        char target = key.charAt(key_start);
        int res = Integer.MAX_VALUE;

        for(int i : mm.get(target)){
            int delta = Math.abs(i - ring_start);
            delta = Math.min(delta, m-delta);
            int tmp_res = traverse(ring, i, key, key_start+1) + delta + 1;
            res = Math.min(res, tmp_res);
        }

        memo[ring_start][key_start] = res;

        return res;


        // if(key.charAt(key_start)==ring.charAt(ring_start)){
        //     int res = traverse(ring, ring_start+1, key, key_start+1);
        //     memo[ring_start][key_start] = res;
        //     return res;

        // }else{
        //     int res1 = traverse(ring, ring_start+1, key, key_start);
        //     int res2 = traverse(ring, ring_start+m-1, key, key_start);
        //     int res = Math.min(res1, res2) + 1;
        //     memo[ring_start][key_start] = res;
        //     return res;
        // }

    }




}

