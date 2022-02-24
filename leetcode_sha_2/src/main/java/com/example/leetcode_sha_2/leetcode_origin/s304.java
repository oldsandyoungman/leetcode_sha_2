package com.example.leetcode_sha_2.leetcode_origin;

import java.util.Arrays;

public class s304 {

    public static void main(String[] args) {
        int[][] matrix = {{3,0,1,4,2},{5,6,3,2,1},{1,2,0,1,5},{4,1,0,1,7},{1,0,3,0,5}};

        NumMatrix nm = new NumMatrix(matrix);
        NumMatrix2 nm2 = new NumMatrix2(matrix);
        System.out.println(Arrays.deepToString(nm.preSum));
        System.out.println(Arrays.deepToString(nm2.preSum));
        System.out.println("1111");

    }

}


class NumMatrix {

    int[][] preSum;

    public NumMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        preSum = new int[m+1][n+1];
        // for(int i=1; i<=m; i++){
        //     preSum[i][1] = preSum[i-1][1] + matrix[i-1][0];
        // }

        for(int i=1; i<=m; i++){
            for(int j=1; j<=n; j++){
                preSum[i][j] = preSum[i][j-1] + preSum[i-1][j] + matrix[i-1][j-1] - preSum[i-1][j-1];
            }
        }

    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return preSum[row2+1][col2+1] - preSum[row2+1][col1] - preSum[row1][col2+1] + preSum[row1][col1];
    }
}

class NumMatrix2 {

    int[][] preSum;

    public NumMatrix2(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        preSum = new int[m+1][n+1];
        // for(int i=1; i<=m; i++){
        //     preSum[i][1] = preSum[i-1][1] + matrix[i-1][0];
        // }

        for(int i=1; i<=m; i++){
            for(int j=1; j<=n; j++){
                preSum[i][j] = preSum[i][j-1] + matrix[i-1][j-1];
            }
        }

    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return preSum[row2+1][col2+1] - preSum[row2+1][col1] - preSum[row1][col2+1] + preSum[row1][col1];
    }
}