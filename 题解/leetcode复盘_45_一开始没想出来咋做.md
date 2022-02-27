很多题目还是一错再错，决定做个复盘，记录下自己哪里写错了



[TOC]

#### [45. 跳跃游戏 II](https://leetcode-cn.com/problems/jump-game-ii/)

> 给你一个非负整数数组 nums ，你最初位于数组的第一个位置。
>
> 数组中的每个元素代表你在该位置可以跳跃的最大长度。
>
> 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
>
> 假设你总是可以到达数组的最后一个位置。
>
> 
>
> **提示:**
>
> - `1 <= nums.length <= 104`
> - `0 <= nums[i] <= 1000`



##### 思路

可以用动态规划，但循环内部还有循环，复杂度较高

用贪心策略的话，要发现每轮只要跳潜力最大的即可，即：

> 我在 i 处，下一跳的范围是 `[i, i+nums[i]]`，在这个范围内，取潜力最大
>
> - 所谓潜力最大，就是那个坐标处的 i+nums[i]最大（也就是 farthest 的定义）

因此，我们定义farthest，就是每次选取潜力最大的标准



##### 注意点

遍历依然只需要到n-2，不然jump会多1



##### 代码

1. 动态规划方法

```java
class Solution {
    public int jump(int[] nums) {
        int n =nums.length;
        int[] dp = new int[n];
        // base: dp[n-1] = 0;
        Arrays.fill(dp, n+1);
        dp[n-1] = 0;
        for(int i=n-2; i>=0; i--){
            for(int j=i+1; j<n; j++){
                if(nums[i]+i>=j){
                    dp[i] = Math.min(dp[i], dp[j]+1);
                }
            }
        }
        return dp[0];
    }
}
```

2. 贪心

```java
class Solution {
    public int jump(int[] nums) {

        int n = nums.length;
        // 上一轮的最远边界
        int end = 0;
        // 目前能到达的最远距离
        int farthest = 0;
        // 总跳数
        int jump = 0;
        for(int i=0; i<n-1; i++){
            farthest = Math.max(farthest, nums[i]+i);
            if(end==i){
                end = farthest;
                jump++;
            }
        }
        return jump;

    }
}
```



