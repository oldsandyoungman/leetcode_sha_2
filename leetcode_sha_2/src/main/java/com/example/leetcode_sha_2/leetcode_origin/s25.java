package com.example.leetcode_sha_2.leetcode_origin;

import com.example.leetcode_sha_2.class_sha.ListNode;

public class s25 {

    public static void main(String[] args) {

    }

//    给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
//
//    k 是一个正整数，它的值小于或等于链表的长度。
//
//    如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
//
//    进阶：
//
//    你可以设计一个只使用常数额外空间的算法来解决此问题吗？
//    你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
//
//    来源：力扣（LeetCode）
//    链接：https://leetcode-cn.com/problems/reverse-nodes-in-k-group
//    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode suc = head;
        for(int i=0; i<k; i++){
            if(suc==null){
                return head;
            }
            suc = suc.next;
        }

        ListNode newhead = reverseBetween(head, suc);
        head.next = reverseKGroup(suc, k);
        return newhead;

    }
    // 翻转[a,b)之间的链表，其中a.next=null，返回新的链表头
    public static ListNode reverseBetween(ListNode a, ListNode b) {
        ListNode pre = null;
        ListNode cur = a;
        ListNode nxt = a;

        while(cur!=b){
            nxt = nxt.next;
            cur.next = pre;
            pre = cur;
            cur = nxt;
        }

        return pre;

    }

}
