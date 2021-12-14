package com.example.leetcode_sha_2.leetcode_origin;

import com.example.leetcode_sha_2.class_sha.TreeNode;

public class s114 {

    public static void main(String[] args) {

    }


//    给你二叉树的根结点 root ，请你将它展开为一个单链表：
//
//    展开后的单链表应该同样使用 TreeNode ，其中 right 子指针指向链表中下一个结点，而左子指针始终为 null 。
//    展开后的单链表应该与二叉树 先序遍历 顺序相同。
//             
//
//    来源：力扣（LeetCode）
//    链接：https://leetcode-cn.com/problems/flatten-binary-tree-to-linked-list
//    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。


    public void flatten(TreeNode root) {
        if(root==null){
            return;
        }

        TreeNode left = root.left;
        TreeNode right = root.right;

        flatten(left);
        flatten(right);

        root.left = null;
        root.right = left;

        TreeNode left_end = root;
        while(left_end.right!=null){
            left_end = left_end.right;
        }
        left_end.right = right;

    }

}
