package com.example.leetcode_sha_2.leetcode_origin;

import java.util.Arrays;

public class s59 {

    public static void main(String[] args) {
        int n = 3;
        System.out.println(Arrays.deepToString(generateMatrix(n)));
    }


//    给你一个正整数 n ，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。

    public static int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];

        int ll=0;
        int rr=n-1;
        int tt=0;
        int bb=n-1;

        int cur=1;
        int sum=n*n;

        while(cur<=sum){
            if(cur<=sum){
                for(int i=ll; i<=rr; i++){
                    res[tt][i] = cur++;
                }
                tt++;
            }

            if(cur<=sum){
                for(int i=tt; i<=bb; i++){
                    res[i][rr] = cur++;
                }
                rr--;
            }

            if(cur<=sum){
                for(int i=rr; i>=ll; i--){
                    res[bb][i] = cur++;
                }
                bb--;
            }

            if(cur<=sum){
                for(int i=bb; i>=tt; i--){
                    res[i][ll] = cur++;
                }
                ll++;
            }

        }

        return res;

    }

}
