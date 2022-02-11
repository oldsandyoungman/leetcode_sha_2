很多题目还是一错再错，决定做个复盘，记录下自己哪里写错了



[TOC]

#### [877. 石子游戏](https://leetcode-cn.com/problems/stone-game/)

> Alice 和 Bob 用几堆石子在做游戏。一共有偶数堆石子，排成一行；每堆都有 正 整数颗石子，数目为 piles[i] 。
>
> 游戏以谁手中的石子最多来决出胜负。石子的 总数 是 奇数 ，所以没有平局。
>
> Alice 和 Bob 轮流进行，Alice 先开始 。 每回合，玩家从行的 开始 或 结束 处取走整堆石头。 这种情况一直持续到没有更多的石子堆为止，此时手中 石子最多 的玩家 获胜 。
>
> 假设 Alice 和 Bob 都发挥出最佳水平，当 Alice 赢得比赛时返回 true ，当 Bob 赢得比赛时返回 false 。
>
> 
>
> 提示：
>
> - 2 <= piles.length <= 500
> - piles.length 是 偶数
> - 1 <= piles[i] <= 500
> - sum(piles[i]) 是 奇数



##### 思路

- 先后手的博弈问题，第一个人的先手，之后就是第二个人的后手，这种转换就是动态规划的典型标志

- dp数组建立需要额外增加一个维度，分别保存先后手的结果





##### 注意点

递推关系中，不能直接max周围的结果，而是要一脉相承，如果先手选定了拿左边，那么不管是`dp[i][j][0]`还是`dp[i][j][1]`，都要在选定了拿左边之后再计算，要统一



##### 代码

```java
class Solution {
    public boolean stoneGame(int[] piles) {
        int n = piles.length;

        int[][][] dp = new int[n][n][2];

        for(int i=0; i<n; i++){
            dp[i][i][0] = piles[i];
            dp[i][i][1] = 0;
        }

        for(int i=n-2; i>=0; i--){
            for(int j=i+1; j<n; j++){

                // 如果选左边
                int left = dp[i+1][j][1]+piles[i];
                int right = dp[i][j-1][1]+piles[j];

                if(left>right){
                    dp[i][j][0] = left;
                    dp[i][j][1] = dp[i+1][j][0];
                }else{
                    dp[i][j][0] = right;
                    dp[i][j][1] = dp[i][j-1][0];
                }
            }
        }

        return dp[0][n-1][0] > dp[0][n-1][1];

    }
}
```

