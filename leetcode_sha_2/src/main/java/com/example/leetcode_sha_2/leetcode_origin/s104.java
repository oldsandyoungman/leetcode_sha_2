package com.example.leetcode_sha_2.leetcode_origin;

import com.example.leetcode_sha_2.class_sha.TreeNode;

public class s104 {

    public static void main(String[] args) {

    }

//    给定一个二叉树，找出其最大深度。
//
//    二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
//
//    说明: 叶子节点是指没有子节点的节点。


    public int res;
    public int depth;
    public int maxDepth(TreeNode root) {
        res = 0;
        depth = 0;
        traverse(root);
        return res;
    }
    public void traverse(TreeNode root){
        if(root==null){
            return;
        }
        depth++;
        res = Math.max(res, depth);
        traverse(root.left);
        traverse(root.right);
        depth--;

    }



}
