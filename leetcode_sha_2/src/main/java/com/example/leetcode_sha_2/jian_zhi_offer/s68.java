package com.example.leetcode_sha_2.jian_zhi_offer;

import com.example.leetcode_sha_2.class_sha.TreeNode;

public class s68 {

    public static void main(String[] args) {
        TreeNode a = new TreeNode(6);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(8);
        TreeNode d = new TreeNode(0);
        TreeNode e = new TreeNode(4);
        TreeNode f = new TreeNode(7);
        TreeNode g = new TreeNode(9);
        TreeNode h = new TreeNode(3);
        TreeNode i = new TreeNode(5);

        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        c.left = f;
        c.right = g;
        e.left = h;
        e.right = i;

        System.out.println(lowestCommonAncestor(a, b, c).val);


    }

//    给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
//
//    百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
//
//    例如，给定如下二叉搜索树:  root = [6,2,8,0,4,7,9,null,null,3,5]
//
//
//
//    来源：力扣（LeetCode）
//    链接：https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-zui-jin-gong-gong-zu-xian-lcof
//    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。


    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        int a = p.val;
        int b = q.val;
        int max = Math.max(a, b);
        int min = Math.min(a, b);

        return traverse(root, min, max);

    }
    public static TreeNode traverse(TreeNode root, int min, int max){
        if(root==null){
            return null;
        }
        int cur = root.val;
        if(cur>max){
            return traverse(root.left, min, max);
        }else if(cur<min){
            return traverse(root.right, min, max);
        }else{
            return root;
        }
    }

}
