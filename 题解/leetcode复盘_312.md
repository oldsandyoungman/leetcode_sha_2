很多题目还是一错再错，决定做个复盘，记录下自己哪里写错了



[TOC]

#### [312. 戳气球](https://leetcode-cn.com/problems/burst-balloons/)

> 有 n 个气球，编号为0 到 n - 1，每个气球上都标有一个数字，这些数字存在数组 nums 中。
>
> 现在要求你戳破所有的气球。戳破第 i 个气球，你可以获得 nums[i - 1] * nums[i] * nums[i + 1] 枚硬币。 这里的 i - 1 和 i + 1 代表和 i 相邻的两个气球的序号。如果 i - 1或 i + 1 超出了数组的边界，那么就当它是一个数字为 1 的气球。
>
> 求所能获得硬币的最大数量。
>
> 
>
> **提示：**
>
> - `n == nums.length`
> - `1 <= n <= 500`
> - `0 <= nums[i] <= 100`



##### 思路

dp函数的定义不容易想到，想到了就会做了：

> `dp[i][j]`：戳破 (i, j) 开区间内的所有气球所得到的最高分

因此递推关系自然而然地就是：

> `dp[i][j] = max(dp[i][k] + dp[k][j] + nums[i]*nums[k]*nums[j])`



明确递推关系以后，加上base0的情况（`dp[i][i]=0`），发现需要从下往上，从左往右遍历，之后大概就没啥问题了



##### 注意点

对于递推关系，注意是讨论的是(i, j)之间最后删除的数nums[k]，所以是`nums[i]*nums[k]*nums[j]`，而不是`nums[k-1]*nums[k]*nums[k+1]`



##### 代码

1. 动态规划

```java
class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        n += 2;
        int[] s = new int[n];
        s[0] = 1;
        s[n-1] = 1;
        for(int i=1; i<n-1; i++){
            s[i] = nums[i-1];
        }

        // dp[i][j]：(i, j)开区间内戳破所有气球，得到的最高得分
        int[][] dp = new int[n][n];

        // base0: dp[i][i] = 0;

        for(int i=n-2; i>=0; i--){
            for(int j=i+1; j<n; j++){
                int res = 0;
                for(int k=i+1; k<j; k++){
                    res = Math.max(res, dp[i][k] + dp[k][j] + s[i]*s[k]*s[j]);
                }
                dp[i][j] = res;
            }
        }

        System.out.println(Arrays.deepToString(dp));

        return dp[0][n-1];

    }

}
```

