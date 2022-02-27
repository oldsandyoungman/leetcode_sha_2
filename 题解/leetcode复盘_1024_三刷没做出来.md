很多题目还是一错再错，决定做个复盘，记录下自己哪里写错了



[TOC]

#### [1024. 视频拼接](https://leetcode-cn.com/problems/video-stitching/)

> 你将会获得一系列视频片段，这些片段来自于一项持续时长为 time 秒的体育赛事。这些片段可能有所重叠，也可能长度不一。
>
> 使用数组 clips 描述所有的视频片段，其中 clips[i] = [starti, endi] 表示：某个视频片段开始于 starti 并于 endi 结束。
>
> 甚至可以对这些片段自由地再剪辑：
> 
> 例如，片段 [0, 7] 可以剪切成 [0, 1] + [1, 3] + [3, 7] 三部分。
>我们需要将这些片段进行再剪辑，并将剪辑后的内容拼接成覆盖整个运动过程的片段（[0, time]）。返回所需片段的最小数目，如果无法完成该任务，则返回 -1 。
> 
>
> 
>**提示：**
> 
>- `1 <= clips.length <= 100`
> - `0 <= starti <= endi <= 100`
> - `1 <= time <= 100`



##### 思路

区间题目，之前总结了说就两种排序方法：

1. 起点升序排序，起点相等终点降序排序
2. 终点升序排序

这个题第一种主流方法就能做，然后根据两个区间的相对位置关系再细化



##### 注意点

- 初始化的end，先设置为0，配合下面第二条，防止起点就不从0开始的情况

- 最外层的循环除了不越界以外，还得加个跟内部一样的判断条件

  ```java
  while(i<n && clips[i][0]<=end){
      
  }
  ```

- 继续第二点，除了防止一开始就不从0开始以外，如果有中间的断层（例如，[0,1]，[3,4]），也是在外层的while断开，因此最外层的while有双重功效



##### 代码

1. 东哥的标准方法

```java
class Solution {
    public int videoStitching(int[][] clips, int T) {
        if (T == 0) return 0;
        // 按起点升序排列，起点相同的降序排列
        // PS：其实起点相同的不用降序排列也可以，不过我觉得这样更清晰
        Arrays.sort(clips, (a, b) -> {
            if (a[0] == b[0]) {
                return b[1] - a[1];
            }
            return a[0] - b[0];
        });
        // 记录选择的短视频个数
        int res = 0;

        int curEnd = 0, nextEnd = 0;
        int i = 0, n = clips.length;
        while (i < n && clips[i][0] <= curEnd) {
            // 在第 res 个视频的区间内贪心选择下一个视频
            while (i < n && clips[i][0] <= curEnd) {
                nextEnd = Math.max(nextEnd, clips[i][1]);
                i++;
            }
            // 找到下一个视频，更新 curEnd
            res++;
            curEnd = nextEnd;
            if (curEnd >= T) {
                // 已经可以拼出区间 [0, T]
                return res;
            }
        }
        // 无法连续拼出区间 [0, T]
        return -1;
    }
}

```

2. 自己写的垃圾方法

```java
class Solution {
    public int videoStitching(int[][] clips, int time) {
        Arrays.sort(clips, (o1, o2) -> {
            if(o1[0]==o2[0]){
                return Integer.compare(o2[1], o1[1]);
            }else{
                return Integer.compare(o1[0], o2[0]);
            }
        });

        int start = clips[0][0];
        int end = clips[0][1];
        int count = 1;
        int n = clips.length;
        int next_end = -1;
        int i = 1;
        if(start!=0){
            return -1;
        }
        if(end>=time){
            return 1;
        }

        while(i<n){
            next_end = -1;
            while(i<n && clips[i][0]<=end){
                next_end = Math.max(next_end, clips[i][1]);
                i++;
            }
            if(next_end==-1){
                return -1;
            }
            count++;
            end = next_end;
            if(end>=time){
                return count;
            }

        }

        return -1;

        // for(int i=1; i<n; i++){
        //     if(end>=clips[i][1]){
        //         continue;
        //     }

        //     if(end<clips[i][0]){
        //         return -1;
        //     }

        //     count++;
        //     end = clips[i][1];

        // }

        // return end==time?count:-1;


    }
}
```

