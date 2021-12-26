package com.example.leetcode_sha_2.leetcode_origin;

import com.example.leetcode_sha_2.class_sha.TreeNode;

import java.util.LinkedList;
import java.util.List;

public class s144 {

    public static void main(String[] args) {

    }

//    给你二叉树的根节点 root ，返回它节点值的 前序 遍历。

    public List<Integer> preorderTraversal(TreeNode root) {
        res = new LinkedList<>();
        traverse(root);
        return res;
    }
    public List<Integer> res;
    public void traverse(TreeNode root){
        if(root==null){
            return;
        }
        res.add(root.val);
        traverse(root.left);
        traverse(root.right);
    }

}
