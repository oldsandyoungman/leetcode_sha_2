package com.example.leetcode_sha_2.leetcode_origin;

import com.example.leetcode_sha_2.class_sha.ListNode;

public class s160_no {

    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(4);
        ListNode e = new ListNode(5);

        a.next = b;
        b.next = c;
//        c.next = d;
        d.next = e;

        System.out.println(getIntersectionNode(a, d));

    }

//    给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。如果两个链表不存在相交节点，返回 null 。

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode cur1 = headA;
        ListNode cur2 = headB;

        while (cur1!=cur2){

            if (cur1==null){
                cur1 = headB;
            }else {
                cur1 = cur1.next;
            }

            if (cur2==null){
                cur2 = headA;
            }else {
                cur2 = cur2.next;
            }

        }

        return cur1;

    }

}
