package com.example.leetcode_sha_2.huawei;

import java.util.Scanner;

public class sha1 {

//    n-1的版本

    public static void main(String[] args) {
        // please define the JAVA input here. For example: Scanner s = new Scanner(System.in);
        // please finish the function body here.
        // please define the JAVA output here. For example: System.out.println(s.nextInt());


//        int nn = 1111;
//        nn = nn>>>1;
//        System.out.println(nn);

        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int[] nums = new int[n];
        for(int i=0; i<n; i++){
            nums[i] = in.nextInt();
        }
        int k = in.nextInt();

        int farthest = 0;
        int end = 0;
        int count = 0;
        for (int i = 0; i < n-1; i++) {
//            if (i>farthest){
//                System.out.println(-1);
//                return;
//            }
            farthest = Math.max(farthest, nums[i]+i);
            if(end==i){
                count++;
                end = farthest;
            }
        }

        if(end<n-1){
            System.out.println(-1);
            return;
        }

        if(count>k){
            System.out.println(-1);
        }else{
            System.out.println(count);
        }


    }



//    n的版本

//    public static void main(String[] args) {
//        // please define the JAVA input here. For example: Scanner s = new Scanner(System.in);
//        // please finish the function body here.
//        // please define the JAVA output here. For example: System.out.println(s.nextInt());
//
//        Scanner in = new Scanner(System.in);
//
//        int n = in.nextInt();
//        int[] nums = new int[n];
//        for(int i=0; i<n; i++){
//            nums[i] = in.nextInt();
//        }
//        int k = in.nextInt();
//
//        int farthest = 0;
//        int end = 0;
//        int count = 0;
//        for (int i = 0; i < n; i++) {
//            if (i>farthest){
//                System.out.println(-1);
//                return;
//            }
//            farthest = Math.max(farthest, nums[i]+i);
//            if(end>=n-1){
//                break;
//            }
//            if(end==i){
//                count++;
//                end = farthest;
//            }
//        }
//
//        if(count>k){
//            System.out.println(-1);
//        }else{
//            System.out.println(count);
//        }
//
//
//    }



}
