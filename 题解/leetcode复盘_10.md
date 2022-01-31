很多题目还是一错再错，决定做个复盘，记录下自己哪里写错了



[TOC]

#### [10. 正则表达式匹配](https://leetcode-cn.com/problems/regular-expression-matching/)

> 给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。
>
> '.' 匹配任意单个字符
> '*' 匹配零个或多个前面的那一个元素
> 所谓匹配，是要涵盖 整个 字符串 s的，而不是部分字符串。
>
> 
>
> 提示：
>
> - 1 <= s.length <= 20
> - 1 <= p.length <= 30
> - s 只含小写英文字母。
> - p 只含小写英文字母，以及字符 . 和 *。
> - 保证每次出现字符 * 时，前面都匹配到有效的字符



##### 思路

因为当前匹配完，就要递推到下一个：

>  如果s[i]==p[j]，那么之后就dp[i,j]==dp[i+1, j+1]）

所以肯定是动态规划



一步一步大框架出来：

1. 首先，排除两个通配符，最基本的递推结构肯定是这样的：

   ```java
   if(ss[i]==pp[j]){
       return dp(i+1, j+1);
   }else{
       return false;
   }
   ```

2. 加入一个通配符 ”.“ ，稍微改造下：

   ```java
   if(ss[i]==pp[j] || p[j]=='.'){
       return dp(i+1, j+1);
   }else{
       return false;
   }
   ```

3. 加入最后一个通配符，需要分类讨论一下：

   1. 如果当前字符匹配`ss[i]==pp[j]`，并且`p[j]=='*'`，那么其实无法判断这个`'*'`能匹配多少个，0个+多个都遍历取并：

      - 取0个：

        ```java
        return dp(i, j+2);
        ```

      - 取多个（即p串不变，s串往后推一个）

        ```java
        return dp(i+1, j);
        ```

   2. 如果当前字符匹配`ss[i]==pp[j]`，但`p[j]!='*'`，那么就是最正常的情况，直接两串都往后递推一个即可

      ```java
      return dp(i+1, j+1);
      ```

   3. 如果当前字符不匹配`ss[i]!=pp[j]`，但`p[j]=='*'`，那么这个`'*'`只能匹配0个

      ```java
      return dp(i, j+2);
      ```

   4. 如果当前字符不匹配`ss[i]!=pp[j]`，并且`p[j]!='*'`，那么直接返回false

      ```java
      return false;
      ```

      

至此，递推的大体流程完成



另外，base0同样也要细化一下：

- 一种很显然的base0，当p串为空时，如果s串非空，返回false；如果p串为空，返回true

- 另外一种base0，当s串为空p串不为空时，需要再遍历p串之后的所有字符，如果有奇数个，直接返回false；如果偶数位不为`'*'`，返回false。其它返回true



综上，动态规划的几大要素：base0，状态，选择，dp函数定义。针对这道题重述一下：

- base0：见上
- 状态：i，j两个指针的位置
- 选择：见上述的递推关系，不同状态的选择不同
- dp函数定义：s[i, ...]和p[j, ...]是否匹配





##### 注意点

在用备忘录记录时，东哥是用HashMap，这样的好处是如果之前没遍历过，那么就不包含，如果遍历过，boolean该是啥就是啥。换成数组记录的话，只能用int类型，因为有3种状态



##### 代码

```java
class Solution {
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        memo = new int[m][n];
        return traverse(s, 0, p, 0);
    }

    // 0:未遍历过
    // 1:true
    // -1:false
    int[][] memo;

    public boolean traverse(String s, int i, String p, int j){
        int m = s.length();
        int n = p.length();

        char[] ss = s.toCharArray();
        char[] pp = p.toCharArray();

        if(j==n){
            if(i==m){
                return true;
            }else{
                return false;
            }            
        }
        if(i==m){
            if((n-j)%2==1){
                return false;
            }
            for(int k=j+1;k<n;k+=2){
                if(pp[k]!='*'){
                    return false;
                }
            }
            return true;
        }

        if(memo[i][j]!=0){
            return memo[i][j]==1;
        }

        boolean res;

        if(ss[i]==pp[j] || pp[j]=='.'){

            if(j<n-1 && pp[j+1]=='*'){
                res = traverse(s, i+1, p, j) || traverse(s, i, p, j+2);
            }else{
                res = traverse(s, i+1, p, j+1);
            }

        }else{

            if(j<n-1 && pp[j+1]=='*'){
                res = traverse(s, i, p, j+2);                
            }else{
                res = false;
            }

        }

        if(res){
            memo[i][j] = 1;
            return true;
        }else{
            memo[i][j] = -1;
            return false;
        }

    }



}
```



