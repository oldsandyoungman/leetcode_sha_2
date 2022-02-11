很多题目还是一错再错，决定做个复盘，记录下自己哪里写错了



[TOC]

#### [651. 4键键盘](https://leetcode-cn.com/problems/4-keys-keyboard/)


> 假设你有一个特殊的键盘包含下面的按键︰
> Key 1: (A)︰在屏幕上打印一个'A'。
> Key 2: (ctrl-A)︰选中整个屏幕。
> Key 3: (ctrl-c)∶复制选中区域到缓冲区。
> Key 4: (ctr1-v)∶将缓冲区内容输出到上次输入的结束位置，并显示在屏幕上。
> 
> 现在，你只可以按键Ⅳ次（使用上述四种按键)，请问屏幕上最多可以显示几个'A'呢?
> 



##### 思路

典型的动态规划，按照思路，最难的是如何确定dp函数的定义（函数的参数，也就是状态，所以一确定就会确定俩）



1. 普通的思路，状态有3个：

   - 还剩下的按键次数

   - 当前屏幕的数量

   - 粘贴板中的数量

   选择按道理是有几个键就按几个，但是C-A，C-C一般都是连起来用的所以就变成3种了：

   - 按一个“A”

   - 按 C-V

   - 按 C-A + C-V

   递推关系就取三者中的最大值即可



2. 更巧妙的思路，因为可以认为，要想按更多的“A”，就只有连续按“A”，或者按一通 C-A => C-C => C-V*n这样的组合。所以其实只要讨论两种情况就行

   > 对于第二种情况，没有太好的办法，只能遍历所有可能，即从 j=2 开始+1遍历，认为从 j 开始一直 C-V，即：
   >
   > ```java
   > dp[i] = max(dp[i], dp[j-2]*(i-j+1))
   > ```





##### 注意点

- 这道题体现了HashMap的好处，当不确定状态参数的范围时，就不大好确定数组的大小，因此例如这道题，只好用HashMap来记录三个状态参数对应的值

- 思路一中，base0为剩余次数<=0，而不是等于0，因为递推关系中有i-2，所以可能从1跳到 -1

  



##### 代码

1. 思路一

```java
class Solution {
    public static int maxNum(int n){
        memo = new HashMap<>();
        return dp(n, 0, 0);

    }

    public static HashMap<String, Integer> memo;

    // dp(i, j, k): 剩余i次操作机会，屏幕已有j个，粘贴板有k个
    public static int dp(int i, int j, int k){
        if(i<=0){
            return j;
        }
        String cur = i + "," + j + "," + k;
        if(memo.containsKey(cur)){
            return memo.get(cur);
        }

        int res1 = dp(i-1, j+1, k);
        int res2 = dp(i-1, j+k, k);
        int res3 = dp(i-2, j, j);

        int res = Math.max(Math.max(res1, res2), res3);

        memo.put(cur, res);

        return res;

    }
}
```

2. 思路二

```java
class Solution {
    public static int maxNum(int n){
        int[] dp = new int[n+1];

        // base0：dp[0] = 0;

        for(int i=1; i<=n; i++){
            dp[i] = dp[i-1] + 1;

            for(int j=2; j<=i; j++){
                dp[i] = Math.max(dp[i], dp[j-2]*(i-j+1));
            }

        }

        return dp[n];

    }
    

}
```

