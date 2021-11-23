package com.example.leetcode_sha_2.leetcode_origin;

import com.example.leetcode_sha_2.class_sha.ListNode;

public class s142_no {

    public static void main(String[] args) {

    }

//    给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
//
//    如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，评测系统内部使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。如果 pos 是 -1，则在该链表中没有环。注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。
//
//    不允许修改 链表。
//
//    来源：力扣（LeetCode）
//    链接：https://leetcode-cn.com/problems/linked-list-cycle-ii
//    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

    public static ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        ListNode meet = null;

        while (fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
            if (slow==fast){
                meet = slow;
                break;
            }
        }

        if (meet==null){
            return null;
        }else {
            fast = head;
            while (fast!=slow){
                fast = fast.next;
                slow = slow.next;
            }
        }

        return fast;

    }


}
