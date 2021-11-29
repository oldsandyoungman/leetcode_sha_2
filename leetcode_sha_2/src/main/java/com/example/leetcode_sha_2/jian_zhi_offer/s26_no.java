package com.example.leetcode_sha_2.jian_zhi_offer;

import com.example.leetcode_sha_2.class_sha.TreeNode;

public class s26_no {

    public static void main(String[] args) {
        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(3);
        TreeNode d = new TreeNode(4);
        TreeNode e = new TreeNode(3);

        a.left = b;
        a.right = c;
        b.left = d;

        System.out.println(isSubStructure(a, e));
        System.out.println(isSubStructure2(a, e));
        System.out.println(1e9+7 - 1e9);

    }

//    输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构)
//
//    B是A的子结构， 即 A中有出现和B相同的结构和节点值。

    public static boolean isSubStructure(TreeNode A, TreeNode B) {
        return (A != null && B != null) && (recur(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B));
    }
    public static boolean recur(TreeNode A, TreeNode B) {
        if(B == null) return true;
        if(A == null || A.val != B.val) return false;
        return recur(A.left, B.left) && recur(A.right, B.right);
    }

    public static boolean isSubStructure2(TreeNode A, TreeNode B) {
        if(A==null || B==null){
            return false;
        }
        return traverse(A, B) && isSubStructure2(A.left, B) && isSubStructure2(A.right, B);
    }
    //A和B是否完全一致
    public static boolean traverse(TreeNode A, TreeNode B){
        if(B==null){
            return true;
        }
        if(A==null || A.val!=B.val){
            return false;
        }
        return traverse(A.left, B.left) && traverse(A.right, B.right);
    }

}
