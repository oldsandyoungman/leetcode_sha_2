package com.example.leetcode_sha_2.leetcode_origin;

import com.example.leetcode_sha_2.class_sha.TreeNode;

public class s99 {

    public static void main(String[] args) {

    }

//    给你二叉搜索树的根节点 root ，该树中的两个节点的值被错误地交换。请在不改变其结构的情况下，恢复这棵树。

    public void recoverTree(TreeNode root) {
        traverse(root);
        int tmp = a.val;
        a.val = b.val;
        b.val = tmp;
    }
    public TreeNode pre = null;
    public TreeNode a = null;
    public TreeNode b = null;
    public void traverse(TreeNode root){
        if(root==null){
            return;
        }

        traverse(root.left);
        if(pre!=null && root.val<pre.val){
            if(a==null){
                a = pre;
                b = root;
            }else{
                b = root;
            }
        }
        pre = root;
        traverse(root.right);

    }

}
