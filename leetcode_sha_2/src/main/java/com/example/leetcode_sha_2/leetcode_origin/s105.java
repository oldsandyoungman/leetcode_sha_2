package com.example.leetcode_sha_2.leetcode_origin;

import com.example.leetcode_sha_2.class_sha.TreeNode;

public class s105 {

    public static void main(String[] args) {
        int[] preorder = {3,9,20,15,7};
        int[] inorder = {9,3,15,20,7};

        buildTree(preorder, inorder);
    }

//    给定一棵树的前序遍历 preorder 与中序遍历  inorder。请构造二叉树并返回其根节点。


    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        return traverse(preorder, 0, n-1, inorder, 0, n-1);
    }
    public static TreeNode traverse(int[] preorder, int prestart, int preend, int[] inorder, int instart, int inend){
        if(prestart>preend){
            return null;
        }
        int val = preorder[prestart];
        int index;
        for(index=instart; index<=inend; index++){
            if(val==inorder[index]){
                break;
            }
        }

        int len = index - instart;
        TreeNode root = new TreeNode(val);
        root.left = traverse(preorder, prestart+1, prestart+len, inorder, instart, index-1);
        root.right = traverse(preorder, prestart+len+1, preend, inorder, index+1, inend);

        return root;

    }

}
