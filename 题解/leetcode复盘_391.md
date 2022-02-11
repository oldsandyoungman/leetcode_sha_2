很多题目还是一错再错，决定做个复盘，记录下自己哪里写错了



[TOC]

#### [391. 完美矩形](https://leetcode-cn.com/problems/perfect-rectangle/)

> 给你一个数组 rectangles ，其中 rectangles[i] = [xi, yi, ai, bi] 表示一个坐标轴平行的矩形。这个矩形的左下顶点是 (xi, yi) ，右上顶点是 (ai, bi) 。
>
> 如果所有矩形一起精确覆盖了某个矩形区域，则返回 true ；否则，返回 false 。
>
> 
>
> 提示：
>
> 1 <= rectangles.length <= 2 * 104
>rectangles[i].length == 4
> -105 <= xi, yi, ai, bi <= 105



##### 思路

还是得有经验吧，不然确实想不到。两个破题点：

- 累加面积 == 外包矩形面积
- 顶点个数两两抵消后，只剩下外包矩形的四个点



##### 注意点

在用HashSet记录坐标时，不大好用数组，因为数组存进去是个地址，因此第一个 `int[] a = new int[]{1,2}` 存入后，你再新建第二个  `int[] b = new int[]{1,2}` ，`s.contains(b)` 一定是否 



所以保险起见，还是用String吧，毕竟String有 `equals()` 方法，两个对象也能相等



##### 代码

```java
class Solution {
    public boolean isRectangleCover(int[][] rectangles) {
        // 最外层矩阵坐标
        int xx1 = 100001;
        int yy1 = 100001;
        int xx2 = -100001;
        int yy2 = -100001;

        // 矩阵的面积累和
        int sum = 0;

        // 记录顶点
        HashSet<String> memo = new HashSet<>();

        for(int[] rec : rectangles){
            int x1 = rec[0];
            int y1 = rec[1];
            int x2 = rec[2];
            int y2 = rec[3];

            // 更新最外层矩阵的坐标
            xx1 = Math.min(xx1, x1);
            yy1 = Math.min(yy1, y1);
            xx2 = Math.max(xx2, x2);
            yy2 = Math.max(yy2, y2);
            
            // 更新各矩阵累和
            sum += (x2-x1)*(y2-y1);

            // 更新顶点坐标
            String tmp;
            tmp = x1 + "," + y1;
            if(memo.contains(tmp)){
                memo.remove(tmp);
            }else{
                memo.add(tmp);
            }
            tmp = x1 + "," + y2;
            if(memo.contains(tmp)){
                memo.remove(tmp);
            }else{
                memo.add(tmp);
            }
            tmp = x2 + "," + y1;
            if(memo.contains(tmp)){
                memo.remove(tmp);
            }else{
                memo.add(tmp);
            }
            tmp = x2 + "," + y2;
            if(memo.contains(tmp)){
                memo.remove(tmp);
            }else{
                memo.add(tmp);
            }

        }

        // 判断面积是否对头
        int target_sum = (xx2-xx1)*(yy2-yy1);
        if(target_sum!=sum){
            return false;
        }

        // 判断顶点坐标是否为4个
        if(memo.size()!=4){
            return false;
        }

        // 判断最外层的顶点坐标是否在memo内
        String tmp;
        tmp = xx1 + "," + yy1;
        if(!memo.contains(tmp)){
            return false;
        }
        tmp = xx1 + "," + yy2;
        if(!memo.contains(tmp)){
            return false;
        }
        tmp = xx2 + "," + yy1;
        if(!memo.contains(tmp)){
            return false;
        }
        tmp = xx2 + "," + yy2;
        if(!memo.contains(tmp)){
            return false;
        }

        return true;

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
