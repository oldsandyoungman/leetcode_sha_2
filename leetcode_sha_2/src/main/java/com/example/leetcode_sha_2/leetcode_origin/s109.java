package com.example.leetcode_sha_2.leetcode_origin;

import com.example.leetcode_sha_2.class_sha.ListNode;
import com.example.leetcode_sha_2.class_sha.TreeNode;

public class s109 {

    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(4);
        ListNode e = new ListNode(5);

        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;

        System.out.println(sortedListToBST(a));

    }

//    给定一个单链表，其中的元素按升序排序，将其转换为高度平衡的二叉搜索树。
//
//    本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
//
//    来源：力扣（LeetCode）
//    链接：https://leetcode-cn.com/problems/convert-sorted-list-to-binary-search-tree
//    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

    public static TreeNode sortedListToBST(ListNode head) {
        int len = 0;
        for (ListNode p = head; p != null; p = p.next) {
            len++;
        }

        cur = head;
        return inorderBuild(0, len - 1);
    }

    public static ListNode cur;

    public static TreeNode inorderBuild(int left, int right) {
        if (left > right) {
            return null;
        }
        int mid = (left + right) / 2;
        // 构造左子树
        TreeNode leftTree = inorderBuild(left, mid - 1);
        // 构造根节点
        TreeNode root = new TreeNode(cur.val);
        cur = cur.next;
        // 构造右子树
        TreeNode rightTree = inorderBuild(mid + 1, right);
        // 将左右子树接到根节点上
        root.left = leftTree;
        root.right = rightTree;
        return root;
    }

}
