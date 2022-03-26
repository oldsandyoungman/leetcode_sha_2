package com.example.leetcode_sha_2.class_sha;

import java.util.List;

public class ListNode {
    public int val;
    public ListNode next;
    public ListNode(int x) { val = x; }

    @Override
    public String toString() {
        if (next==null){
            return val+"";
        }else {
            return val +
                    "->" +
                    next;
        }
    }

    public static ListNode create_by_nums(int[] nums){
        if(nums.length==0){
            return null;
        }
        ListNode head = new ListNode(nums[0]);
        ListNode cur = head;

        for (int i = 1; i < nums.length; i++) {
            cur.next = new ListNode(nums[i]);
            cur = cur.next;
        }

        return head;

    }

}