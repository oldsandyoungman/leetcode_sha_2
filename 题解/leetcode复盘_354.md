很多题目还是一错再错，决定做个复盘，记录下自己哪里写错了



[TOC]

#### [354. 俄罗斯套娃信封问题](https://leetcode-cn.com/problems/russian-doll-envelopes/)

> 给你一个二维整数数组 envelopes ，其中 envelopes[i] = [wi, hi] ，表示第 i 个信封的宽度和高度。
>
> 当另一个信封的宽度和高度都比这个信封大的时候，这个信封就可以放进另一个信封里，如同俄罗斯套娃一样。
>
> 请计算 最多能有多少个 信封能组成一组“俄罗斯套娃”信封（即可以把一个信封放到另一个信封里面）。
>
> 注意：不允许旋转信封。
>
> 
>
> **提示：**
>
> - `1 <= envelopes.length <= 5000`
> - `envelopes[i].length == 2`
> - `1 <= wi, hi <= 104`



##### 思路

最长递增子序列的扩展版，先给二维数组排序：

> 对于 {m, n} 和 {x, y}
>
> 如果m==x，就按从大到小排序n和y
>
> 如果m!=x，就直接按从小到大排序m和x



之后就是对于二维数组的第二列计算最长递增子序列即可

- 方法一，动态规划，复杂度O(N^2)，dp定义为以nums[i]结尾的最长递增子序列的最大值，每次计算dp[i]，都要遍历一遍dp[j]，j∈[0, i)，如果当前元素大于nums[j]，则更新一次dp[i]

- 方法二，patience sort，按照一个纸牌游戏的规则排序：

  > 遍历数组的每个元素，找到当前各堆中，大于当前元素的最左边的堆放入该元素，重复此操作即可

  最后的堆数即为答案



##### 注意点

- 对于方法1，每次更新只有当前元素nums[i]>nums[j]才需要更新
- 对于方法1，最后的答案还是要遍历一遍dp，而不是dp[n-1]
- 对于方法2，二分法判断的不是nums[mid]，而是top[mid]

##### 代码

1. 动态规划

```java
class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        int n = envelopes.length;
        Arrays.sort(envelopes, (o1, o2) -> {
            if(o1[0]==o2[0]){
                return Integer.compare(o2[1], o1[1]);
            }else{
                return Integer.compare(o1[0], o2[0]);
            }
        });

        // 最长递增子序列
        //// 动态规划方法
        int[] dp =  new int[n];
        Arrays.fill(dp, 1);
        for(int i=1; i<n; i++){
            for(int j=0; j<i; j++){
                if(envelopes[j][1]<envelopes[i][1]){
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
        }
        int res = 1;
        for(int i=0; i<n; i++){
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
```

2. patience sort方法

```java
class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        int n = envelopes.length;
        Arrays.sort(envelopes, (o1, o2) -> {
            if(o1[0]==o2[0]){
                return Integer.compare(o2[1], o1[1]);
            }else{
                return Integer.compare(o1[0], o2[0]);
            }
        });

        // 最长递增子序列
        //// patience game 方法
        int[] top = new int[n];
        int piles = 0;

        for(int i=0; i<n; i++){
            int tar = envelopes[i][1];
            int left = 0;
            int right = piles - 1;
            while(left<=right){
                int mid = left + (right-left)/2;
                if(top[mid]<tar){
                    left = mid + 1;
                }else{
                    right = mid -1;
                }
            }
            if(left>=piles){
                piles++;
            }
            top[left] = tar;
        }

        return piles;  

    }
}
```
