很多题目还是一错再错，决定做个复盘，记录下自己哪里写错了



[TOC]

#### [710. 黑名单中的随机数](https://leetcode-cn.com/problems/random-pick-with-blacklist/)

> 给定一个整数 n 和一个 无重复 黑名单整数数组 blacklist 。设计一种算法，从 [0, n - 1] 范围内的任意整数中选取一个 未加入 黑名单 blacklist 的整数。任何在上述范围内且不在黑名单 blacklist 中的整数都应该有 同等的可能性 被返回。
>
> 优化你的算法，使它最小化调用语言 内置 随机函数的次数。
>
> 实现 Solution 类:
>
> Solution(int n, int[] blacklist) 初始化整数 n 和被加入黑名单 blacklist 的整数
> int pick() 返回一个范围为 [0, n - 1] 且不在黑名单 blacklist 中的随机整数
>
> 
>
> 提示:
>
> - 1 <= n <= 109
> - 0 <= blacklist.length <- min(105, n - 1)
> - 0 <= blacklist[i] < n
> - blacklist 中所有值都 不同
> - pick 最多被调用 2 * 104 次



##### 思路

其实自己的思路是对的，硬想的方法没啥问题

即对于黑名单的数，如果在后面就不动，如果在前面就换成后面一个非黑名单的数，之后调用的时候，判断HashMap是否存了这个值分别输出即可





##### 注意点

- 一开始在判断后面的数哪些不是黑名单时，自己用的是创建一个boolean[]数组记录的，但是如果黑名单只有一个数，但是很大，你却要开很多很多空间（或者只开后半部分的数组也行，后来实验了下，反而效率更高）



##### 代码

1. 只用HashMap来做

```java
class Solution {

    HashMap<Integer, Integer> memo;
    // int[] res;
    Random r = new Random();
    int new_n;

    public Solution(int n, int[] blacklist) {
        
        memo = new HashMap<>();
        r = new Random();

        int b_n = blacklist.length;
        new_n = n - b_n;



        // res = new int[new_n];
        // for(int i=0; i<new_n; i++){
        //     res[i] = i;
        // }

        // boolean[] bb = new boolean[n];

        for(int b : blacklist){
            if(b>=new_n){
                // bb[b] = true;
                memo.put(b, 666);
            }
        }

        int index = n-1;

        for(int b : blacklist){
            if(b<new_n){
                while(memo.containsKey(index)){
                    index--;
                }
                // res[b] = index;
                memo.put(b, index);
                index--;
            }
        }

    }
    
    public int pick() {
        int tmp = r.nextInt(new_n);
        if(memo.containsKey(tmp)){
            return memo.get(tmp);
        }
        return tmp;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(n, blacklist);
 * int param_1 = obj.pick();
 */
```

2. 额外用 boolean[] 数组来记录哪些黑名单数在后半部分

```java
class Solution {

    HashMap<Integer, Integer> memo;
    // int[] res;
    Random r = new Random();
    int new_n;

    public Solution(int n, int[] blacklist) {
        
        memo = new HashMap<>();
        r = new Random();

        int b_n = blacklist.length;
        new_n = n - b_n;



        // res = new int[new_n];
        // for(int i=0; i<new_n; i++){
        //     res[i] = i;
        // }

        boolean[] bb = new boolean[b_n];

        for(int b : blacklist){
            if(b>=new_n){
                bb[b-new_n] = true;
                // memo.put(b, 666);
            }
        }

        int index = n-1;

        for(int b : blacklist){
            if(b<new_n){
                while(bb[index-new_n]){
                    index--;
                }
                // res[b] = index;
                memo.put(b, index);
                index--;
            }
        }

    }
    
    public int pick() {
        int tmp = r.nextInt(new_n);
        if(memo.containsKey(tmp)){
            return memo.get(tmp);
        }
        return tmp;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(n, blacklist);
 * int param_1 = obj.pick();
 */
```

