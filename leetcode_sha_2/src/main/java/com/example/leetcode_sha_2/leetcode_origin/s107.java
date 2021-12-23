package com.example.leetcode_sha_2.leetcode_origin;

import com.example.leetcode_sha_2.class_sha.TreeNode;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.List;

public class s107 {

    public static void main(String[] args) {

    }

//    给定一个二叉树，返回其节点值自底向上的层序遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        if(root==null){
            return res;
        }

        ArrayDeque<TreeNode> q = new ArrayDeque<>();
        q.addLast(root);
        while(!q.isEmpty()){
            int n = q.size();
            LinkedList<Integer> tmp = new LinkedList<>();
            for(int i=0; i<n; i++){
                TreeNode cur = q.removeFirst();
                tmp.addLast(cur.val);
                if(cur.left!=null){
                    q.addLast(cur.left);
                }
                if(cur.right!=null){
                    q.addLast(cur.right);
                }
            }
            res.add(0,tmp);
        }

        return res;

    }

}
