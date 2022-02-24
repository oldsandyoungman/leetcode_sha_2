package com.example.leetcode_sha_2.leetcode_origin;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class s895 {

    public static void main(String[] args) {

    }

//    设计一个类似堆栈的数据结构，将元素推入堆栈，并从堆栈中弹出出现频率最高的元素。
//
//    实现 FreqStack 类:
//
//    FreqStack() 构造一个空的堆栈。
//    void push(int val) 将一个整数 val 压入栈顶。
//    int pop() 删除并返回堆栈中出现频率最高的元素。
//    如果出现频率最高的元素不只一个，则移除并返回最接近栈顶的元素。
//
//    来源：力扣（LeetCode）
//    链接：https://leetcode-cn.com/problems/maximum-frequency-stack
//    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

}

class FreqStack {

    int maxFre;
    HashMap<Integer, Integer> val_fre;
    HashMap<Integer, ArrayDeque<Integer>> fre_val;

    public FreqStack() {
        maxFre = 0;
        val_fre = new HashMap<>();
        fre_val = new HashMap<>();
    }

    public void push(int val) {
        int fre = val_fre.getOrDefault(val, 0);
        // if(fre>0){
        //     fre_val.get(fre).remove(val);
        // }
        fre++;
        val_fre.put(val, fre);
        fre_val.putIfAbsent(fre, new ArrayDeque<>());
        fre_val.get(fre).addLast(val);
        maxFre = Math.max(maxFre, fre);
    }

    public int pop() {
        ArrayDeque<Integer> cur = fre_val.get(maxFre);
        int val = cur.removeLast();
        val_fre.put(val, maxFre-1);
        if(cur.isEmpty()){
            maxFre--;
        }
        return val;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */