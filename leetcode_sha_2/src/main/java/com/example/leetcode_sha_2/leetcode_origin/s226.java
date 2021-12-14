package com.example.leetcode_sha_2.leetcode_origin;

import com.example.leetcode_sha_2.class_sha.TreeNode;

public class s226 {

    public static void main(String[] args) {

    }

//    翻转一棵二叉树。

    public TreeNode invertTree(TreeNode root) {
        if(root==null){
            return null;
        }

        TreeNode tmp = root.left;
        root.left = invertTree(root.right);
        root.right = invertTree(tmp);

        return root;

    }

}
