package com.example.leetcode_sha_2.leetcode_origin;

import java.util.LinkedList;

public class s372 {

    public static void main(String[] args) {
        int a = 2147483647;
        int[] b = {2, 0, 0};
        System.out.println(superPow(a, b));
    }

//    你的任务是计算 ab 对 1337 取模，a 是一个正整数，b 是一个非常大的正整数且会以数组形式给出。



//    public static int superPow(int a, int[] b) {
//
//        LinkedList<Integer> l = new LinkedList<>();
//        for(int tmp : b){
//            l.addLast(tmp);
//        }
//
//        return superPow(a, l);
//
//    }
//
//    public static int superPow(int a, LinkedList<Integer> l) {
//
//        if(l.isEmpty()){
//            return 1;
//        }
//
//        a = a%1337;
//
//        // int res = 1;
//        // while(!l.isEmpty()){
//        //     int last = l.removeLast();
//        //     res = (res * myPow(a, last))%1337;
//        //     a = myPow(a, 10);
//        // }
//
//        // return res;
//
//        int last = l.removeLast();
//        int part1 = myPow(a, last);
//        int part2 = myPow(superPow(a, l), 10);
//
//        return (part1*part2)%1337;
//
//    }
//
//    public static int myPow(int a, int b){
//        if(b==0){
//            return 1;
//        }
//
//        a = a%1337;
//
//        if(b%2==1){
//            return (a*myPow(a,b-1))%1337;
//        }else{
//            // a = (a*a)%1337;
//            // return (myPow(a, b/2))%1337;
//            int sub = myPow(a, b/2)%1337;
//            return (sub*sub)%1337;
//        }
//    }

    public static int superPow(int a, int[] b) {
        int n = b.length;

        return superPow(a, b, n-1);

    }

    public static int superPow(int a, int[] b, int index) {
        if(index==-1){
            return 1;
        }

        a = a%1337;

        int res1 = (int)(Math.pow(a, b[index])%1337);
        int res2 = (int)(Math.pow(superPow(a, b, index-1), 10)%1337);

        return (res1 * res2)%1337;

    }

}
