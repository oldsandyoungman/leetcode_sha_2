package com.example.leetcode_sha_2.pinduoduo_sha;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class mi4 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        for(int i=0; i<num; i++){
            int[] s = new int[6];
            for (int j = 0; j < 6; j++) {
                s[j] = in.nextInt();
            }
            int[] t = new int[6];
            for (int j = 0; j < 6; j++) {
                t[j] = in.nextInt();
            }
            System.out.println(calMin(s, t));
        }
    }


    public static int calMin(int[] s, int[] t){
        HashSet<String> visited = new HashSet<>();
        ArrayDeque<int[]> q = new ArrayDeque<>();

        String start = Arrays.toString(s);
        String end = Arrays.toString(t);
        if(start.equals(end)){
            return 0;
        }

        visited.add(start);
        q.addLast(s);

        int step = 1;

        while (!q.isEmpty()){

            int n = q.size();

            for (int j = 0; j < n; j++) {
                int[] cur = q.removeFirst();
                for(int i=0; i<4; i++){
                    int[] next = change(cur, i);
                    String s_next = Arrays.toString(next);
                    if(s_next.equals(end)){
                        return step;
                    }
                    if(visited.contains(s_next)){
                        continue;
                    }
                    visited.add(s_next);
                    q.addLast(next);
                }
            }
            step++;
        }

        return -1;
    }

    // dir : 0前1后2左3右
    public static int[] change(int[] s, int dir){
        int[] t = new int[6];
        if(dir==0){
            t[0] = s[5];
            t[1] = s[4];
            t[2] = s[2];
            t[3] = s[3];
            t[4] = s[0];
            t[5] = s[1];
            return t;
        }
        if(dir==1){
            t[0] = s[4];
            t[1] = s[5];
            t[2] = s[2];
            t[3] = s[3];
            t[4] = s[1];
            t[5] = s[0];
            return t;
        }
        if(dir==2){
            t[0] = s[3];
            t[1] = s[2];
            t[2] = s[0];
            t[3] = s[1];
            t[4] = s[4];
            t[5] = s[5];
            return t;
        }

        t[0] = s[2];
        t[1] = s[3];
        t[2] = s[1];
        t[3] = s[0];
        t[4] = s[4];
        t[5] = s[5];
        return t;
    }

//    public static boolean isSame(int[] s, int[] t){
//        for(int i=0; i<6; i++){
//            if(s[i]!=t[i]){
//                return false;
//            }
//        }
//        return true;
//    }



}
