package com.example.leetcode_sha_2.leetcode_origin;

import com.example.leetcode_sha_2.class_sha.TreeNode;

public class s1373 {

    public static void main(String[] args) {
        Integer[] a = {1,4,3,2,4,2,5,null,null,null,null,null,null,4,6};
        TreeNode root = TreeNode.create_by_matrix(a);
        System.out.println(maxSumBST(root));

    }

//    给你一棵以 root 为根的 二叉树 ，请你返回 任意 二叉搜索子树的最大键值和。
//
//    二叉搜索树的定义如下：
//
//    任意节点的左子树中的键值都 小于 此节点的键值。
//    任意节点的右子树中的键值都 大于 此节点的键值。
//    任意节点的左子树和右子树都是二叉搜索树。
//
//    来源：力扣（LeetCode）
//    链接：https://leetcode-cn.com/problems/maximum-sum-bst-in-binary-tree
//    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。







    // 全局变量，记录 BST 最大节点之和
    public static int maxSum = 0;

    /* 主函数 */
    public static int maxSumBST(TreeNode root) {
        traverse(root);
        return maxSum;
    }

    // 函数返回 int[]{ isBST, min, max, sum}
    public static int[] traverse(TreeNode root) {

        // base case
        if (root == null) {
            return new int[] {
                    1, Integer.MAX_VALUE, Integer.MIN_VALUE, 0
            };
        }

        // 递归计算左右子树
        int[] left = traverse(root.left);
        int[] right = traverse(root.right);

        /******* 后序遍历位置 *******/
        int[] res = new int[4];
        // 这个 if 在判断以 root 为根的二叉树是不是 BST
        if (left[0] == 1 && right[0] == 1 &&
                root.val > left[2] && root.val < right[1]) {
            // 以 root 为根的二叉树是 BST
            res[0] = 1;
            // 计算以 root 为根的这棵 BST 的最小值
            res[1] = Math.min(left[1], root.val);
            // 计算以 root 为根的这棵 BST 的最大值
            res[2] = Math.max(right[2], root.val);
            // 计算以 root 为根的这棵 BST 所有节点之和
            res[3] = left[3] + right[3] + root.val;
            // 更新全局变量
            maxSum = Math.max(maxSum, res[3]);
        } else {
            // 以 root 为根的二叉树不是 BST
            res[0] = 0;
            // 其他的值都没必要计算了，因为用不到
        }
        /**************************/

        return res;

    }



//    //自己写的版本
//    public static int maxSumBST(TreeNode root) {
//        traverse(root);
//        return res;
//    }
//    public static int res = -40001;
//    public static State111 traverse(TreeNode root){
//        if(root==null){
//            return new State111(true, null, null, 0);
//        }
//
//        State111 l = traverse(root.left);
//        State111 r = traverse(root.right);
//
//        if(l.isBST && r.isBST){
//            if(l.max==null || (l.max!=null && root.val>l.max)){
//                if(r.min==null || (r.min!=null && root.val<r.min)){
//
//                    int cur_sum = l.sum + r.sum + root.val;
//                    res = Math.max(cur_sum, res);
//
//
//
//                    return new State111(true, l.min==null?root.val:Math.min(root.val, l.min), r.max==null?root.val:Math.max(r.max, root.val), cur_sum);
//
//                }
//            }else{
//                return new State111(false, null, null, 0);
//            }
//
//        }else{
//            return new State111(false, null, null, 0);
//        }
//
//        return new State111(false, null, null, 0);
//
//    }

}

class State111{
    boolean isBST;
    Integer min;
    Integer max;
    int sum;
    State111(boolean a, Integer b, Integer c, int d){
        isBST = a;
        min = b;
        max = c;
        sum = d;
    }

}