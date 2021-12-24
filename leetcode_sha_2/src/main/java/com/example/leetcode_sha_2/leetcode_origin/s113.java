package com.example.leetcode_sha_2.leetcode_origin;

import com.example.leetcode_sha_2.class_sha.TreeNode;

import java.util.LinkedList;
import java.util.List;

public class s113 {

    public static void main(String[] args) {

        Integer[] a = {5,4,8,11,null,13,4,7,2,null,null,5,1};
        TreeNode aa = TreeNode.create_by_matrix(a);
        System.out.println(pathSum(aa, 22));
    }

//    给你二叉树的根节点 root 和一个整数目标和 targetSum ，找出所有 从根节点到叶子节点 路径总和等于给定目标和的路径。
//
//    叶子节点 是指没有子节点的节点。
//
//    来源：力扣（LeetCode）
//    链接：https://leetcode-cn.com/problems/path-sum-ii
//    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。


    public static List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        sum = 0;
        res = new LinkedList<>();
        tmp = new LinkedList<>();
        traverse(root, targetSum);
        return res;
    }

    static int sum;
    static List<List<Integer>> res;
    static LinkedList<Integer> tmp;

    public static void traverse(TreeNode root, int targetSum){
        if(root==null){
            return;
        }
        if(root.left==null && root.right==null){
            tmp.addLast(root.val);
            sum += root.val;
            if(sum==targetSum){
                res.add(new LinkedList<>(tmp));
            }
            tmp.removeLast();
            sum -= root.val;
            return;
        }

        tmp.addLast(root.val);
        sum += root.val;

        if(root.left!=null){
            traverse(root.left, targetSum);
        }
        if(root.right!=null){
            traverse(root.right, targetSum);
        }

        tmp.removeLast();
        sum -= root.val;


    }

}



