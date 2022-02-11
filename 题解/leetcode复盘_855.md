很多题目还是一错再错，决定做个复盘，记录下自己哪里写错了



[TOC]

#### [855. 考场就座](https://leetcode-cn.com/problems/exam-room/)

> 在考场里，一排有 N 个座位，分别编号为 0, 1, 2, ..., N-1 。
>
> 当学生进入考场后，他必须坐在能够使他与离他最近的人之间的距离达到最大化的座位上。如果有多个这样的座位，他会坐在编号最小的座位上。(另外，如果考场里没有人，那么学生就坐在 0 号座位上。)
>
> 返回 ExamRoom(int N) 类，它有两个公开的函数：其中，函数 ExamRoom.seat() 会返回一个 int （整型数据），代表学生坐的位置；函数 ExamRoom.leave(int p) 代表坐在座位 p 上的学生现在离开了考场。每次调用 ExamRoom.leave(p) 时都保证有学生坐在座位 p 上。
>
> 
>
> 提示：
>
> 1 <= N <= 10^9
> 在所有的测试样例中 ExamRoom.seat() 和 ExamRoom.leave() 最多被调用 10^4 次。
> 保证在调用 ExamRoom.leave(p) 时有学生正坐在座位 p 上。



##### 思路

主要考察数据结构的选取，因为涉及到选距离最大的线段，所以肯定涉及到排序，所以数据结构肯定不是二叉堆（优先队列），就是平衡二叉搜索树。又因为这道题需要删除其中任意节点，所以只能用平衡二叉搜索树TreeSet

> 二叉堆（优先队列）只能删除堆顶元素，平衡二叉搜索树更全能

> 附：
>
> 二叉堆（优先队列），平衡二叉搜索树，插入时间复杂度都是O(logN)
>
> 平衡二叉搜索树的优势：能删除队列中任意元素
>
> 二叉堆（优先队列）的优势：更简单，底层由数组构成，运行效率会更高





##### 注意点

1. 线段的排序，虽然表面是线段长度即可，但是真正实操看的是坐下的人距离最近断点的距离，因此要用中点到两段的距离，而不是线段长度
2. 如果距离相等，需要取最小的那个，因此排序逻辑要稍微改写
3. 对于中点的距离函数，如果头或者尾是虚拟线段，要保证 `[-1, 0]和[N-1, N]` 在之后的距离判断中都不会被用来插入点，因此距离应该定义成 `a[1]和N-1-a[0]` 



##### 代码

```java
class ExamRoom {

    TreeSet<int[]> pq;
    HashMap<Integer, int[]> start;
    HashMap<Integer, int[]> end;
    int N;

    public ExamRoom(int n) {
        N = n;
        pq = new TreeSet<>((o1, o2) -> {
            int dis1 = distance(o1);
            int dis2 = distance(o2);
            if(dis1==dis2){
                return o2[0]-o1[0];
            }
            return dis1-dis2;
        });
        start = new HashMap<>();
        end = new HashMap<>();
        int[] dum = new int[]{-1, n};
        
        add_sha(dum);

    }
    
    public int seat() {
        int[] cur = pq.last();
        int mid;
        if(cur[0]==-1){
            mid =0;
        }else if(cur[1]==N){
            mid = N-1;
        }else{
            mid = cur[0] + (cur[1]-cur[0])/2;
        }

        remove_sha(cur);
        int[] left = new int[]{cur[0], mid};
        int[] right = new int[]{mid, cur[1]};
        add_sha(left);
        add_sha(right);

        return mid;

    }
    
    public void leave(int p) {
        int[] left = end.get(p);
        int[] right = start.get(p);

        remove_sha(left);
        remove_sha(right);
        add_sha(new int[]{left[0], right[1]});

    }

    public void remove_sha(int[] cur){
        pq.remove(cur);
        start.remove(cur[0]);
        end.remove(cur[1]);
    }

    public void add_sha(int[] cur){
        pq.add(cur);
        start.put(cur[0], cur);
        end.put(cur[1], cur);
    }

    public int distance(int[] a){
        if(a[0]==-1){
            return a[1];
        }
        if(a[1]==N){
            return N-1-a[0];
        }
        return (a[1]-a[0])/2;
    }

}

/**
 * Your ExamRoom object will be instantiated and called as such:
 * ExamRoom obj = new ExamRoom(n);
 * int param_1 = obj.seat();
 * obj.leave(p);
 */
```

