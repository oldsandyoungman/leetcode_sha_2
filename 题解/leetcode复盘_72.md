很多题目还是一错再错，决定做个复盘，记录下自己哪里写错了



[TOC]

#### [72. 编辑距离](https://leetcode-cn.com/problems/edit-distance/)

> 给你两个单词 word1 和 word2， 请返回将 word1 转换成 word2 所使用的最少操作数  。
>
> 你可以对一个单词进行如下三种操作：
>
> 插入一个字符
> 删除一个字符
> 替换一个字符
>
> 
>
> **提示：**
>
> - `0 <= word1.length, word2.length <= 500`
> - `word1` 和 `word2` 由小写英文字母组成



##### 思路

就是正常的 dp 思路，`dp[i][j]` 代表从`word1[0~i]` 变成 `word2[0~j]`所需要的最小步骤

之后就是找递推关系



##### 注意点

在进行状态空间压缩时，其实定义变量 `left`，`left_top`，`top`，再慢慢捋一捋关系，就能搞出来

> 注：
>
> 这道题在 `n2==0` 时，会有点问题，`dp[n2]` 并没有被更新，答案存在 left 里



##### 代码

```java
class Solution {
    public int minDistance(String word1, String word2) {
        // char[] s1 = word1.toCharArray();
        // char[] s2 = word2.toCharArray();

        // int n1 = s1.length;
        // int n2 = s2.length;

        // int[][] dp = new int[n1+1][n2+1];

        // // base:
        // for(int i=0; i<=n1; i++){
        //     dp[i][0] = i;
        // }
        // for(int i=0; i<=n2; i++){
        //     dp[0][i] = i;
        // }

        // for(int i=1; i<=n1; i++){
        //     for(int j=1; j<=n2; j++){
        //         if(s1[i-1]==s2[j-1]){
        //             dp[i][j] = dp[i-1][j-1];
        //         }else{
        //             dp[i][j] = Math.min(Math.min(dp[i-1][j-1], dp[i-1][j]), dp[i][j-1]) + 1;
        //         }
        //     }
        // }
        
        // return dp[n1][n2];


// 压缩空间

        int n1 = word1.length();
        int n2 = word2.length();

        // if(n2==0){
        //     return n1;
        // }
        
        char[] s1 = word1.toCharArray();
        char[] s2 = word2.toCharArray();

        
        

        int[] dp = new int[n2+1];

        // base:
        // for(int i=0; i<=n1; i++){
        //     dp[i][0] = i;
        // }
        for(int i=0; i<=n2; i++){
            dp[i] = i;
        }

        for(int i=1; i<=n1; i++){
            int left = i;
            int left_top = i-1;
            for(int j=1; j<=n2; j++){
                int tmp = dp[j];

                if(s1[i-1]==s2[j-1]){
                    dp[j] = left_top;
                }else{
                    dp[j] = Math.min(Math.min(left_top, dp[j]), left) + 1;
                }

                left_top = tmp;
                left = dp[j];
            }
        }
        
        return dp[n2];

    }
}
```



