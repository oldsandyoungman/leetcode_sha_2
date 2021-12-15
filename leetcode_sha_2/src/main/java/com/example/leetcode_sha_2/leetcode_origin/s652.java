package com.example.leetcode_sha_2.leetcode_origin;

import com.example.leetcode_sha_2.class_sha.TreeNode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class s652 {

    public static void main(String[] args) {

    }

//    给定一棵二叉树，返回所有重复的子树。对于同一类的重复子树，你只需要返回其中任意一棵的根结点即可。
//
//    两棵树重复是指它们具有相同的结构以及相同的结点值。

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        res = new LinkedList<>();
        m = new HashMap<>();
        traverse(root);
        return res;

    }
    public List<TreeNode> res;
    public HashMap<String, Integer> m;
    public String traverse(TreeNode root){
        if(root==null){
            return "#";
        }
        String left = traverse(root.left);
        String right = traverse(root.right);

        String ss = left + "," + right + "," + root.val;
        int fre = m.getOrDefault(ss, 0);
        if(fre==1){
            res.add(root);
        }
        m.put(ss, fre+1);

        return ss;

    }

}
