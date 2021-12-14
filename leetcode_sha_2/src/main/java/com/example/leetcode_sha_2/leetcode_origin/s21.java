package com.example.leetcode_sha_2.leetcode_origin;

import com.example.leetcode_sha_2.class_sha.ListNode;

public class s21 {

    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(4);
        ListNode e = new ListNode(5);
        ListNode f = new ListNode(6);

        a.next = c;
        c.next = e;
        b.next = d;
        d.next = f;

//        System.out.println(mergeTwoLists(a,b));
        System.out.println(mergeTwoLists2(a,b));

    }

//    将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode cur1 = l1;
        ListNode cur2 = l2;
        ListNode dum = new ListNode(0);
        ListNode cur = dum;
        while (cur1!=null || cur2!=null) {
            if (cur1==null){
                cur.next = cur2;
                cur = cur2;
                cur2 = cur2.next;
            }else if (cur2==null){
                cur.next = cur1;
                cur = cur1;
                cur1 = cur1.next;
            }else {
                if (cur1.val>cur2.val){
                    cur.next = cur2;
                    cur = cur2;
                    cur2 = cur2.next;
                }else {
                    cur.next = cur1;
                    cur = cur1;
                    cur1 = cur1.next;
                }
            }
        }
        return dum.next;
    }


//    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
//        ListNode cur1 = l1;
//        ListNode cur2 = l2;
//        ListNode dum = new ListNode(0);
//        ListNode cur = dum;
//        while (cur1!=null && cur2!=null) {
//            if (cur1==null){
//                cur.next = cur2;
//                cur = cur2;
//                cur2 = cur2.next;
//            }else if (cur2==null){
//                cur.next = cur1;
//                cur = cur1;
//                cur1 = cur1.next;
//            }else {
//                if (cur1.val>cur2.val){
//                    cur.next = cur2;
//                    cur = cur2;
//                    cur2 = cur2.next;
//                }else {
//                    cur.next = cur1;
//                    cur = cur1;
//                    cur1 = cur1.next;
//                }
//            }
//        }
//        return dum.next;
//    }



    public static ListNode mergeTwoLists2(ListNode list1, ListNode list2) {
        ListNode dum = new ListNode(0);
        ListNode cur = dum;

        while(list1!=null && list2!=null){
            if(list1.val>list2.val){
                cur.next = list2;
                cur = cur.next;
                list2 = list2.next;
            }else{
                cur.next = list1;
                cur = cur.next;
                list1 = list1.next;
            }
        }

        if(list1==null){
            cur.next = list2;
        }else{
            cur.next = list1;
        }

        return dum.next;


    }

}
