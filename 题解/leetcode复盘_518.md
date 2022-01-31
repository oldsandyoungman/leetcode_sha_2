很多题目还是一错再错，决定做个复盘，记录下自己哪里写错了



[TOC]

#### [518. 零钱兑换 II](https://leetcode-cn.com/problems/coin-change-2/)

> 给你一个整数数组 coins 表示不同面额的硬币，另给一个整数 amount 表示总金额。
>
> 请你计算并返回可以凑成总金额的硬币组合数。如果任何硬币组合都无法凑出总金额，返回 0 。
>
> 假设每一种面额的硬币有无限个。 
>
> 题目数据保证结果符合 32 位带符号整数。
>
> 
>
> 提示：
>
> 1 <= coins.length <= 300
> 1 <= coins[i] <= 5000
> coins 中的所有值 互不相同
> 0 <= amount <= 5000
>



##### 思路

所有的0/1背包问题，都只有两种目的

> 基本类型：求最大价值
>
> - 除了数组(重量)本身，还会给个价值数组，问在限定重量下的最大价值
>
> 
>
> 变体：求是否能够正好装满
>
> - 只会给一个数组，然后问能不能求和凑到target。当然在这个目的下还有2个变体
>   - 数组元素只能用一次。那么递推关系的时候，`dp[i][j]` = `dp[i-1][j]` + `dp[i-1][j-nums[i-1]]` 
>   -  数组元素能用无限次。那么递推关系的时候，`dp[i][j]` = `dp[i-1][j]` + `dp[i][j-nums[i-1]]` 。因为能用无限次嘛，所以最后面的 i 不用减1，代表还能用`nums[i-1]`



##### 注意点

- 初始化的时候，`dp[0][j]=0`，`dp[i][0]=1`，当然，`dp[0][0]=1`

- 压缩空间时，如果涉及道用`dp[i-1][j-nums[i-1]]` ，那么内层循环就要额外倒序；如果是`dp[i][j-nums[i-1]]` ，那么就不用倒序了

##### 代码

1. 无空间压缩

```java
class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[n+1][amount+1];
        for(int i=0; i<=n; i++){
            dp[i][0] = 1;
        }

        for(int i=1; i<=n; i++){
            for(int j=1; j<=amount; j++){
                if(j>=coins[i-1]){
                    dp[i][j] = dp[i-1][j] + dp[i][j-coins[i-1]];
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        return dp[n][amount];
        
    }
}
```

2. 空间压缩

```java
class Solution {
    public int change(int amount, int[] coins) {
        // 压缩空间
        int n = coins.length;
        int[] dp = new int[amount+1];
        dp[0] = 1;

        for(int i=1; i<=n; i++){
            for(int j=1; j<=amount; j++){
                if(j>=coins[i-1]){
                    dp[j] = dp[j] + dp[j-coins[i-1]];
                }else{
                    dp[j] = dp[j];
                }
            }
        }

        return dp[amount];

    }
}
```

