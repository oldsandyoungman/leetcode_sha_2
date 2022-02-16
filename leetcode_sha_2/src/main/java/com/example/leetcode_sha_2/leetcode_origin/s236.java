package com.example.leetcode_sha_2.leetcode_origin;

import com.example.leetcode_sha_2.class_sha.TreeNode;

public class s236 {

    public static void main(String[] args) {

    }

//    给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
//
//    百度百科中最近公共祖先的定义为：“对于有根树 T 的两个节点 p、q，最近公共祖先表示为一个节点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
//
//    来源：力扣（LeetCode）
//    链接：https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree
//    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。


    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return dfs(root, p, q);
    }

    public static TreeNode dfs(TreeNode root, TreeNode p, TreeNode q){
        if(root==null){
            return null;
        }
        if(root==p || root==q){
            return root;
        }
        // 好像通过后序遍历来做逻辑判断不大行
        // TreeNode left = dfs(root.left);
        // TreeNode right = dfs(root.right);

        // if((left==p&&right==q) || (left==q&&right==p)){
        //     return root;
        // }

        TreeNode left = dfs(root.left, p, q);
        TreeNode right = dfs(root.right, p, q);
        if(left!=null && right!=null){
            return root;
        }
        if(right!=null){
            return right;
        }
        if(left!=null){
            return left;
        }
        return null;

    }


}
