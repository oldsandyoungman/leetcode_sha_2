package com.example.leetcode_sha_2.leetcode_origin;

import com.example.leetcode_sha_2.class_sha.ListNode;

public class s92_no {

    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(4);
        ListNode e = new ListNode(5);

        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;

        System.out.println(reverseBetween(a, 2, 4));

//        System.out.println(reverseN(a, 3));

    }

//    给你单链表的头指针 head 和两个整数 left 和 right ，其中 left <= right 。请你反转从位置 left 到位置 right 的链表节点，返回 反转后的链表 。
//
//    来源：力扣（LeetCode）
//    链接：https://leetcode-cn.com/problems/reverse-linked-list-ii
//    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

    public static ListNode reverseBetween2(ListNode head, int left, int right) {
        ListNode dum = new ListNode(0);
        dum.next = head;
        ListNode l1 = dum;
        for(int i=1; i<left; i++){
            l1 = l1.next;
        }
        ListNode l2 = l1.next;
        ListNode r1 = l1;
        for(int i=left; i<=right; i++){
            r1 = r1.next;
        }
        ListNode r2 = r1.next;

        ListNode pre = r2;
        ListNode cur = l2;
        ListNode nxt = l2;

        while(cur!=r2){
            nxt = nxt.next;
            cur.next = pre;
            pre = cur;
            cur = nxt;
        }

        l1.next = pre;

        return dum.next;

    }

    public static ListNode successor = null;

//    public static ListNode reverseBetween(ListNode head, int left, int right) {
//
//        if(head==null || head.next==null){
//            return head;
//        }
//        if (right==1) {
//            successor = head.next;
//            return  head;
//        }
//        if(left>1){
//            head.next = reverseBetween(head.next, left-1, right-1);
//            return head;
//        }
//
//        ListNode last = reverseBetween(head.next, left, right-1);
//        head.next.next = head;
//        head.next = successor;
//
//        return last;
//
//    }


    public static ListNode reverseBetween(ListNode head, int left, int right) {
        if (left>1) {
            head.next = reverseBetween(head.next, left - 1, right - 1);
            return head;
        }else {
            return reverseN(head, right);
        }


    }

    public static ListNode reverseN(ListNode head, int right) {
        if(right==1){
            successor = head.next;
            return head;
        }else {
            ListNode last = reverseN(head.next, right-1);
            head.next.next = head;
            head.next = successor;
            return last;
        }
    }




}
