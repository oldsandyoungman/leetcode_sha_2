package com.example.leetcode_sha_2.pinduoduo_sha;

import java.util.Scanner;

public class mi2 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int num = in.nextInt();

        for(int i=0; i<num; i++){
            int changeNum = in.nextInt();
            int len = in.nextInt();
            String s = in.nextLine();
            System.out.println(calKind(changeNum, len, s));
        }




    }

    public static int calKind(int changeNum, int len, String s){
        if(changeNum==0){
            return 1;
        }

        char[] ss = s.toCharArray();
        int i = 0;
        int j = 0;

        if(len%2==0){
            i = len/2-1;
            j = len/2;
        }else{
            i = len/2;
            j = len/2;
        }

        boolean flag = true;

        while(i>=0 && j<len){
            if(ss[i]!=ss[j]){
                flag = false;
                break;
            }
            i--;
            j++;
        }

        if(flag){
            return 1;
        }else{
            return 2;
        }

    }



}
