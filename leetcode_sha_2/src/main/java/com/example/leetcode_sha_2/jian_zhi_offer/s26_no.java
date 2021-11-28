package com.example.leetcode_sha_2.jian_zhi_offer;

import com.example.leetcode_sha_2.class_sha.TreeNode;

public class s26_no {

    public static void main(String[] args) {

    }

//    输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构)
//
//    B是A的子结构， 即 A中有出现和B相同的结构和节点值。

    public boolean isSubStructure(TreeNode A, TreeNode B) {
        return (A != null && B != null) && (recur(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B));
    }
    boolean recur(TreeNode A, TreeNode B) {
        if(B == null) return true;
        if(A == null || A.val != B.val) return false;
        return recur(A.left, B.left) && recur(A.right, B.right);
    }

}
