package com.example.leetcode_sha_2.leetcode_origin;

import com.example.leetcode_sha_2.class_sha.ListNode;

import java.util.List;

public class s19 {

    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);

        a.next = b;
        b.next = c;

//        System.out.println(removeNthFromEnd(a, 1));
        System.out.println(removeNthFromEnd(a, 3));

    }

//    给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dum = new ListNode(0);
        dum.next = head;
        ListNode fast = dum;
        for (int i = 0; i < n+1; i++) {
            fast = fast.next;
        }

        ListNode slow = dum;

        while (fast!=null){
            slow = slow.next;
            fast = fast.next;
        }

        slow.next = slow.next.next;


        return dum.next;




    }


}
