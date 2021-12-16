package com.example.leetcode_sha_2.leetcode_origin;

public class s96 {

    public static void main(String[] args) {

    }

//    给你一个整数 n ，求恰由 n 个节点组成且节点值从 1 到 n 互不相同的 二叉搜索树 有多少种？返回满足题意的二叉搜索树的种数。

    public int numTrees(int n) {
        memo = new int[n+1][n+1];
        return traverse(1, n);
    }
    int[][] memo;
    public int traverse(int start, int end){
        if(start>end){
            return 1;
        }
        if(memo[start][end]>0){
            return memo[start][end];
        }
        int res = 0;
        for(int i=start; i<=end; i++){
            int l = traverse(start, i-1);
            int r = traverse(i+1, end);
            res += l*r;
        }
        memo[start][end] = res;
        return res;
    }

}
