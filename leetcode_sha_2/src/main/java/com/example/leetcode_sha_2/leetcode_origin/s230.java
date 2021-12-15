package com.example.leetcode_sha_2.leetcode_origin;

import com.example.leetcode_sha_2.class_sha.TreeNode;

public class s230 {

    public static void main(String[] args) {

    }


//    给定一个二叉搜索树的根节点 root ，和一个整数 k ，请你设计一个算法查找其中第 k 个最小元素（从 1 开始计数）。

    public int res = -1;
    public int rank = 0;
    public int kthSmallest(TreeNode root, int k) {
        traverse(root, k);
        return res;

    }
    public void traverse(TreeNode root, int k){
        if(root==null){
            return;
        }

        traverse(root.left, k);

        rank++;
        if(rank==k){
            res = root.val;
            return;
        }

        traverse(root.right, k);

    }

}
