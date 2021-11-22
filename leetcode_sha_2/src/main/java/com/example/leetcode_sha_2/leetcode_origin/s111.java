package com.example.leetcode_sha_2.leetcode_origin;

import com.example.leetcode_sha_2.class_sha.TreeNode;

import java.util.ArrayDeque;

public class s111 {

    public static void main(String[] args) {
        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(3);
        TreeNode d = new TreeNode(4);
        TreeNode e = new TreeNode(5);
        a.left = b;
        a.right = c;
        c.left = d;
        c.right = e;

//        a.right = b;
//        b.right = c;
//        c.right = d;
//        d.right = e;

        System.out.println(minDepth(a));

    }

//    给定一个二叉树，找出其最小深度。
//
//    最小深度是从根节点到最近叶子节点的最短路径上的节点数量。

    public static int minDepth(TreeNode root) {
        if (root==null){
            return 0;
        }

        ArrayDeque<TreeNode> q = new ArrayDeque<>();
        q.addLast(root);

        int min_depth = 1;

        while (!q.isEmpty()){

            int n = q.size();

            for (int i = 0; i < n; i++) {

                TreeNode cur = q.removeFirst();

                if (cur.left == null && cur.right == null){
                    return min_depth;
                }else {
                    if (cur.left != null){
                        q.addLast(cur.left);
                    }
                    if (cur.right != null){
                        q.addLast(cur.right);
                    }
                }

            }

            min_depth++;

        }

        return min_depth;

    }


}
