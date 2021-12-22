package com.example.leetcode_sha_2.leetcode_origin;

import com.example.leetcode_sha_2.class_sha.TreeNode;

public class s101 {

    public static void main(String[] args) {

    }

//    给定一个二叉树，检查它是否是镜像对称的。

    public boolean isSymmetric(TreeNode root) {
        return traverse(root.left, root.right);
    }
    public boolean traverse(TreeNode p, TreeNode q){
        if(p==null){
            return q==null;
        }

        if(q==null){
            return false;
        }

        if(p.val!=q.val){
            return false;
        }

        boolean l = traverse(p.left, q.right);
        boolean r = traverse(p.right, q.left);

        return l&&r;

    }

}
