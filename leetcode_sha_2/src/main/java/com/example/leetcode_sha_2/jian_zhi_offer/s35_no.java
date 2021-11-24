package com.example.leetcode_sha_2.jian_zhi_offer;

import com.example.leetcode_sha_2.class_sha.Node;

import java.util.HashMap;

public class s35_no {

    public static void main(String[] args) {
        Node a = new Node(7);
        Node b = new Node(13);
        Node c = new Node(11);
        Node d = new Node(10);
        Node e = new Node(1);

        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;

        a.random = null;
        b.random = a;
        c.random = e;
        d.random = c;
        e.random = a;

        Node res = copyRandomList(a);

        System.out.println("over");

    }

//    请实现 copyRandomList 函数，复制一个复杂链表。在复杂链表中，每个节点除了有一个 next 指针指向下一个节点，还有一个 random 指针指向链表中的任意节点或者 null。
//
//    来源：力扣（LeetCode）
//    链接：https://leetcode-cn.com/problems/fu-za-lian-biao-de-fu-zhi-lcof
//    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

//    自己写的方法
    public static Node copyRandomList2(Node head) {
        if (head==null){
            return null;
        }
        Node cur = head;
        Node new_head = new Node(head.val);
        Node new_cur = new_head;

        HashMap<Node, Integer> m = new HashMap<>();
        HashMap<Integer, Node> m_new = new HashMap<>();

        m.put(head, 0);
        m_new.put(0,new_head);

        int num = 1;

        while (cur.next!=null){
            new_cur.next = new Node(cur.next.val);
            m.put(cur.next, num);
            m_new.put(num, new_cur.next);
            cur = cur.next;
            new_cur = new_cur.next;
            num++;
        }

        cur = head;
        new_cur = new_head;
        while (cur!=null){
            new_cur.random = m_new.get(m.get(cur.random));
            cur = cur.next;
            new_cur = new_cur.next;
        }

        return new_head;

    }


//    答案写的方法
    public static Node copyRandomList(Node head) {
        if (head==null){
            return null;
        }

        HashMap<Node, Node> m = new HashMap<>();

        Node dum = new Node(0);
        Node cur = head;
        Node new_cur = dum;
        while (cur!=null){
            new_cur.next = new Node(cur.val);
            m.put(cur, new_cur.next);
            cur = cur.next;
            new_cur = new_cur.next;
        }

        cur = head;
        new_cur = dum.next;
        while (cur!=null){
            new_cur.random = m.get(cur.random);
            cur = cur.next;
            new_cur = new_cur.next;
        }

        return dum.next;





    }

}
