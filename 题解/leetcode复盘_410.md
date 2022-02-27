很多题目还是一错再错，决定做个复盘，记录下自己哪里写错了



[TOC]

#### [410. 分割数组的最大值](https://leetcode-cn.com/problems/split-array-largest-sum/)

> 给定一个非负整数数组 `nums` 和一个整数 `m` ，你需要将这个数组分成 `m` 个非空的连续子数组。
>
> 设计一个算法使得这 `m` 个子数组各自和的最大值最小。
>
> 
>
> 提示：
>
> 1 <= nums.length <= 1000
> 0 <= nums[i] <= 106
> 1 <= m <= min(50, nums.length)



##### 思路

这种反过来想问题的方式，自己还是不大敏感，还需要多加练习



问给定划分次数，求划分后的和最大的最小，即给定和最大，反过来求m的最大值







##### 注意点

给定最大值求最大划分次数时

- 记得res初始化为1（至少有一组）

- 超过最大值时，sum是更新为num，而不是0



##### 代码

```java
class Solution {
    public int splitArray(int[] nums, int m) {
        int sum = 0;
        int max = 0;
        for(int num : nums){
            sum += num;
            max = Math.max(max, num);
        }

        int left = max;
        int right = sum;

        while(left<=right){
            int mid = left + (right-left)/2;
            if(given_max_cal_m(nums, mid)>m){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }

        return left;

    }

    public int given_max_cal_m(int[] nums, int max){
        int sum = 0;
        int res = 1;
        for(int num : nums){
            sum += num;
            if(sum>max){
                res++;
                sum = num;
            }
        }
        return res;
    }
}
```

