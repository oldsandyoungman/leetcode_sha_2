package com.example.leetcode_sha_2.leetcode_origin;

import com.example.leetcode_sha_2.class_sha.TreeNode;

public class s110 {

    public static void main(String[] args) {

    }

//    给定一个二叉树，判断它是否是高度平衡的二叉树。
//
//    本题中，一棵高度平衡二叉树定义为：
//
//    一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1 。


    public boolean isBalanced(TreeNode root) {
        int res = traverse(root);
        return res!=-1;
    }

    public int traverse(TreeNode root){
        if(root==null){
            return 0;
        }

        int l = traverse(root.left);
        int r = traverse(root.right);

        if(l==-1 || r==-1){
            return -1;
        }

        if(Math.abs(l-r)>1){
            return -1;
        }
        return 1+Math.max(l,r);



    }

}
