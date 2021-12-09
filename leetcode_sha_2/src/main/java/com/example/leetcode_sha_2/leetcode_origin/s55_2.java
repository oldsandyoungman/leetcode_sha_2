package com.example.leetcode_sha_2.leetcode_origin;

import com.example.leetcode_sha_2.class_sha.TreeNode;

public class s55_2 {

    public static void main(String[] args) {

    }

//    输入一棵二叉树的根节点，判断该树是不是平衡二叉树。如果某二叉树中任意节点的左右子树的深度相差不超过1，那么它就是一棵平衡二叉树。

    public boolean isBalanced(TreeNode root) {
        int res = traverse(root);
        return res!=-1;
    }
    public int traverse(TreeNode root){
        if(root==null){
            return 0;
        }
        int l = traverse(root.left);
        if(l==-1){
            return -1;
        }
        int r = traverse(root.right);
        if(r==-1){
            return -1;
        }
        return Math.abs(l-r)<=1?Math.max(l, r)+1:-1;

    }

}
