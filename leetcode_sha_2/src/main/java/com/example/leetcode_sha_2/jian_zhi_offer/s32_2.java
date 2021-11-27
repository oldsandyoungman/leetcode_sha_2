package com.example.leetcode_sha_2.jian_zhi_offer;

import com.example.leetcode_sha_2.class_sha.TreeNode;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.List;

public class s32_2 {

    public static void main(String[] args) {

    }

//    从上到下按层打印二叉树，同一层的节点按从左到右的顺序打印，每一层打印到一行。

    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root==null){
            return new LinkedList<>();
        }
        ArrayDeque<TreeNode> q = new ArrayDeque<>();
        List<List<Integer>> res = new LinkedList<>();
        q.addLast(root);

        while(!q.isEmpty()){
            int n = q.size();
            List<Integer> tmp = new LinkedList<>();
            for(int i=0; i<n; i++){
                TreeNode cur = q.removeFirst();
                tmp.add(cur.val);
                if(cur.left!=null){
                    q.addLast(cur.left);
                }
                if(cur.right!=null){
                    q.addLast(cur.right);
                }
            }
            res.add(new LinkedList<>(tmp));
        }
        return res;
    }

}
