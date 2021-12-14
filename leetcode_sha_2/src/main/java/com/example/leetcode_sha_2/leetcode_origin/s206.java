package com.example.leetcode_sha_2.leetcode_origin;

import com.example.leetcode_sha_2.class_sha.ListNode;

public class s206 {

    public static void main(String[] args) {

    }

//    给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。

    public ListNode reverseList2(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        ListNode nxt = head;

        while(cur!=null){
            nxt = nxt.next;
            cur.next = pre;
            pre = cur;
            cur = nxt;
        }

        return pre;

    }

    public ListNode reverseList(ListNode head) {
        if(head==null || head.next==null){
            return head;
        }
        ListNode last = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return head;
    }

}
