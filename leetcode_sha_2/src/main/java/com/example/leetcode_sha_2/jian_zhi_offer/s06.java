package com.example.leetcode_sha_2.jian_zhi_offer;

import com.example.leetcode_sha_2.class_sha.ListNode;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;

public class s06 {

    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        a.next = b;
        b.next = c;
        System.out.println(Arrays.toString(reversePrint(a)));
    }

//    输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。

//    辅助栈
    public static int[] reversePrint2(ListNode head) {
        ArrayDeque<Integer> q = new ArrayDeque<>();
        while (head!=null){
            q.addFirst(head.val);
            head = head.next;
        }
        int n = q.size();
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = q.removeFirst();
        }
        return res;
    }


//    递归树
    public static int[] reversePrint(ListNode head) {
        traverse(head);
        int n = q.size();
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = q.removeLast();
        }
        return res;

    }
    public static ArrayDeque<Integer> q = new ArrayDeque<>();
    public static void traverse(ListNode head){
        if (head==null){
            return;
        }
        q.addLast(head.val);
        traverse(head.next);

    }



}
