很多题目还是一错再错，决定做个复盘，记录下自己哪里写错了



[TOC]

#### [969. 煎饼排序](https://leetcode-cn.com/problems/pancake-sorting/)

> 给你一个整数数组 arr ，请使用 煎饼翻转 完成对数组的排序。
>
> 一次煎饼翻转的执行过程如下：
>
> 选择一个整数 k ，1 <= k <= arr.length
> 反转子数组 arr[0...k-1]（下标从 0 开始）
> 例如，arr = [3,2,1,4] ，选择 k = 3 进行一次煎饼翻转，反转子数组 [3,2,1] ，得到 arr = [1,2,3,4] 。
>
> 以数组形式返回能使 arr 有序的煎饼翻转操作所对应的 k 值序列。任何将数组排序且翻转次数在 10 * arr.length 范围内的有效答案都将被判断为正确。
>
> 
>
> 提示：
>
> 1 <= arr.length <= 100
> 1 <= arr[i] <= arr.length
> arr 中的所有整数互不相同（即，arr 是从 1 到 arr.length 整数的一个排列）



##### 思路

这类题目，一定要想办法找到递归的办法（有点类似那个三个柱子，想办法从小到大撂到一个柱子上）

如何慢慢减小规模？想办法把最后一个弄好，即最大的放到最后面，这样就能递归解决n-1个烙饼问题

如果将最大的放到最后呢，即找到前n个中最大的那个，然后翻转到第一个，再整体翻转到最后一个

这样思路就明确了

> 递归的思考过程里，不能影响已经解决好的结果，比如在弄好最大的第n个饼，之后的操作就不能翻转第n个饼（比如找最大值的过程，前n-1个里面找就行）



##### 注意点

- 答案要返回的是1~n，而不是0~n-1



##### 代码

```java
public List<Integer> pancakeSort(int[] arr) {
        res = new ArrayList<>();
        pancakeSort(arr, arr.length-1);
        return res;
    }

    List<Integer> res;

    public void pancakeSort(int[] arr, int k) {
        if(k==0){
            return;
        }

        int max = 0;
        int index = -1;
        for(int i=0; i<=k; i++){
            if(max<arr[i]){
                max = arr[i];
                index = i;
            }
        }

        // System.out.println(index);
        // System.out.println(k);

        if(index!=k){
            reorder(arr, index);
            reorder(arr, k);

            res.add(index+1);
            res.add(k+1);
        }
        
        pancakeSort(arr, k-1);

    }

    public void reorder(int[] arr, int k){
        int left = 0;
        int right = k;
        while(left<right){
            int tmp = arr[left];
            arr[left] = arr[right];
            arr[right] = tmp;
            left++;
            right--;
        }
    }
```

