很多题目还是一错再错，决定做个复盘，记录下自己哪里写错了



[TOC]

#### [712. 两个字符串的最小ASCII删除和](https://leetcode-cn.com/problems/minimum-ascii-delete-sum-for-two-strings/)

> 给定两个字符串`s1, s2`，找到使两个字符串相等所需删除字符的ASCII值的最小和。
>
> 
>
> **注意:**
> 
>- `0 < s1.length, s2.length <= 1000`。
> - 所有字符串中的字符ASCII值在`[97, 122]`之间。



##### 思路

退化到核心，其实是关于最长公共子序列的题，本地的框架跟最长公共子序列一样，只是因为要计算删掉的ASCII码值，因此`dp[i][j]`的定义从

>  s1[0,i]和s2[0,j]的最长公共子序列的长度

变成了

>  s1[0,i]和s2[0,j]删到最长公共子序列所删的ASCII码值的和

因此递归的逻辑也稍有不同



##### 注意点

递归的过程里，关于s1[i-1]==s2[j-1]时的递推关系，不要写反

```java
dp[i][j] = Math.min(dp[i-1][j]+t1[i-1], dp[i][j-1]+t2[j-1]);
```

`dp[i][j]`和`dp[i-1][j]`，从字面上看相差的就是s1[i-1]，因此要加的肯定是`t1[i-1]`，而不是`t2[j-1]`



##### 代码

```java
class Solution {
    public int minimumDeleteSum(String s1, String s2) {
        char[] t1 = s1.toCharArray();
        char[] t2 = s2.toCharArray();

        int n1 = t1.length;
        int n2 = t2.length;

        int[][] dp = new int[n1+1][n2+1];

        for(int i=1; i<=n1; i++){
            dp[i][0] = dp[i-1][0] + t1[i-1];
        }
        for(int j=1; j<=n2; j++){
            dp[0][j] = dp[0][j-1] + t2[j-1];
        }


        for(int i=1; i<=n1; i++){
            for(int j=1; j<=n2; j++){
                if(t1[i-1]==t2[j-1]){
                    dp[i][j] = dp[i-1][j-1];
                }else{
                    dp[i][j] = Math.min(dp[i-1][j]+t1[i-1], dp[i][j-1]+t2[j-1]);
                }
            }
        }

        return dp[n1][n2];
    }
}
```
