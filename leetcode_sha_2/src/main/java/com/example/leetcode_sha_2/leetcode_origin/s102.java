package com.example.leetcode_sha_2.leetcode_origin;

import com.example.leetcode_sha_2.class_sha.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class s102 {

    public static void main(String[] args) {
        List<Integer> tmp = new LinkedList<>();
        tmp.add(0,333);
        tmp.add(0,444);
        tmp.add(2,555);
        tmp.remove(1);
        tmp.remove(tmp.size()-1);
        tmp.get(0);

        LinkedList<Integer> b = new LinkedList<>();

    }



    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root==null){
            return null;
        }

        List<List<Integer>> res = new LinkedList<>();

        ArrayDeque<TreeNode> q = new ArrayDeque<>();
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
            res.add(tmp);
        }

        return res;

    }

}
