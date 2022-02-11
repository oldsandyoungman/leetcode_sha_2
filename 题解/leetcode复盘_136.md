很多题目还是一错再错，决定做个复盘，记录下自己哪里写错了



[TOC]

#### [136. 只出现一次的数字](https://leetcode-cn.com/problems/single-number/)

> 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
>
> 说明：
>
> 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
>



##### 思路

> `a^a` = 0
>
> `a^0` = a



##### 注意点

写多了会把这个性质写成&，注意只有异或才有这个性质



##### 代码

```java
class Solution {
    public int singleNumber(int[] nums) {
        int sum = 0;
        for(int num : nums){
            sum ^= num;
        }
        return sum;
    }
}
```

