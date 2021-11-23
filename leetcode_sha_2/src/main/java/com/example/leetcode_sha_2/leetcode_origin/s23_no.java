package com.example.leetcode_sha_2.leetcode_origin;

import com.example.leetcode_sha_2.class_sha.ListNode;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class s23_no {

    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(4);
        ListNode e = new ListNode(5);
        ListNode f = new ListNode(6);
        ListNode g = new ListNode(7);
        ListNode h = new ListNode(8);
        ListNode i = new ListNode(9);

        a.next = d;
        d.next = g;

        b.next = e;
        e.next = h;

        c.next = f;
        f.next = i;

        ListNode[] s = new ListNode[]{a,b,c};
        ListNode[] s1 = new ListNode[]{null};


//        System.out.println(mergeKLists(s));
        System.out.println(mergeKLists(s1));

    }

//    给你一个链表数组，每个链表都已经按升序排列。
//
//    请你将所有链表合并到一个升序链表中，返回合并后的链表。

    public static ListNode mergeKLists(ListNode[] lists) {

        if (lists.length==0){
            return null;
        }

        ListNode dum = new ListNode(0);

        PriorityQueue<ListNode> pq = new PriorityQueue<>(
                (o1, o2) ->
                {
                    return Integer.compare(o1.val, o2.val);
                }
        );

        for (ListNode list : lists) {
            if (list != null){
                pq.add(list);
            }
        }

        ListNode cur = dum;

        while (!pq.isEmpty()){
            ListNode tmp = pq.poll();
            cur.next = tmp;
            if (tmp.next != null){
                pq.add(tmp.next);
            }
            cur = cur.next;
        }

        return dum.next;

    }

}
