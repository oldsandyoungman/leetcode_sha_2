很多题目还是一错再错，决定做个复盘，记录下自己哪里写错了



[TOC]

#### [18. 四数之和](https://leetcode-cn.com/problems/4sum/)

> 给你一个由 n 个整数组成的数组 nums ，和一个目标值 target 。请你找出并返回满足下述全部条件且不重复的四元组 [nums[a], nums[b], nums[c], nums[d]] （若两个四元组元素一一对应，则认为两个四元组重复）：
>
> 0 <= a, b, c, d < n
> a、b、c 和 d 互不相同
> nums[a] + nums[b] + nums[c] + nums[d] == target
> 你可以按 任意顺序 返回答案 。
>
> 
>
> **提示：**
>
> - `1 <= nums.length <= 200`
> - `-109 <= nums[i] <= 109`
> - `-109 <= target <= 109`



##### 思路

思路应该比较清晰，就是有很多细节没注意到



##### 注意点

- k>2时的遍历，for循环要从start开始，而不是从0开始
- k>2时的遍历，每次结束时，同样要排除重复元素，别忘了



##### 代码

```java
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        return kSum(nums, 0, target, 4);
    }

    public List<List<Integer>> kSum(int[] nums, int start, int target, int k) {

        if(k>2){
            int n = nums.length;
            List<List<Integer>> res = new ArrayList<>();
            for(int i=start; i<n-k+1; ){
                int new_target = target-nums[i];
                List<List<Integer>> tmp = kSum(nums, i+1, new_target, k-1);
                for(List<Integer> cur : tmp){
                    cur.add(nums[i]);
                    res.add(cur);
                }
                i++;
                while(i<n-k+1 && nums[i]==target-new_target){
                    i++;
                }
            }

            return res;

        }else{

            int left = start;
            int right = nums.length-1;

            List<List<Integer>> res = new ArrayList<>();

            while(left<right){
                int l_num = nums[left];
                int r_num = nums[right];
                int sum = l_num + r_num;
                if(sum<target){
                    left++;
                    while(left<right && nums[left]==l_num){
                        left++;
                    }
                }else if(sum>target){
                    right--;
                    while(left<right && nums[right]==r_num){
                        right--;
                    }
                }else{
                    List<Integer> tmp = new ArrayList<>();
                    tmp.add(l_num);
                    tmp.add(r_num);
                    res.add(tmp);

                    left++;
                    while(left<right && nums[left]==l_num){
                        left++;
                    }
                    right--;
                    while(left<right && nums[right]==r_num){
                        right--;
                    }

                }
            }

            return res;
        }

    }

}
```



