package com.example.leetcode_sha_2.leetcode_origin;

import java.util.HashMap;

import com.example.leetcode_sha_2.class_sha.TreeNode;

public class s337 {

    public static void main(String[] args) {
        TreeNode a = new TreeNode(4);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(3);
        TreeNode d = new TreeNode(3);
        TreeNode e = new TreeNode(1);

        a.left = b;
//        a.right = c;
        b.left = d;
        b.right = e;

        System.out.println(rob(a));

    }

//    在上次打劫完一条街道之后和一圈房屋后，小偷又发现了一个新的可行窃的地区。这个地区只有一个入口，我们称之为“根”。 除了“根”之外，每栋房子有且只有一个“父“房子与之相连。一番侦察之后，聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。 如果两个直接相连的房子在同一天晚上被打劫，房屋将自动报警。
//
//    计算在不触动警报的情况下，小偷一晚能够盗取的最高金额。
//
//    来源：力扣（LeetCode）
//    链接：https://leetcode-cn.com/problems/house-robber-iii
//    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

    public static HashMap<TreeNode, Integer> m = new HashMap<>();
    public static int rob(TreeNode root) {
        if(root==null){
            return 0;
        }
        if(m.containsKey(root)){
            return m.get(root);
        }
        int res_l = root.left==null?0:rob(root.left.left)+rob(root.left.right);
        int res_r = root.right==null?0:rob(root.right.left)+rob(root.right.right);
        int res1 = root.val + res_l + res_r;

        int res2 = rob(root.left) + rob(root.right);

        int tmp = Math.max(res1, res2);
        m.put(root, tmp);
        return tmp;

    }


    //最快方法
    public int rob2(TreeNode root) {
        int[] res = traverse(root);
        return Math.max(res[0], res[1]);
    }
    // int[0]：当前节点偷
    // int[1]：当前节点不偷
    public int[] traverse(TreeNode root){
        if(root==null){
            return new int[]{0, 0};
        }
        int[] res_l = traverse(root.left);
        int[] res_r = traverse(root.right);

        int res1 = root.val+res_l[1]+res_r[1];
        int res2 = Math.max(res_l[0], res_l[1]) + Math.max(res_r[0], res_r[1]);

        return new int[]{res1, res2};
    }


}
