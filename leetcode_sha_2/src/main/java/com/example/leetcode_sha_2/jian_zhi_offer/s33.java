package com.example.leetcode_sha_2.jian_zhi_offer;

public class s33 {

    public static void main(String[] args) {
        int[] postorder = {1,2,5,10,6,9,4,3};

        System.out.println(verifyPostorder(postorder));

    }

//    输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。如果是则返回 true，否则返回 false。假设输入的数组的任意两个数字都互不相同。

    public static boolean verifyPostorder(int[] postorder) {
        return traverse(postorder, 0, postorder.length - 1);
    }

    public static boolean traverse(int[] postorder, int i, int j) {
        if (i >= j) {
            return true;
        }
        int p = i;
        while (postorder[p] < postorder[j]) {
            p++;
        }
        int m = p;
        while (postorder[p] > postorder[j]) {
            p++;
        }
        return p == j && traverse(postorder, i, m - 1) && traverse(postorder, m, j - 1);
    }

}
