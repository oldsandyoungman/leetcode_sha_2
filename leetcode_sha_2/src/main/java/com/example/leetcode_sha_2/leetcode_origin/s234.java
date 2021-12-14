package com.example.leetcode_sha_2.leetcode_origin;

import com.example.leetcode_sha_2.class_sha.ListNode;

public class s234 {

    public static void main(String[] args) {

    }

//    给你一个单链表的头节点 head ，请你判断该链表是否为回文链表。如果是，返回 true ；否则，返回 false 。

    public boolean isPalindrome(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }

        if(fast!=null){
            slow = slow.next;
        }

        ListNode newhead = reverse(slow);

        while(newhead!=null){
            if(newhead.val!=head.val){
                return false;
            }
            newhead = newhead.next;
            head = head.next;
        }

        return true;

    }

    public ListNode reverse(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        ListNode nxt = head;

        while(cur!=null){
            nxt = nxt.next;
            cur.next = pre;
            pre = cur;
            cur =nxt;
        }

        return pre;


    }

}
