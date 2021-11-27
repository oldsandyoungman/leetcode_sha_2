package com.example.leetcode_sha_2.jian_zhi_offer;

import com.example.leetcode_sha_2.class_sha.TreeNode;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.List;

public class s32_3 {

    public static void main(String[] args) {

    }

//    请实现一个函数按照之字形顺序打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右到左的顺序打印，第三行再按照从左到右的顺序打印，其他行以此类推。

    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root==null){
            return new LinkedList<>();
        }
        ArrayDeque<TreeNode> q = new ArrayDeque<>();
        List<List<Integer>> res = new LinkedList<>();
        q.addLast(root);
        boolean flag_dir = true;

        while(!q.isEmpty()){
            int n = q.size();
            LinkedList<Integer> tmp = new LinkedList<>();
            for(int i=0; i<n; i++){
                TreeNode cur = q.removeFirst();
                if(flag_dir){
                    tmp.addLast(cur.val);
                }else{
                    tmp.addFirst(cur.val);
                }
                if(cur.left!=null){
                    q.addLast(cur.left);
                }
                if(cur.right!=null){
                    q.addLast(cur.right);
                }
            }
            res.add(tmp); // 如果是新建一个变量再赋值混进去，时间会特别长
            flag_dir = !flag_dir;
        }
        return res;
    }

}
