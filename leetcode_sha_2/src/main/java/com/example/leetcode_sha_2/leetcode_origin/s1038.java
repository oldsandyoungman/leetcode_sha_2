package com.example.leetcode_sha_2.leetcode_origin;

import com.example.leetcode_sha_2.class_sha.TreeNode;

public class s1038 {

    public static void main(String[] args) {

    }

//    给定一个二叉搜索树，请将它的每个节点的值替换成树中大于或者等于该节点值的所有节点值之和。
//
//    提醒一下，二叉搜索树满足下列约束条件：
//
//    节点的左子树仅包含键 小于 节点键的节点。
//    节点的右子树仅包含键 大于 节点键的节点。
//    左右子树也必须是二叉搜索树。
//
//    来源：力扣（LeetCode）
//    链接：https://leetcode-cn.com/problems/binary-search-tree-to-greater-sum-tree
//    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

    public TreeNode bstToGst(TreeNode root) {
        traverse(root);
        return root;
    }
    public int sum = 0;
    public void traverse(TreeNode root){
        if(root==null){
            return;
        }
        traverse(root.right);

        sum += root.val;
        root.val = sum;

        traverse(root.left);

    }

}
