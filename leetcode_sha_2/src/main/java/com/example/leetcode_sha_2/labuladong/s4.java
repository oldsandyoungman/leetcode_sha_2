package com.example.leetcode_sha_2.labuladong;

import com.example.leetcode_sha_2.class_sha.ListNode;

import java.util.Random;

public class s4 {

    public static void main(String[] args) {

    }

//    水塘抽样法，取1个和取前k个
//    https://labuladong.gitee.io/algo/4/30/124/


    /* 返回链表中一个随机节点的值 */
    public static int getRandom(ListNode head) {
        Random r = new Random();
        int res = -1;
        int count = 1;
        ListNode p = head;
        while(p!=null){
            int tmp = r.nextInt(count);
            if (tmp==0) {
                res = p.val;
            }
            count++;
            p = p.next;
        }
        return res;
    }

    /* 返回链表中 k 个随机节点的值 */
    public static int[] getRandom(ListNode head, int k) {
        Random r = new Random();
        int[] res = new int[k];
        ListNode p = head;
        for (int i=0; i<k; i++){
            res[i] = p.val;
            p = p.next;
        }

        int i = k;
        while (p!=null) {
            i++;
            int tmp = r.nextInt(i);
            if(tmp<k){
                res[tmp] = p.val;
            }
            p = p.next;
        }

        return res;

    }

}
