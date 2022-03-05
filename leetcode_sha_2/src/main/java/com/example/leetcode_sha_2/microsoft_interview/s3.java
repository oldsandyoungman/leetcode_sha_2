package com.example.leetcode_sha_2.microsoft_interview;

import java.util.ArrayList;
import java.util.HashSet;

public class s3 {

    public static void main(String[] args) {
//        int n = 1;
//        int n = 2;
//        int n = 26;
//        int n = 27;
//        int n = 703;
//        int n = 704;
//        int n = 702;
        int n = 53;
//        System.out.println(calRes2(n));
        System.out.println(calRes3(n));

//        HashSet<Integer> ss = new HashSet<>();
//        for (Integer s : ss) {
//
//        }
    }

    public static String calRes(int n){
        int x = n-1;
        ArrayList<Integer> res = new ArrayList<>();
        while(x>=26){
            int cur = x%26;
            x = x/26;
            res.add(0, cur);
        }
        res.add(0, x);

        int N = res.size();
        int[] nums = new int[N];
        for(int i=0; i<N; i++){
            nums[i] = res.get(i);
        }

        for(int i=1; i<N; i++){
            if (nums[i]==0) {
                nums[i-1]--;
                nums[i] = 25;
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!res.isEmpty()) {
            if(res.get(0)==0){
                res.remove(0);
                continue;
            }

            if(res.size()==1){
                int cur = res.remove(0);
                char c = (char) ('A'+cur);
                sb.append(c);
            }else{
                int cur = res.remove(0);
                char c = (char) ('A'+cur-1);
                sb.append(c);
            }

        }
        return sb.toString();
    }



    public static String calRes2(int n){

        int x = n;
        ArrayList<Integer> res = new ArrayList<>();
        while(x>=26){
            int cur = x%26;
            x = x/26;
            res.add(0, cur);
        }
        res.add(0, x);

        int N = res.size();
        int[] nums = new int[N];
        for(int i=0; i<N; i++){
            nums[i] = res.remove(0);
        }

        for (int i=N-1; i>=0; i--){

            if(nums[i]==0 && i>=1){
                nums[i-1]--;
                nums[i] = 26;
            }

        }
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<N; i++){
            if(nums[i]>0){
                char cur = (char)('A' + nums[i]-1);
                sb.append(cur);
            }
        }
        return sb.toString();
    }


    public static String calRes3(int n){
        StringBuilder sb = new StringBuilder();

        while (n>0){
            n--;
            sb.append((char)(n%26+'A'));
            n/=26;
        }
        return sb.reverse().toString();


    }

}
