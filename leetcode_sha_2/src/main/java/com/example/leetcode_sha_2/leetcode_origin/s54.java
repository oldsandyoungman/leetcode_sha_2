package com.example.leetcode_sha_2.leetcode_origin;

import java.util.LinkedList;
import java.util.List;

public class s54 {

    public static void main(String[] args) {
        int[][] matrix = {{1,2,3,4}, {5,6,7,8}, {9,10,11,12}};
        System.out.println(spiralOrder(matrix));
    }

//    给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。

    public static List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        List<Integer> res = new LinkedList<>();

        int ll = 0;
        int rr = n-1;
        int tt = 0;
        int bb = m-1;

//         1 ,2 ,3, 4
//         5 ,6, 7, 8
//         9 ,10,11,12
//         13,14,15,16

        while(res.size()<m*n){

            for(int i=ll; i<=rr; i++){
                res.add(matrix[tt][i]);
            }
            tt++;

            for(int i=tt; i<=bb; i++){
                res.add(matrix[i][rr]);
            }
            rr--;

            for(int i=rr; i>=ll; i--){
                res.add(matrix[bb][i]);
            }
            bb--;

            for(int i=bb; i>=tt; i--){
                res.add(matrix[i][ll]);
            }
            ll++;

        }

        return res;
    }

}
