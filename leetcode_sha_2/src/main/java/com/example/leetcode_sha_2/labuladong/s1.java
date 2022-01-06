package com.example.leetcode_sha_2.labuladong;

import com.example.leetcode_sha_2.class_sha.TreeNode;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.List;

public class s1 {

    public static void main(String[] args) {
        TreeNode root = TreeNode.create_by_matrix(new Integer[]{1,2,3});
        System.out.println(traverse(root));
    }

//    递归的迭代写法
//    https://labuladong.gitee.io/algo/2/18/33/


//    public static ArrayDeque<TreeNode> q = new ArrayDeque<>();
//
//    public static void pushLeftBranch(TreeNode p){
//        while(p!=null){
//
//            // 前序遍历
//
//            q.addLast(p);
//            p = p.left;
//        }
//    }
//
//    public void traverse(TreeNode root) {
//
//        TreeNode visited = new TreeNode(-1);
//
//        pushLeftBranch(root);
//
//        while(!q.isEmpty()){
//
//            TreeNode top = q.getLast();
//
//            if ((top.left==null||top.left==visited) && top.right!=visited) {
//
//                // 中序遍历
//
//                q.addLast(top.right);
//
//            }
//
//            if (top.right==null || top.right==visited) {
//
//                // 后序遍历
//
//                visited = q.removeLast();
//
//            }
//
//
//        }
//
//
//    }



    public static ArrayDeque<TreeNode> q = new ArrayDeque<>();

    public static void pushLeftBranch(TreeNode p){
        while(p!=null){
            // 前序
            q.addLast(p);
            p = p.left;
        }
    }

    public static List<Integer> traverse(TreeNode root){

        List<Integer> res = new LinkedList<>();

        TreeNode visited = new TreeNode(-1);

        pushLeftBranch(root);

        while (!q.isEmpty()) {

            TreeNode p = q.getLast();

            if ((p.left==null || p.left==visited) && p.right!=visited) {
                // 中序
                pushLeftBranch(p.right);
            }

            if (p.right==null || p.right==visited) {
                //后续
                res.add(p.val);
                visited = q.removeLast();
            }

        }

        return res;

    }



}
