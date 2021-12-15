package com.example.leetcode_sha_2.leetcode_origin;

import com.example.leetcode_sha_2.class_sha.TreeNode;

public class s106 {

    public static void main(String[] args) {

    }

//    根据一棵树的中序遍历与后序遍历构造二叉树。
//
//    注意:
//    你可以假设树中没有重复的元素。


    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int n = inorder.length;
        return traverse(inorder, 0, n-1, postorder, 0, n-1);
    }
    public TreeNode traverse(int[] inorder, int instart, int inend, int[] postorder, int poststart, int postend){
        if(instart>inend){
            return null;
        }

        int val = postorder[postend];
        int index;
        for(index=instart; index<inend; index++){
            if(val==inorder[index]){
                break;
            }
        }

        int len = index - instart;

        TreeNode root = new TreeNode(val);
        root.left = traverse(inorder, instart, index-1, postorder, poststart, poststart+len-1);
        root.right = traverse(inorder, index+1, inend, postorder, poststart+len, postend-1);

        return root;

    }

}
