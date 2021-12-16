package com.example.leetcode_sha_2.leetcode_origin;

import com.example.leetcode_sha_2.class_sha.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class s95 {

    public static void main(String[] args) {

    }

//    给你一个整数 n ，请你生成并返回所有由 n 个节点组成且节点值从 1 到 n 互不相同的不同 二叉搜索树 。可以按 任意顺序 返回答案。

    public List<TreeNode> generateTrees(int n) {
        return traverse(1, n);
    }
    public List<TreeNode> traverse(int start, int end){
        if(start>end){
            List<TreeNode> res = new ArrayList<>();
            res.add(null);
            return res;
        }

        List<TreeNode> res = new ArrayList<>();
        for(int i=start; i<=end; i++){

            List<TreeNode> l = traverse(start, i-1);
            List<TreeNode> r = traverse(i+1, end);

            for(TreeNode cur_l : l){
                for(TreeNode cur_r : r){


                    // 这一步位置别搞错
                    TreeNode root = new TreeNode(i);

                    root.left = cur_l;
                    root.right = cur_r;
                    res.add(root);
                }
            }
        }

        return res;

    }

}
