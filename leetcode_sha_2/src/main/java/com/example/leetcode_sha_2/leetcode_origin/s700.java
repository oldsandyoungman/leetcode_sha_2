package com.example.leetcode_sha_2.leetcode_origin;

import com.example.leetcode_sha_2.class_sha.TreeNode;

public class s700 {

    public static void main(String[] args) {

    }

//    给定二叉搜索树（BST）的根节点和一个值。 你需要在BST中找到节点值等于给定值的节点。 返回以该节点为根的子树。 如果节点不存在，则返回 NULL。

    public TreeNode searchBST(TreeNode root, int val) {
        // if(root==null){
        //     return null;
        // }
        // if(root.val == val){
        //     return root;
        // }
        // TreeNode l = searchBST(root.left, val);
        // TreeNode r = searchBST(root.right, val);

        // return l!=null?l:r;

        if(root==null){
            return null;
        }
        if(root.val == val){
            return root;
        }
        if(root.val > val){
            return searchBST(root.left, val);
        }
        return searchBST(root.right, val);

    }


}
