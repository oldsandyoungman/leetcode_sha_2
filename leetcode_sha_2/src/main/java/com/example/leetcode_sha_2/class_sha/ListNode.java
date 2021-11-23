package com.example.leetcode_sha_2.class_sha;

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
}