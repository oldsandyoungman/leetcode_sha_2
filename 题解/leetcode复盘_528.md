很多题目还是一错再错，决定做个复盘，记录下自己哪里写错了



[TOC]

#### [528. 按权重随机选择](https://leetcode-cn.com/problems/random-pick-with-weight/)

> 给你一个 下标从 0 开始 的正整数数组 w ，其中 w[i] 代表第 i 个下标的权重。
>
> 请你实现一个函数 pickIndex ，它可以 随机地 从范围 [0, w.length - 1] 内（含 0 和 w.length - 1）选出并返回一个下标。选取下标 i 的 概率 为 w[i] / sum(w) 。
>
> 例如，对于 w = [1, 3]，挑选下标 0 的概率为 1 / (1 + 3) = 0.25 （即，25%），而选取下标 1 的概率为 3 / (1 + 3) = 0.75（即，75%）。
>
> 
>
> **提示：**
>
> - `1 <= w.length <= 104`
>- `1 <= w[i] <= 105`
> - `pickIndex` 将被调用不超过 `104` 次



##### 思路

带权重的随机选择，可以想象成一个线段，划分不同长度区域，指定不同区域属于哪个下标，而这种形式其实就是前缀和数组，而在此基础上，如何找到随机数属于哪一段，就要用到二分查找（找到所属线段的右边界，即大于当前数的最小坐标值）



##### 注意点

- preSum的大小比原数组要大一个
- 随机数的范围不能包括零，因为找的是线段的右边界嘛，所以范围肯定从 1 开始
- 最后返回值是原数组的下标值，因此需要在preSum的下标值基础上减一



##### 代码

```java
class Solution {

    int[] preSum;
    Random r;

    public Solution(int[] w) {
        int n = w.length;
        preSum = new int[n+1];
        r = new Random();
        for(int i=1; i<=n; i++){
            preSum[i] = preSum[i-1] + w[i-1];
        }

    }
    
    public int pickIndex() {
        int n = preSum.length;
        int target = 1 + r.nextInt(preSum[n-1]);

        int left = 0;
        int right = n-1;

        while(left<=right){
            int mid = left + (right-left)/2;
            if(preSum[mid]<target){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }

        return left - 1;

    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */
```
