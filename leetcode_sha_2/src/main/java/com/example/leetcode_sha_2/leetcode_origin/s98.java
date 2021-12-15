package com.example.leetcode_sha_2.leetcode_origin;

import com.example.leetcode_sha_2.class_sha.TreeNode;

public class s98 {

    public static void main(String[] args) {

    }

//    给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。
//
//    有效 二叉搜索树定义如下：
//
//    节点的左子树只包含 小于 当前节点的数。
//    节点的右子树只包含 大于 当前节点的数。
//    所有左子树和右子树自身必须也是二叉搜索树。
//
//    来源：力扣（LeetCode）
//    链接：https://leetcode-cn.com/problems/validate-binary-search-tree
//    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。


    public boolean isValidBST(TreeNode root) {
        return traverse(root, null, null);
    }
    public boolean traverse(TreeNode root, Integer min, Integer max){
        if(root==null){
            return true;
        }

        if(min!=null){
            if(min>=root.val){
                return false;
            }
        }
        if(max!=null){
            if(max<=root.val){
                return false;
            }
        }

        return traverse(root.left, min, root.val) && traverse(root.right, root.val, max);

    }

}
