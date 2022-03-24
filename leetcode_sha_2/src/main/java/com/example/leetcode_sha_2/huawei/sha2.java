package com.example.leetcode_sha_2.huawei;

import java.util.HashMap;
import java.util.Scanner;

public class sha2 {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        String s = in.nextLine();
        int n = in.nextInt();
        int[] target = new int[n];
        for(int i=0; i<n; i++){
            target[i] = in.nextInt();
        }

        int sz = s.length();
        int i = 0;
        HashMap<Integer, String> memo = new HashMap<>();
        while(i<sz){
            int tag = Integer.parseInt(s.substring(i,i+2), 16);
            i += 2;
            int len = Integer.parseInt(s.substring(i,i+2), 16);
            i += 2;
            if(i + 2*len>sz){
                break;
            }
            String res = len+" "+(i/2);
            memo.put(tag, res);
            i += 2*len;
        }

        for(int j=0; j<n; j++){
            if(memo.containsKey(target[j])){
                System.out.println(memo.get(target[j]));
            }else{
                System.out.println("0 0");
            }

        }

    }



}
