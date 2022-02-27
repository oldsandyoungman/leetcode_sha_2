很多题目还是一错再错，决定做个复盘，记录下自己哪里写错了



[TOC]

#### [380. O(1) 时间插入、删除和获取随机元素](https://leetcode-cn.com/problems/insert-delete-getrandom-o1/)

> 实现RandomizedSet 类：
>
> RandomizedSet() 初始化 RandomizedSet 对象
> bool insert(int val) 当元素 val 不存在时，向集合中插入该项，并返回 true ；否则，返回 false 。
> bool remove(int val) 当元素 val 存在时，从集合中移除该项，并返回 true ；否则，返回 false 。
> int getRandom() 随机返回现有集合中的一项（测试用例保证调用此方法时集合中至少存在一个元素）。每个元素应该有 相同的概率 被返回。
> 你必须实现类的所有函数，并满足每个函数的 平均 时间复杂度为 O(1) 。
>
> 
>
> 提示：
>
> -231 <= val <= 231 - 1
> 最多调用 insert、remove 和 getRandom 函数 2 * 105 次
> 在调用 getRandom 方法时，数据结构中 至少存在一个 元素。



##### 思路

O(1)时间添加元素，减去元素，虽然都可以用HashMap，但是在HashMap的基础上随机选择元素，就不好搞了（因为键是数值，值是下标，不好random）



同时，对于数组来说，只是在末尾增减元素，能保证O(1)时间，因此，删除中间元素，需要先交换到末尾，再删除。



在此基础上，为了随机选取元素，需要额外添加HashMap来记录数值和下标的对应关系



##### 注意点

- 在删除元素中，记得一定先添加HashMap，再删除HashMap，不然有些例子会报错

  ```java
  r.insert(0);
  r.remove(0); // 这一步中如果先删除再添加，那么就会把<0,0>又加回去，所以不行
  r.insert(0); // 这一步会返回false，而不是true
  ```

  



##### 代码

1. 动态规划

```java
class RandomizedSet {

    HashMap<Integer, Integer> valToIndex;
    int count;
    int[] nums;
    Random r;

    public RandomizedSet() {
        valToIndex = new HashMap<>();
        count = 0;
        nums = new int[200000];
        r = new Random();
    }
    
    public boolean insert(int val) {
        if(valToIndex.containsKey(val)){
            return false;
        }
        nums[count] = val;
        valToIndex.put(val, count);
        count++;
        return true;
    }
    
    public boolean remove(int val) {
        if(!valToIndex.containsKey(val)){
            return false;
        }
        int index = valToIndex.get(val);
        int tail_num = nums[count-1];
        nums[index] = tail_num;
        valToIndex.put(tail_num, index);
        valToIndex.remove(val);
        count--;
        return true;
    }
    
    public int getRandom() {
        int index = r.nextInt(count);
        return nums[index];
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
```

