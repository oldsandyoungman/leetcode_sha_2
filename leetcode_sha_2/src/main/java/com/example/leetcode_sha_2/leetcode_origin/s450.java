package com.example.leetcode_sha_2.leetcode_origin;

import com.example.leetcode_sha_2.class_sha.TreeNode;

public class s450 {

    public static void main(String[] args) {

    }

//    给定一个二叉搜索树的根节点 root 和一个值 key，删除二叉搜索树中的 key 对应的节点，并保证二叉搜索树的性质不变。返回二叉搜索树（有可能被更新）的根节点的引用。
//
//    一般来说，删除节点可分为两个步骤：
//
//    首先找到需要删除的节点；
//    如果找到了，删除它。
//
//    来源：力扣（LeetCode）
//    链接：https://leetcode-cn.com/problems/delete-node-in-a-bst
//    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。



    public TreeNode deleteNode(TreeNode root, int key) {
        if(root==null){
            return null;
        }

        if(root.val>key){
            root.left  = deleteNode(root.left, key);
            return root;
        }else if(root.val<key){
            root.right = deleteNode(root.right, key);
            return root;
        }else{

            if(root.left==null && root.right==null){
                return null;
            }
            if(root.left!=null && root.right!=null){
                TreeNode r_min = getRightMin(root.right);
                root.right = deleteNode(root.right, r_min.val);
                r_min.left = root.left;
                r_min.right = root.right;
                return r_min;

                //这个简单写法是错的
                // TreeNode r_min = getRightMin(root.right);
                // r_min.left = root.left;
                // r_min.right = deleteNode(root.right, r_min.val);
                // return r_min;

            }
            if(root.left!=null){
                return root.left;
            }
            return root.right;

        }


    }
    public TreeNode getRightMin(TreeNode root){
        TreeNode min = root;
        while(min.left!=null){
            min = min.left;
        }
        return min;
    }

}
