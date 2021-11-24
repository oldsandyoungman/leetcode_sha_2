package com.example.leetcode_sha_2.jian_zhi_offer;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class s09_no {

    public static void main(String[] args) {
        CQueue obj = new CQueue();



        System.out.println(obj.deleteHead());
        obj.appendTail(97);
        System.out.println(obj.deleteHead());
        System.out.println(obj.deleteHead());
        System.out.println(obj.deleteHead());
        System.out.println(obj.deleteHead());
        obj.appendTail(15);
        System.out.println(obj.deleteHead());
        obj.appendTail(1);
        obj.appendTail(43);
        System.out.println(obj.deleteHead());
        System.out.println(obj.deleteHead());
        System.out.println(obj.deleteHead());
        obj.appendTail(18);
        System.out.println(obj.deleteHead());
        System.out.println(obj.deleteHead());
        System.out.println(obj.deleteHead());
        System.out.println(obj.deleteHead());
        obj.appendTail(36);
        obj.appendTail(69);
        obj.appendTail(21);
        obj.appendTail(91);
        System.out.println(obj.deleteHead());
        System.out.println(obj.deleteHead());
        obj.appendTail(22);
        obj.appendTail(40);
        System.out.println(obj.deleteHead());
        System.out.println(obj.deleteHead());
        System.out.println(obj.deleteHead());
        obj.appendTail(81);
        obj.appendTail(65);
        System.out.println(obj.deleteHead());
        obj.appendTail(77);
        System.out.println(obj.deleteHead());
        obj.appendTail(63);
        obj.appendTail(96);
        obj.appendTail(5);



//        [[],[],[97],[],[],[],[],[15],[],[1],[43],[],[],[],[18],[],[],[],[],[36],[69],[21],[91],[],[],[22],[40],[],[],[],[81],[65],[],[77],[],[63],[96],[5],[],[],[35],[90],[],[],[],[],[77],[83],[],[],[52],[],[2],[66],[87],[90],[],[2],[],[],[33],[16],[72],[],[],[14],[78],[8],[],[],[],[],[3],[83],[],[],[13],[],[79],[44],[],[],[33],[],[55],[76],[12],[],[91],[24],[49],[47],[],[],[],[85],[],[69],[],[94],[52]]



    }


//    用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead 操作返回 -1 )
//
//    来源：力扣（LeetCode）
//    链接：https://leetcode-cn.com/problems/yong-liang-ge-zhan-shi-xian-dui-lie-lcof
//    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。



}

class CQueue {

    public ArrayDeque<Integer> s1 = new ArrayDeque<>();
    public ArrayDeque<Integer> s2 = new ArrayDeque<>();
//    public Deque<Integer> s1 = new LinkedList<>();
//    public Deque<Integer> s2 = new LinkedList<>();

    public CQueue() {

    }

    public void appendTail(int value) {
        s1.addLast(value);
    }

    public int deleteHead() {

        if (s2.isEmpty()){
            while (!s1.isEmpty()){
                s2.addLast(s1.removeFirst());
            }
        }
        return s2.isEmpty()?-1:s2.removeFirst();
    }
}

/*
 * Your CQueue object will be instantiated and called as such:
 * CQueue obj = new CQueue();
 * obj.appendTail(value);
 * int param_2 = obj.deleteHead();
 */