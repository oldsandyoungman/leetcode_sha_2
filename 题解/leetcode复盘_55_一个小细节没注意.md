很多题目还是一错再错，决定做个复盘，记录下自己哪里写错了



[TOC]

#### [55. 跳跃游戏](https://leetcode-cn.com/problems/jump-game/)

> 给定一个非负整数数组 `nums` ，你最初位于数组的 **第一个下标** 。
>
> 数组中的每个元素代表你在该位置可以跳跃的最大长度。
>
> 判断你是否能够到达最后一个下标。
>
> 
>
> **提示：**
>
> - `1 <= nums.length <= 3 * 104`
> - `0 <= nums[i] <= 105`



##### 思路

设定一个farthest，代表当前所能跳到的最远距离，如果跳不到最后，仅有可能是 `farthest==i` ，这也是本题的破题点



##### 注意点

遍历只需要到n-2，不然有反例会报错

> ```java
> int[] nums = {0};
> ```



##### 代码

```java
class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int farthest = 0;
        for(int i=0; i<n-1; i++){
            farthest = Math.max(farthest, i+nums[i]);
            if(farthest<=i){
                return false;
            }
        }
        return true;
    }
}
```



