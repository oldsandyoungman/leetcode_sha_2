很多题目还是一错再错，决定做个复盘，记录下自己哪里写错了



[TOC]

#### [494. 目标和](https://leetcode-cn.com/problems/target-sum/)

> 给你一个整数数组 nums 和一个整数 target 。
>
> 向数组中的每个整数前添加 '+' 或 '-' ，然后串联起所有整数，可以构造一个 表达式 ：
>
> 例如，nums = [2, 1] ，可以在 2 之前添加 '+' ，在 1 之前添加 '-' ，然后串联起来得到表达式 "+2-1" 。
> 返回可以通过上述方法构造的、运算结果等于 target 的不同 表达式 的数目。
>
> 
>
> 提示：
>
> 1 <= nums.length <= 20
> 0 <= nums[i] <= 1000
> 0 <= sum(nums[i]) <= 1000
> -1000 <= target <= 1000
>



##### 思路

回溯可做，动态规划也可做：

1. 回溯法：即对于数组里的第 i 个数，有两种选择：“+”，“-”；状态就是前 i-1 个数的和
2. 回溯法 + 备忘录剪枝：可以将状态存进 HashMap：Key 为 i + sum 的字符串，Value 为选择数目
3. 动态规划：通过数学运算转化为 0/1 背包问题



##### 注意点

- 对于方法2，回溯函数得返回 int 类型，并且当达到终止条件时，返回1，中间的迭代过程，返回的是 res1 + res2
- 对于方法2，回溯函数终止条件除了满足要返回1，另外还要返回0
- 对于方法3，初始化 `dp[i][j]`（从前 i 个物品凑出和为 j 的选择数目）时候，`dp[0][0]`也要为1，`dp[i][0]`为1
- 对于方法3，在循环的时候，j 要从0开始，因为target为 0 时选择数目不会永远为1，比如数组里有一堆0，那么选择数组就会在之后的循环里不断*2



##### 代码

1. 回溯法

```java
class Solution {
// 回溯方法
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        res = 0;
        backtrack(nums, 0, target, n);
        return res;
    }
    public int res;
    public void backtrack(int[] nums, int start, int target, int N){
        if(start==N){
            if(target==0){
                res++;
            }
            return;
        }

        // 如果nums[start]取正号
        target -= nums[start];
        backtrack(nums, start+1, target, N);
        target += nums[start];

        // 如果nums[start]取负号
        target += nums[start];
        backtrack(nums, start+1, target, N);
        target -= nums[start];

    }

}


```

2. 回溯法+剪枝

```java
class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        m = new HashMap<>();
        return backtrack(nums, 0, target, n);
    }
    public HashMap<String, Integer> m;
    public int res;
    public int backtrack(int[] nums, int start, int target, int N){
        if(start==N){
            if(target==0){
                return 1;
            }else{
                return 0;
            }
        }

        String cur = start + "," + target;
        if(m.containsKey(cur)){
            return m.get(cur);
        }

        // 如果nums[start]取正号
        target -= nums[start];
        int res1 = backtrack(nums, start+1, target, N);
        target += nums[start];

        // 如果nums[start]取负号
        target += nums[start];
        int res2 = backtrack(nums, start+1, target, N);
        target -= nums[start];

        int res = res1 + res2;
        m.put(cur, res);
        return res;
    }

}


```

3. 动态规划

```java
class Solution {
// 动态规划
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        int sum = 0;
        for(int num : nums){
            sum += num;
        }
        int new_target = sum + target;
        if(Math.abs(target)>sum || new_target%2==1){
            return 0;
        }
        new_target /= 2;
        return bag(nums, new_target);

    }
    public int bag(int[] nums, int target){
        int n = nums.length;
        int[][] dp = new int[n+1][target+1];
        // for(int i=0; i<=target; i++){
        //     dp[0][i] = 0;
        // }
        for(int i=0; i<=n; i++){
            dp[i][0] = 1;
        }

        for(int i=1; i<=n; i++){
            for(int j=0; j<=target; j++){
                if(j>=nums[i-1]){
                    dp[i][j] = dp[i-1][j-nums[i-1]] + dp[i-1][j];
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        return dp[n][target];

    }

}

```
