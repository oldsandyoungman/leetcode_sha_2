package com.example.leetcode_sha_2.jian_zhi_offer;

import com.example.leetcode_sha_2.class_sha.TreeNode;

public class s54 {

    public static void main(String[] args) {

    }

//    给定一棵二叉搜索树，请找出其中第k大的节点。

    public int num;
    public int res;
    public int kthLargest(TreeNode root, int k) {
        num = 0;
        res = 0;
        traverse(root, k);
        return res;
    }
    public void traverse(TreeNode root, int k){
        if(root==null || num>=k){
            return;
        }
        traverse(root.right, k);
        num++;
        if(num==k){
            res = root.val;
        }
        traverse(root.left, k);
    }

}
