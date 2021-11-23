package com.example.leetcode_sha_2.jian_zhi_offer;

import com.example.leetcode_sha_2.class_sha.ListNode;

public class s24 {

    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        a.next = b;
        b.next = c;
        System.out.println(reverseList(a));
    }

//    定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。

    public static ListNode reverseList(ListNode head) {
        if (head==null){
            return null;
        }
        ListNode cur = head;
        ListNode nxt;
        ListNode pre = null;
        while (cur!=null){
            nxt = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nxt;
        }
        return pre;
    }



}
