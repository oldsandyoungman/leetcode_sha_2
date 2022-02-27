很多题目还是一错再错，决定做个复盘，记录下自己哪里写错了



[TOC]

#### [92. 反转链表 II](https://leetcode-cn.com/problems/reverse-linked-list-ii/)

> 给你单链表的头指针 head 和两个整数 left 和 right ，其中 left <= right 。请你反转从位置 left 到位置 right 的链表节点，返回 反转后的链表 。
>
> 
>
> **提示：**
> 
> - 链表中节点数目为 `n`
>- `1 <= n <= 500`
> - `-500 <= Node.val <= 500`
>- `1 <= left <= right <= n`



##### 思路

反转的三部曲结合

1. 反转整条链表
2. 反转链表的前k个节点
3. 反转链表的第 i 到第 j 个节点



##### 注意点

`reverseBetween(head.next, left, right)` 调用 `reverseBetween(head.next, left-1, right-1)` 的时候，如果单独写`reverseBetween(head.next, left-1, right-1)`，多少觉得怪怪的，那是因为没有加前面的 `head.next =`，例如：

> 12345，反转第2到4个节点
>
> 正确结果应该是14325
>
> 不写 `head.next =`就会得到 125



##### 代码

```java
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(left>1){
            head.next = reverseBetween(head.next, left-1, right-1);
            return head;
        }else{
            return reverseK(head, right);
        }
    }

    ListNode suc = null;

    public ListNode reverseK(ListNode head, int k){
        if(k==1){
            suc = head.next;
            return head;
        }
        ListNode new_head = reverseK(head.next, k-1);
        head.next.next = head;
        head.next = suc;
        return new_head;
    }

}
```



