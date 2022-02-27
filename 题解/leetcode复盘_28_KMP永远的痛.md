很多题目还是一错再错，决定做个复盘，记录下自己哪里写错了



[TOC]

#### [28. 实现 strStr()](https://leetcode-cn.com/problems/implement-strstr/)

> 实现 strStr() 函数。
>
> 给你两个字符串 haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串出现的第一个位置（下标从 0 开始）。如果不存在，则返回  -1 。
>
>  
>
> 说明：
>
> 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
>
> 对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与 C 语言的 strstr() 以及 Java 的 indexOf() 定义相符。
>
> 
>
> 提示：
>
> 0 <= haystack.length, needle.length <= 5 * 104
> haystack 和 needle 仅由小写英文字符组成
>
> 来源：力扣（LeetCode）
> 链接：https://leetcode-cn.com/problems/implement-strstr
> 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。





##### 思路

KMP一共两个大步骤：

1. 构造函数，根据给定字符串，生成`dp[i][j]`

   > `dp[i][j]`：当你在状态 i 时，如果碰到字符 j ，跳转到状态 `dp[i][j]`

   dp 的生成，遍历一遍字符串更新填值即可，一共三小步

   - 如果在状态 i，如果碰到不是字符串中的第 i 个字符，那么回到影子状态 x 对应该走的状态 `dp[x][ss[i]]`，即：

     ```java
     dp[i][k] = dp[x][k];
     ```

   - 如果在状态 i，如果碰到的是字符串中的第 i 个字符，那么正常加一，进入下一个状态即可

     ```java
     dp[i][ss[i]] = i+1;
     ```

   - 另外，记得更新影子状态，影子状态的更新，和调用搜索函数的过程比较像，影子状态x的下一个位置，即 状态 x 碰到字符串中的第 i 个字符所应跳转的位置

     ```java
     x = dp[x][ss[i]];
     ```

2. 搜索函数，根据 `dp[i][j]`  来进行相应跳转即可

   ```java
   index = dp[index][ss[i]];
   ```

   过程里进行判断，如果到达最后一个状态，返回当前位置之前N个位置即可

   ```java
   if(index==N){
       return i-N+1;
   }
   ```

   



##### 注意点

- 题目中有几个特例，就是如果needle是空串，那么无论haystack是什么，都返回0。因此，构造函数要额外判断，如果needle是空串，dp啥都不用做；搜索函数判断N如果为0，直接返回0

- 构造函数base0可以先写：

  ```java
  dp[0][ss[i]] = 1;
  x = 0; // 影子状态
  ```

  这样之后的更新，i从1开始即可（不然x的更新总是快dp一步，答案会全部报错）

- 搜索函数返回时，记得是 `i-N+1`，而不是 `start-N+1`，经常手贱写错



##### 代码

```java
class Solution {
    public int strStr(String haystack, String needle) {
        KMP kmp = new KMP(needle);
        return kmp.search(haystack);
    }
}


class KMP{

    int[][] dp;
    int N;

    public KMP(String needle){
        
        char[] ss = needle.toCharArray();
        int n = ss.length;
        N = n;

        dp = new int[n][26];

        if(N>0){
            dp[0][ss[0]-'a'] = 1;
            int x = 0;
            for(int i=1; i<n; i++){
                for(int k=0; k<26; k++){
                    dp[i][k] = dp[x][k];
                }
                dp[i][ss[i]-'a'] = i+1;
                x = dp[x][ss[i]-'a'];
            }

        }

    }

    public int search(String haystack){
        if(N==0){
            return 0;
        }

        char[] hh = haystack.toCharArray();
        int m = hh.length;
        int start = 0;
        for(int i=0; i<m; i++){
            start = dp[start][hh[i]-'a'];
            if(start==N){
                return i-N+1;
            }
        }
        return -1;

    }


}

```



