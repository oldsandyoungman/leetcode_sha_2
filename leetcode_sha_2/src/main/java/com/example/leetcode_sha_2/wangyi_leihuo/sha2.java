package com.example.leetcode_sha_2.wangyi_leihuo;

import java.util.Arrays;
import java.util.Scanner;

public class sha2 {


//2
//5
//9 9 9 9 9
//A B C D E
//5
//3 2 1 10 9
//A A A A A




    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        int M = in.nextInt();
        for(int ii=0; ii<M; ii++){
            int N = in.nextInt();
            int[] nums = new int[N];
            char[] kinds = new char[N];

            for(int i=0; i<N; i++){
                nums[i] = in.nextInt();
            }
            String s = in.nextLine();
            s = in.nextLine();
            String[] ss = s.split(" ");
            for(int i=0; i<N; i++){
                kinds[i] = ss[i].charAt(0);
            }

            int res = calnum(N, nums, kinds);

            System.out.println(res);

        }

    }

    public static int calnum(int N, int[] nums, char[] kinds){
        int res = 1;

        Arrays.sort(nums);

        // 1
        if(N==5 && nums[0]==nums[1] && nums[1]==nums[2] && nums[2]==nums[3] && nums[3]==nums[4]){
            res *= 15000;
            return res;
        }

        // 2 & 3
        if(N==5 && kinds[0]==kinds[1] && kinds[1]==kinds[2] && kinds[2]==kinds[3] && kinds[3]==kinds[4]){
            if(nums[0]+1==nums[1] && nums[1]+1==nums[2] && nums[2]+1==nums[3] && nums[3]+1==nums[4]){
                res *= 8000;
            }else{
                res *= 300;
            }
            return res;
        }

        // 4
        if((N>=4 && nums[0]==nums[1] && nums[1]==nums[2] && nums[2]==nums[3]) || (N==5 && nums[1]==nums[2] && nums[2]==nums[3] && nums[3]==nums[4])){
            res *= 150;
            return res;
        }

        // 5
        if((N==5 && nums[0]==nums[1] && nums[1]==nums[2] && nums[3]==nums[4]) || (N==5 && nums[0]==nums[1] && nums[2]==nums[3] && nums[3]==nums[4])){
            res *= 40;
            return res;
        }

        // 6
        if(N==5 && nums[0]+1==nums[1] && nums[1]+1==nums[2] && nums[2]+1==nums[3] && nums[3]+1==nums[4]){
            res *= 20;
            return res;
        }

        // 7
        if((N>=3 && nums[0]==nums[1] && nums[1]==nums[2]) || (N>=4 && nums[1]==nums[2] && nums[2]==nums[3]) || (N==5 && nums[2]==nums[3] && nums[3]==nums[4]) ){
            res *= 6;
            return res;
        }

        // 8
        if((N>=4 && nums[0]==nums[1] && nums[2]==nums[3]) || (N==5 && nums[0]==nums[1] && nums[3]==nums[4]) || (N==5 && nums[1]==nums[2] && nums[3]==nums[4]) ){
            res *= 4;
            return res;
        }

        // 9
        if( (N>=2 && nums[0]==nums[1]) || (N>=3 && nums[1]==nums[2]) || (N>=4 && nums[2]==nums[3]) || (N==5 && nums[3]==nums[4]) ){
            res *= 2;
            return res;
        }

        return res;

    }

}
