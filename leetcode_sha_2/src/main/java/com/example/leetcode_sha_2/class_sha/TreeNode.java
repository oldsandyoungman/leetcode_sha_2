package com.example.leetcode_sha_2.class_sha;

import java.util.ArrayDeque;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode() {}
    public TreeNode(int val) { this.val = val; }
    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
//    public TreeNode(Integer[] a, int start){
//        this.val = a[start];
//        if(a[start+1]==null){
//            this.left = null;
//        }else {
//            this.left = new TreeNode(a, start+1);
//        }
//        if(a[start+1]==null){
//            this.left = null;
//        }else {
//            this.left = new TreeNode(a, start+1);
//        }
//
//
//
//    }

    public static TreeNode create_by_matrix(Integer[] a){
        int mm = a.length;
        if(mm==0){
            return null;
        }
        int index = 1;
        ArrayDeque<TreeNode> q = new ArrayDeque<>();
        TreeNode root = new TreeNode(a[0]);
        q.addLast(root);
        while (!q.isEmpty()) {

            int n = q.size();

            for(int i=0; i<n; i++){
                TreeNode cur = q.removeFirst();
                if(index<mm && a[index]!=null){
                    cur.left = new TreeNode(a[index]);
                    q.addLast(cur.left);
                }
                index++;
                if(index<mm && a[index]!=null){
                    cur.right = new TreeNode(a[index]);
                    q.addLast(cur.right);
                }
                index++;
            }

        }

        return root;

    }

}
