package com.example.leetcode_sha_2.jian_zhi_offer;

import java.util.ArrayDeque;

public class s30_no {

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.min());
        minStack.pop();
        System.out.println(minStack.top());
        System.out.println(minStack.min());

    }

//    定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的 min 函数在该栈中，调用 min、push 及 pop 的时间复杂度都是 O(1)。

}


class MinStack {

    ArrayDeque<Integer> s1 = new ArrayDeque<>();
    ArrayDeque<Integer> s2 = new ArrayDeque<>();

    /** initialize your data structure here. */
    public MinStack() {

    }

    public void push(int x) {
        s1.addLast(x);
        if (s2.isEmpty() || s2.getLast()>=x){
            s2.addLast(x);
        }
    }

    public void pop() {
        Integer temp = s1.removeLast();
        if (temp.equals(s2.getLast())){
            s2.removeLast();
        }
    }

    public int top() {
        return s1.getLast();
    }

    public int min() {
        return s2.getLast();
    }
}

/*
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.min();
 */