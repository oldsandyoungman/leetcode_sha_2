package com.example.leetcode_sha_2.jian_zhi_offer;

import com.example.leetcode_sha_2.class_sha.TreeNode;
import java.util.LinkedList;
import java.util.List;

public class s34 {

    public static void main(String[] args) {

    }

//    给你二叉树的根节点 root 和一个整数目标和 targetSum ，找出所有 从根节点到叶子节点 路径总和等于给定目标和的路径。
//
//    叶子节点 是指没有子节点的节点。
//
//    来源：力扣（LeetCode）
//    链接：https://leetcode-cn.com/problems/er-cha-shu-zhong-he-wei-mou-yi-zhi-de-lu-jing-lcof
//    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

    public List<List<Integer>> pathSum(TreeNode root, int target) {
        res = new LinkedList<>();
        cur = new LinkedList<>();
        backtract(root, target);
        return res;
    }
    List<List<Integer>> res;
    LinkedList<Integer> cur;
    public void backtract(TreeNode root, int target){
        if(root==null){
            return;
        }

        cur.add(root.val);
        target -= root.val;
        if(target==0 && root.left==null && root.right==null){
            res.add(new LinkedList<>(cur));
        }

        backtract(root.left, target);
        backtract(root.right, target);
        cur.removeLast();

    }

}
