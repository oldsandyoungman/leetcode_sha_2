package com.example.leetcode_sha_2.jian_zhi_offer;

import com.example.leetcode_sha_2.class_sha.TreeNode;

public class s28_no {


    public static void main(String[] args) {

    }

//    请实现一个函数，用来判断一棵二叉树是不是对称的。如果一棵二叉树和它的镜像一样，那么它是对称的。

    public boolean isSymmetric(TreeNode root) {
        if(root==null){
            return true;
        }
        return traverse(root.left, root.right);
    }
    public boolean traverse(TreeNode left, TreeNode right){
        if(left==null && right==null){
            return true;
        }
        if(left==null || right==null || left.val!=right.val){
            return false;
        }
        return traverse(left.left, right.right) && traverse(left.right, right.left);
    }

}
