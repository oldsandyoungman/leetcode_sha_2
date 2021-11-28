package com.example.leetcode_sha_2.jian_zhi_offer;

import com.example.leetcode_sha_2.class_sha.TreeNode;

public class s27 {

    public static void main(String[] args) {

    }

//    请完成一个函数，输入一个二叉树，该函数输出它的镜像。

    public TreeNode mirrorTree(TreeNode root) {
        if(root==null){
            return null;
        }
        TreeNode tmp = root.left;
        root.left = mirrorTree(root.right);
        root.right = mirrorTree(tmp);

        return root;

    }





}
