很多题目还是一错再错，决定做个复盘，记录下自己哪里写错了



[TOC]

#### [652. 寻找重复的子树](https://leetcode-cn.com/problems/find-duplicate-subtrees/)


> 给定一棵二叉树 root，返回所有重复的子树。
>
> 对于同一类的重复子树，你只需要返回其中任意一棵的根结点即可。
>
> 如果两棵树具有相同的结构和相同的结点值，则它们是重复的。
>
> 
>
> **提示：**
>
> - 树中的结点数在`[1,10^4]`范围内。
> - `-200 <= Node.val <= 200`



##### 思路

如果区分重复与否，就是将二叉树序列化后的结果进行比对

> - 序列化一定是有null的，不然无法通过一个串来恢复二叉树
> - 前序后序都可以恢复（因为能立即找到root节点），中序不可以，因为找不到root





##### 注意点

- 在做后面的 Leetcode297时，想到这个题能不能也用 Stringbuilder，但试下来并不对，后面想想也对，因为sb都是共用的，一直再加东西，肯定不一样

  > 而返回值是String类型的话，自底向上返回的时候，都是从null开始，所以不会一直在加，所以是对的







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

