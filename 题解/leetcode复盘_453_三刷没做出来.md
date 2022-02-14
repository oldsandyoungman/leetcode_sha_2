很多题目还是一错再错，决定做个复盘，记录下自己哪里写错了



[TOC]

#### [435. 无重叠区间](https://leetcode-cn.com/problems/non-overlapping-intervals/)

> 给定一个区间的集合 intervals ，其中 intervals[i] = [starti, endi] 。返回 需要移除区间的最小数量，使剩余区间互不重叠 。
>
> 
>
> 提示:
>
> 1 <= intervals.length <= 105
> intervals[i].length == 2
> -5 * 104 <= starti < endi <= 5 * 104



##### 思路

区间问题，暂时就看到两种排序思路（当然只用第一种排序也是可以做的，耗时稍长但能用）：

1. 起点升序排序，起点相等终点降序排序
2. 终点升序排序



这道题就用到了第二种排序思路，每次验证新的线段是否被end插入，插入的话下一个，没插入则计数+1，最后求的是不重叠的区间个数最大值



##### 注意点

- 如果用第一种方法，那么讨论三种相对关系，每种情况写明白更新情况就行
- 如果用第二种方法，记得这种思路是求的不重叠区间的最大数量



##### 代码

1. 第一种方法

```java
class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (o1, o2) -> {
            if(o1[0]==o2[0]){
                return Integer.compare(o2[1], o1[1]);
            }else{
                return Integer.compare(o1[0], o2[0]);
            }
        });

        int n = intervals.length;

        int start = intervals[0][0];
        int end = intervals[0][1];

        int res = 0;

        for(int i=1; i<n; i++){
            if(intervals[i][1]<=end){
                res++;
                end = intervals[i][1];
                continue;
            }
            

            if(intervals[i][0]>=end){
                start = intervals[i][0];
                end = intervals[i][1];
                continue;
            }

            // if(intervals[i][0]<end && intervals[i][1]>end){
            //     res++;
            //     // start = intervals[i][0];
            //     // end = intervals[i][1];
            //     continue;
            // }

            res++;

        }

        return res;


    }



}
```

2. 第二种方法

```java
class Solution {
    
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (o1, o2) -> {
            return Integer.compare(o1[1], o2[1]);
        });

        int n = intervals.length;
        int end = intervals[0][1];
        int count = 1;
        for(int i=1; i<n; i++){
            if(intervals[i][0]>=end){
                count++;
                end = intervals[i][1];
            }
        }

        return n - count;

    }

}
```
