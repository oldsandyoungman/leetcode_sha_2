很多题目还是一错再错，决定做个复盘，记录下自己哪里写错了



[TOC]

#### [516. 最长回文子序列](https://leetcode-cn.com/problems/longest-palindromic-subsequence/)

> 给你一个字符串 s ，找出其中最长的回文子序列，并返回该序列的长度。
>
> 子序列定义为：不改变剩余字符顺序的情况下，删除某些字符或者不删除任何字符形成的一个序列。
>
> 
>
> **提示：**
>
> - `1 <= s.length <= 1000`
> - `s` 仅由小写英文字母组成



##### 思路

回文子序列的动态规划，base case 是`dp[i][i]`==1，递归关系如下：

> 如果`s[i]==s[j]`，那么`dp[i][j]=dp[i+1][j-1]+2`
>
> 如果`s[i]!=s[j]`，那么`dp[i][j]`取`dp[i+1][j]`和`dp[i][j-1]`中的更大值



##### 注意点

- 因为base case是对角线，所以遍历的顺序是从下到上，从右往左

- 关于空间压缩，具体步骤如下：

  > 直接去掉前一个维度，看原来二维的递推关系里，哪个值会被覆盖因而无法在一维数组里被表达
  >
  > 大概率外层循环里新建一个pre变量，内层循环里用temp存下运算前的值，再将temp值赋给pre变量即可

- 当然，如果真的理不清关系，可以画图，然后用left，left_bottom，bottom来代替所有的dp[j]，然后想办法在循环内外更新各值就行



##### 代码

1. 动态规划（无状态压缩）

```java
class Solution {
    public int longestPalindromeSubseq(String s) {
        char[] ss = s.toCharArray();
        int n = ss.length;

        int[][] dp = new int[n][n];
        for(int i=0; i<n; i++){
            dp[i][i] = 1;
        }

        for(int i=n-2; i>=0; i--){
            for(int j=i+1; j<n; j++){
                if(ss[i]==ss[j]){
                    dp[i][j] = dp[i+1][j-1] + 2;
                }else{
                    dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1]);
                }
            }
        }

        return dp[0][n-1];
        
    }
}
```

2. 动态规划+labuladong压缩

```java
class Solution {
    public int longestPalindromeSubseq(String s) {
        char[] ss = s.toCharArray();
        int n = ss.length;

        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        for(int i=n-2; i>=0; i--){
            int pre = 0;
            for(int j=i+1; j<n; j++){
                int tmp = dp[j];
                if(ss[i]==ss[j]){
                    // dp[i][j] = dp[i+1][j-1] + 2;
                    dp[j] = pre + 2;
                }else{
                    dp[j] = Math.max(dp[j], dp[j-1]);
                }
                pre = tmp;
            }
        }

        return dp[n-1];

    }
}
```

3. 动态规划 + 我的最笨压缩法

```java
class Solution {
    public int longestPalindromeSubseq(String s) {

        char[] ss = s.toCharArray();
        int n = ss.length;

        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        for(int i=n-2; i>=0; i--){
            int left = 1;
            int left_bottom = 0;
            int bottom = 1;
            for(int j=i+1; j<n; j++){
                bottom = dp[j];
                if(ss[i]==ss[j]){
                    // dp[i][j] = dp[i+1][j-1] + 2;
                    dp[j] = left_bottom + 2;
                }else{
                    // dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1]);
                    dp[j] = Math.max(bottom, left);
                }
                left_bottom = bottom;
                left = dp[j];
            }
        }

        return dp[n-1];


    }
}
```

