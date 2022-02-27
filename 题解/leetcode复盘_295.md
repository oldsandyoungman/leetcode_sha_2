很多题目还是一错再错，决定做个复盘，记录下自己哪里写错了



[TOC]

#### [295. 数据流的中位数](https://leetcode-cn.com/problems/find-median-from-data-stream/)

> 中位数是有序列表中间的数。如果列表长度是偶数，中位数则是中间两个数的平均值。
>
> 例如，
>
> [2,3,4] 的中位数是 3
>
> [2,3] 的中位数是 (2 + 3) / 2 = 2.5
>
> 设计一个支持以下两种操作的数据结构：
>
> - void addNum(int num) - 从数据流中添加一个整数到数据结构中。
> - double findMedian() - 返回目前所有元素的中位数
>
> 进阶:
>
> 如果数据流中所有整数都在 0 到 100 范围内，你将如何优化你的算法？
> 如果数据流中 99% 的整数都在 0 到 100 范围内，你将如何优化你的算法？



##### 思路

虽然想到了是两个优先级队列，但是思路却搞错了，我以外是要比较当前数和两个堆顶元素的关系再加入，但中位数中位数，放哪个堆单纯就是谁数量多而已



而我担心的会不会一个放[1,3]，一个放[2]，这是在放入之后再进行辗转腾挪操作的，不必再放入之前考虑大小关系（大小关系会有优先级队列本身的性质保证）





##### 注意点

- 返回的是double类型



##### 代码

```java
class MedianFinder {

    PriorityQueue<Integer> q1;
    PriorityQueue<Integer> q2;

    public MedianFinder() {
        // 每次取出的是最小值
        q1 = new PriorityQueue<>();
        // 每次取出的是最大值
        q2 = new PriorityQueue<>((o1, o2) -> {
            return Integer.compare(o2, o1);
        });
    }
    
    public void addNum(int num) {
        if(q1.size()>q2.size()){
            q1.offer(num);
            q2.offer(q1.poll());
        }else{
            q2.offer(num);
            q1.offer(q2.poll());
        }
    }
    
    public double findMedian() {
        if(q2.size()>q1.size()){
            return q2.peek();
        }
        if(q1.size()>q2.size()){
            return q1.peek();
        }
        return q1.peek() + (q2.peek()-q1.peek())/2.0;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
```
