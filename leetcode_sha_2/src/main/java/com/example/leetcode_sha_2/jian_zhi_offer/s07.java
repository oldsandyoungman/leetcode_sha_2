package com.example.leetcode_sha_2.jian_zhi_offer;

import com.example.leetcode_sha_2.class_sha.TreeNode;

public class s07 {

    public static void main(String[] args) {
        int[] a = {3,9,20,15,7};
        int[] b = {9,3,15,20,7};
        System.out.println(buildTree(a, b));
    }

//    输入某二叉树的前序遍历和中序遍历的结果，请构建该二叉树并返回其根节点。
//
//    假设输入的前序遍历和中序遍历的结果中都不含重复的数字。


    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        return traverse(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1);
    }
    public static TreeNode traverse(int[] preorder, int prestart, int preend, int[] inorder, int instart, int inend){
        if(prestart>preend){
            return null;
        }

        int val = preorder[prestart];
        TreeNode root = new TreeNode(val);

        int index = instart;
        while(inorder[index]!=val){
            index++;
        }

        int len = index-instart;

        root.left = traverse(preorder, prestart+1, prestart+len, inorder, instart, index-1);
        root.right = traverse(preorder, prestart+len+1, preend, inorder, index+1, inend);

        return root;


    }



}
