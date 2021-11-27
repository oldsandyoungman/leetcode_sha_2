package com.example.leetcode_sha_2.jian_zhi_offer;

import com.example.leetcode_sha_2.class_sha.TreeNode;

import java.util.ArrayDeque;

public class s32 {

    public static void main(String[] args) {

    }

//    从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印。

    public int[] levelOrder(TreeNode root) {
        if(root==null){
            return new int[]{};
        }
        ArrayDeque<TreeNode> q = new ArrayDeque<>();
        ArrayDeque<Integer> res = new ArrayDeque<>();
        q.addLast(root);

        while(!q.isEmpty()){
            int n = q.size();
            for(int i=0; i<n; i++){
                TreeNode cur = q.removeFirst();
                res.addLast(cur.val);
                if(cur.left!=null){
                    q.addLast(cur.left);
                }
                if(cur.right!=null){
                    q.addLast(cur.right);
                }
            }
        }

        int n_res = res.size();
        int[] result = new int[n_res];
        for(int i=0; i<n_res; i++){
            result[i] = res.removeFirst();
        }

        return result;

    }

}
