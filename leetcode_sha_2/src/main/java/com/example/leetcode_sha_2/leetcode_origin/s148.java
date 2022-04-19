package com.example.leetcode_sha_2.leetcode_origin;

import com.example.leetcode_sha_2.class_sha.ListNode;

public class s148 {

    public static void main(String[] args) {
//        int[] nums = {4,2,1,3};
        int[] nums = {-1,5,3,4,0};
        ListNode head = ListNode.create_by_nums(nums);
        System.out.println(sortList(head));
    }

//    给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。

    public static ListNode sortList(ListNode head) {
        if(head==null || head.next==null){
            return head;
        }

        ListNode slow = head;
        ListNode fast = head.next;

        while(fast!=null && fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode tmp = slow.next;

        slow.next = null;

        ListNode head1 = sortList(head);
        ListNode head2 = sortList(tmp);

        return merge_sha(head1, head2);

    }

    public static ListNode merge_sha(ListNode head1, ListNode head2){

        ListNode dum = new ListNode(0);
        ListNode cur = dum;
        ListNode l1 = head1;
        ListNode l2 = head2;

        while(l1!=null && l2!=null){
            if(l1.val<l2.val){
                cur.next = l1;
                cur = cur.next;
                l1 = l1.next;
            }else{
                cur.next = l2;
                cur = cur.next;
                l2 = l2.next;
            }
        }

        if(l1==null){
            cur.next = l2;
        }else{
            cur.next = l1;
        }

        return dum.next;

    }

}
