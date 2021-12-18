package com.example.leetcode_sha_2.jian_zhi_offer;

import java.util.ArrayDeque;

public class s59_2 {

    public static void main(String[] args) {

    }

//    请定义一个队列并实现函数 max_value 得到队列里的最大值，要求函数max_value、push_back 和 pop_front 的均摊时间复杂度都是O(1)。
//
//    若队列为空，pop_front 和 max_value 需要返回 -1
//
//    来源：力扣（LeetCode）
//    链接：https://leetcode-cn.com/problems/dui-lie-de-zui-da-zhi-lcof
//    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

}

class MaxQueue {
    ArrayDeque<Integer> q1;
    ArrayDeque<Integer> q2;
    public MaxQueue() {
        q1 = new ArrayDeque<>();
        q2 = new ArrayDeque<>();
    }

    public int max_value() {
        return q2.isEmpty()?-1:q2.getFirst();
    }

    public void push_back(int value) {
        q1.addLast(value);
        while(!q2.isEmpty() && value>q2.getLast()){
            q2.removeLast();
        }
        q2.addLast(value);
    }

    public int pop_front() {
        int res = q1.isEmpty()?-1:q1.removeFirst();
        if(!q2.isEmpty() && q2.getFirst().equals(res)){
            q2.removeFirst();
        }
        return res;
    }
}
