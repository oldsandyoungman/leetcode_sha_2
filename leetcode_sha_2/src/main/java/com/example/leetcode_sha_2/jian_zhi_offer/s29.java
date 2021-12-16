package com.example.leetcode_sha_2.jian_zhi_offer;

import java.util.Arrays;

public class s29 {

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        System.out.println(Arrays.toString(spiralOrder(matrix)));
    }

//    输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。

    public static int[] spiralOrder(int[][] matrix) {
        int m = matrix.length;
        if(m==0){
            return new int[0];
        }
        int n = matrix[0].length;

        int left = 0;
        int right = n-1;
        int top = 0;
        int bottom = m-1;

        int[] res = new int[m*n];

        int index = 0;

        while(true){
            for(int j=left; j<=right; j++){
                res[index++] = matrix[top][j];
            }
            if(++top>bottom){
                break;
            }



            for(int i=top; i<=bottom; i++){
                res[index++] = matrix[i][right];
            }
            if(--right<left){
                break;
            }

            for(int j=right; j>=left; j--){
                res[index++] = matrix[bottom][j];
            }
            if(--bottom<top){
                break;
            }

            for(int i=bottom; i>=top; i--){
                res[index++] = matrix[i][left];
            }
            if(++left>right){
                break;
            }

        }

        return res;


    }

    
}
