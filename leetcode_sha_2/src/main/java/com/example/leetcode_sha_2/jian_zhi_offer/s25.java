package com.example.leetcode_sha_2.jian_zhi_offer;

import com.example.leetcode_sha_2.class_sha.ListNode;

public class s25 {

    public static void main(String[] args) {

    }

//    输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dum = new ListNode(0);
        ListNode cur = dum;
        ListNode cur1 = l1;
        ListNode cur2 = l2;
        while(cur1!=null || cur2!=null){
            if(cur1==null){
                cur.next = cur2;
                cur = cur.next;
                cur2 = cur2.next;
                continue;
            }
            if(cur2==null){
                cur.next = cur1;
                cur = cur.next;
                cur1 = cur1.next;
                continue;
            }
            if(cur1.val>cur2.val){
                cur.next = cur2;
                cur = cur.next;
                cur2 = cur2.next;
            }else{
                cur.next = cur1;
                cur = cur.next;
                cur1 = cur1.next;
            }
        }
        return dum.next;
    }

}
