package com.example.leetcode_sha_2.jian_zhi_offer;

import com.example.leetcode_sha_2.class_sha.ListNode;

public class s52 {

    public static void main(String[] args) {

    }

//    输入两个链表，找出它们的第一个公共节点。

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode l1 = headA;
        ListNode l2 = headB;

        while(l1!=null && l2!=null){
            l1 = l1.next;
            l2 = l2.next;
        }

        if(l1==null){
            l1 = headB;
        }else{
            l2 = headA;
        }

        while(l1!=null && l2!=null){
            l1 = l1.next;
            l2 = l2.next;
        }

        if(l1==null){
            l1 = headB;
        }else{
            l2 = headA;
        }


        while(l1!=null && l2!=null){
            if(l1==l2){
                return l1;
            }
            l1 = l1.next;
            l2 = l2.next;
        }

        return null;


    }

}
