package com.example.leetcode_sha_2.jian_zhi_offer;

import java.util.PriorityQueue;

public class s41 {

    public static void main(String[] args) {
        MedianFinder m = new MedianFinder();
        m.addNum(1);
        m.addNum(2);
        System.out.println(m.findMedian());
        m.addNum(3);
        System.out.println(m.findMedian());
    }

//    如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。
//
//    例如，
//
//            [2,3,4] 的中位数是 3
//
//            [2,3] 的中位数是 (2 + 3) / 2 = 2.5
//
//    设计一个支持以下两种操作的数据结构：
//
//    void addNum(int num) - 从数据流中添加一个整数到数据结构中。
//    double findMedian() - 返回目前所有元素的中位数。
//
//    来源：力扣（LeetCode）
//    链接：https://leetcode-cn.com/problems/shu-ju-liu-zhong-de-zhong-wei-shu-lcof
//    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。


}


class MedianFinder {

    PriorityQueue<Integer> q_high;
    PriorityQueue<Integer> q_low;

    /** initialize your data structure here. */
    public MedianFinder() {
        q_high = new PriorityQueue<>();
        q_low = new PriorityQueue<>((o1, o2) -> Integer.compare(o2, o1));
    }

    public void addNum(int num) {
        if(q_high.size() == q_low.size()){
            q_low.add(num);
            q_high.add(q_low.poll());
        }else{
            q_high.add(num);
            q_low.add(q_high.poll());
        }
    }

    public double findMedian() {
        if(q_high.size() == q_low.size()){
            return (q_high.peek() + q_low.peek())/2.0;
        }else{
            return q_high.peek();
        }
    }
}
