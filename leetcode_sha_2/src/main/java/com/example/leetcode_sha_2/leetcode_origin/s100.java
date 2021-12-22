package com.example.leetcode_sha_2.leetcode_origin;

import com.example.leetcode_sha_2.class_sha.TreeNode;

public class s100 {

    public static void main(String[] args) {

    }

//    给你两棵二叉树的根节点 p 和 q ，编写一个函数来检验这两棵树是否相同。
//
//    如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的

    public boolean isSameTree(TreeNode p, TreeNode q) {
        return traverse(p, q);
    }
    public boolean traverse(TreeNode p, TreeNode q){
        if(p==null){
            if(q==null){
                return true;
            }
            return false;
        }
        if(q==null){
            return false;
        }

        if(p.val!=q.val){
            return false;
        }
        boolean l = traverse(p.left, q.left);
        boolean r = traverse(p.right, q.right);

        return l && r;

    }

}
