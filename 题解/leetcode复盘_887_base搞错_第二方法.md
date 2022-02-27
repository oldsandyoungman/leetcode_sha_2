很多题目还是一错再错，决定做个复盘，记录下自己哪里写错了



[TOC]

#### [887. 鸡蛋掉落](https://leetcode-cn.com/problems/super-egg-drop/)

> 给你 k 枚相同的鸡蛋，并可以使用一栋从第 1 层到第 n 层共有 n 层楼的建筑。
>
> 已知存在楼层 f ，满足 0 <= f <= n ，任何从 高于 f 的楼层落下的鸡蛋都会碎，从 f 楼层或比它低的楼层落下的鸡蛋都不会破。
>
> 每次操作，你可以取一枚没有碎的鸡蛋并把它从任一楼层 x 扔下（满足 1 <= x <= n）。如果鸡蛋碎了，你就不能再次使用它。如果某枚鸡蛋扔下后没有摔碎，则可以在之后的操作中 重复使用 这枚鸡蛋。
>
> 请你计算并返回要确定 f 确切的值 的 最小操作次数 是多少？
>
> 
>
> **提示：**
>
> - `1 <= k <= 100`
> - `1 <= n <= 104`



##### 思路

动态规划，两种定义方法

1. `dp[i][j]`：i个鸡蛋，j层楼，最少扔几次能遍历所有最坏情况

这个思路下，递推关系如下：

> `dp[i][j] = min( 1 + max(dp[i-1][k-1], dp[i][n-k]))`
>
> 即对于`dp[i][j]`，策略采取对第k层楼扔个鸡蛋试试，如果碎了说明在[1, k-1]层，即接下来操作`dp[i-1][k-1]`；如果没碎说明在[k+1, n]，即记下来操作`dp[i][n-k]`。取两者的最大值（考虑最坏情况）
>
> 最后遍历k，取其中的最小步骤

该方法复杂度如下：dp函数内部有个循环遍历，时间复杂度O(n)，一共有k*n个子问题，时间复杂度总共O(kn^2)

> 可以进行一次优化，观察到dp(k, n)，对于n来说是递增的，因此函数内的循环遍历，对于k来说，dp(i-1, k-1)是递增的，dp(i, n-k)是递减的
>
> - 上述递推关系是求两个函数所形成的的谷底
>
> 只要是有单调性，就可以用二分法降低一次复杂度具体代码如下
>
> ```java
> int left = 1;
> int right = n;
> 
> while(left<=right){
>     int mid = left + (right-left)/2;
>     int broken = dp(k-1, mid-1);
>     int not_broken = dp(k, n-mid);
>     if(not_broken>broken){
>         left = mid + 1;
>         res = Math.min(res, 1+not_broken);
>     }else{
>         right = mid - 1;
>         res = Math.min(res, 1+broken);
>     }
> }
> ```



2. `dp[i][j]`：i个鸡蛋，扔j次，最多能查看多少层楼的鸡蛋可碎程度

这个思路下，递推关系如下：

> `dp[i][j] = dp[i-1][j-1] + dp[i][j-1] + 1`
>
> 即对于这个`dp[i][j]`，我们观察该方案扔的第一次，不管是哪一层，反正之后要么碎，之后的策略就是下楼继续测，得到的楼层数就是`dp[i-1][j-1]`；要么不碎，之后的策略是上楼继续测，得到的楼层数就是`dp[i][j-1]`，加上当前层可得总的楼层数

该思路的时间复杂度就很低了，循环内部复杂度O(1)，子问题数量k*n，最终复杂度为O(kn)

> 其实整个还可以继续优化，因为`dp[i][j]`是随i, j单调递增的，所以还可以不用m++的线性搜索方法，而是二分查找，进一步降低复杂度到O(klogn)。但感觉这个方法当前列必须用到前一列的值，不大好二分搜，暂时码住

感觉自己虽然写出来了，但是这个思路终究是不好想，并且我没有真正理解，之后可以再看看吧





##### 注意点

- 因为本题的最高不碎的楼层f，是可以为0的（即我在一楼扔还是碎了，答案f为0），所以在思路一的递推中，第k层扔完不碎，之后的递归范围是[k+1, n]，即类比一开始的[1, n]，这样范围才不会重合覆盖
- 思路二中，从(1, 1)开始遍历，并且每次的判断都是`dp[k][j]`，而非`dp[i][j]`



> 2022.2.16
>
> 又做了一遍
>
> - 方法一手贱， `memo[k][m]!=0` 写成 `memo[k][m]<0` 
> - 方法二，base完全可以是0开始，即 `memo[0][i]=0` 和 `memo[i][0]=0`，不用从1开始





##### 代码

1. 思路一

```java
class Solution {
    public int superEggDrop(int k, int n) {
        memo = new int[k+1][n+1];

        return dp(k, n);
        
    }

    int[][] memo;

    public int dp(int k, int n){
        if(n==0){
            return 0;
        }
        if(k==1){
            return n;
        }

        if(memo[k][n]!=0){
            return memo[k][n];
        }

        int res = n;



        // for(int i=1; i<=n; i++){
        //     int tmp_res = 1 + Math.max(dp(k-1, i-1), dp(k, n-i));
        //     res = Math.min(res, tmp_res);
        // }

        int left = 1;
        int right = n;

        while(left<=right){
            int mid = left + (right-left)/2;
            int broken = dp(k-1, mid-1);
            int not_broken = dp(k, n-mid);
            if(not_broken>broken){
                left = mid + 1;
                res = Math.min(res, 1+not_broken);
            }else{
                right = mid - 1;
                res = Math.min(res, 1+broken);
            }
        }

        memo[k][n] = res;

        return res;

    }

}
```

2. 思路二

```java
class Solution {
    public int superEggDrop(int k, int n) {
        // dp[i][j]：i个鸡蛋，扔j次，最多能测多少楼
        int[][] dp = new int[k+1][n+1];

        // base0: dp[0][.]和dp[.][0]都是0
        // for(int i=0; i<=k; i++){
        //     dp[i][0] = 0;
        // }
        // for(int j=0; j<=n; j++){
        //     dp[0][j] = 0;
        // }

        int j = 0;
        while(dp[k][j]<n){
            j++;
            for(int i=1; i<=k; i++){
                dp[i][j] = dp[i-1][j-1] + dp[i][j-1] + 1;
            }
        }

        return j;


    }

    

}
```

