package com.example.leetcode_sha_2.wangyi;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class ni1 {

//    字符流的第一个只出现一次的字符

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        HashMap<Character, Integer> memo = new HashMap<>();
        ArrayDeque<Character> q = new ArrayDeque<>();

        while(in.hasNextLine()){
            String s = in.nextLine();
            char c = s.charAt(0);

            if (memo.getOrDefault(c,0).equals(0)){
                memo.put(c, 1);
                q.addLast(c);
            }else{
                memo.put(c, memo.get(c)+1);
                while(!q.isEmpty() && memo.getOrDefault(q.getFirst(),0)>1){
                    q.removeFirst();
                }
            }

            System.out.println(q.isEmpty()?"#":q.getFirst());

        }

    }



}
