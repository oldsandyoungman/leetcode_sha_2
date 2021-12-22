package com.example.leetcode_sha_2.leetcode_origin;

import com.example.leetcode_sha_2.class_sha.TreeNode;

import java.util.LinkedList;
import java.util.List;

public class s94 {

    public static void main(String[] args) {

    }

//    给定一个二叉树的根节点 root ，返回它的 中序 遍历。

    public List<Integer> res;
    public List<Integer> inorderTraversal(TreeNode root) {
        res = new LinkedList<>();
        traverse(root);
        return res;
    }
    public void traverse(TreeNode root){
        if(root==null){
            return;
        }
        traverse(root.left);
        res.add(root.val);
        traverse(root.right);
    }

}
