package com.example.leetcode_sha_2.jian_zhi_offer;

import com.example.leetcode_sha_2.class_sha.ListNode;

public class s18 {

    public static void main(String[] args) {

    }

//    给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点。
//
//    返回删除后的链表的头节点。
//
//    注意：此题对比原题有改动

    public static ListNode deleteNode(ListNode head, int val) {
        ListNode cur = head;
        ListNode dum = new ListNode(0);
        ListNode pre = dum;
        pre.next = cur;

        while(cur.val != val){
            cur = cur.next;
            pre = pre.next;
        }

        pre.next = cur.next;

        return dum.next;

    }


}
