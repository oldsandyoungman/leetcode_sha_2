很多题目还是一错再错，决定做个复盘，记录下自己哪里写错了



[TOC]

#### [514. 自由之路](https://leetcode-cn.com/problems/freedom-trail/)

> 电子游戏“辐射4”中，任务“通向自由”要求玩家到达名为“Freedom Trail Ring”的金属表盘，并使用表盘拼写特定关键词才能开门。
>
> 给定一个字符串 ring，表示刻在外环上的编码；给定另一个字符串 key，表示需要拼写的关键词。您需要算出能够拼写关键词中所有字符的最少步数。
>
> 最初，ring 的第一个字符与12:00方向对齐。您需要顺时针或逆时针旋转 ring 以使 key 的一个字符在 12:00 方向对齐，然后按下中心按钮，以此逐个拼写完 key 中的所有字符。
>
> 旋转 ring 拼出 key 字符 key[i] 的阶段中：
>
> 1. 您可以将 ring 顺时针或逆时针旋转一个位置，计为1步。旋转的最终目的是将字符串 ring 的一个字符与 12:00 方向对齐，并且这个字符必须等于字符 key[i] 。
> 2. 如果字符 key[i] 已经对齐到12:00方向，您需要按下中心按钮进行拼写，这也将算作 1 步。按完之后，您可以开始拼写 key 的下一个字符（下一阶段）, 直至完成所有拼写。
>
> 
>
> 提示：
>
> 1. ring 和 key 的字符串长度取值范围均为 1 至 100；
> 2. 两个字符串中都只有小写字符，并且均可能存在重复字符；
> 3. 字符串 key 一定可以由字符串 ring 旋转拼出。



##### 思路

动态规划的核心：选择+状态。



这道题的状态跟之前一些题目有点相似，就是当前所在位置+目标key



然后选择在这道题有所不同，虽然每次的选择看似就往左/往右，但是这个角度就等于回溯法了，没有递归的关系在里面。所以真正的选择，应该是遍历整个字符串后找到目标字符，到达每个目标字符才是选择

> 至于怎么选择，即每种选择的开销 = 到达目标字符的开销 + 目标字符到字符串结束的开销，再进行对比选择最小的即可



另外因为有很多的重复子树，所以需要额外的备忘录来记录



最后，这道题从底向上的思路好像不明显，因为base0开始推导并没有固定顺序，因此只能从上到下





##### 注意点

这道题特殊在只能用自上而下，因此平时还是多练练吧





##### 代码

```java
class Solution {
    public int findRotateSteps(String ring, String key) {
        int m = ring.length();
        int n = key.length();
        memo = new int[m][n];
        mm = new HashMap<>();
        char[] rr = ring.toCharArray();
        for(int i=0; i<rr.length; i++){
            mm.putIfAbsent(rr[i], new LinkedList<>());
            mm.get(rr[i]).addLast(i);
        }
        return traverse(ring, 0, key, 0);

    }

    int[][] memo;
    HashMap<Character, LinkedList<Integer>> mm;

    public int traverse(String ring, int ring_start, String key, int key_start){
        if(key_start==key.length()){
            return 0;
        }

        if(memo[ring_start][key_start]!=0){
            return memo[ring_start][key_start];
        }

        int m = ring.length();
        char target = key.charAt(key_start);
        int res = Integer.MAX_VALUE;

        for(int i : mm.get(target)){
            int delta = Math.abs(i - ring_start);
            delta = Math.min(delta, m-delta);
            int tmp_res = traverse(ring, i, key, key_start+1) + delta + 1;
            res = Math.min(res, tmp_res);
        }

        memo[ring_start][key_start] = res;

        return res;

    }


}
```
