package com.example.leetcode_sha_2.jian_zhi_offer;

public class s04_no {

    public static void main(String[] args) {

    }

//    在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个高效的函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
//
//    来源：力扣（LeetCode）
//    链接：https://leetcode-cn.com/problems/er-wei-shu-zu-zhong-de-cha-zhao-lcof
//    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。


    public static boolean findNumberIn2DArray(int[][] matrix, int target) {
        int m = matrix.length;
        if (m==0){
            return false;
        }
        int n = matrix[0].length;

        int i = m-1;
        int j = 0;

        while (i>=0 && j<n) {

            int cur = matrix[i][j];

            if (cur>target){
                i--;
            }else if (cur<target) {
                j++;
            }else {
                return true;
            }

        }

        return false;


    }

}
