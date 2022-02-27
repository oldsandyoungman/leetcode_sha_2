很多题目还是一错再错，决定做个复盘，记录下自己哪里写错了



[TOC]

#### [341. 扁平化嵌套列表迭代器](https://leetcode-cn.com/problems/flatten-nested-list-iterator/)

> 给你一个嵌套的整数列表 nestedList 。每个元素要么是一个整数，要么是一个列表；该列表的元素也可能是整数或者是其他列表。请你实现一个迭代器将其扁平化，使之能够遍历这个列表中的所有整数。
>
> 实现扁平迭代器类 NestedIterator ：
>
> - NestedIterator(List<NestedInteger> nestedList) 用嵌套列表 nestedList 初始化迭代器。
> - int next() 返回嵌套列表的下一个整数。
> - boolean hasNext() 如果仍然存在待迭代的整数，返回 true ；否则，返回 false 
>
> 你的代码将会用下述伪代码检测：
>
> ```
> initialize iterator with nestedList
> res = []
> while iterator.hasNext()
>     append iterator.next() to the end of res
> return res
> ```
>
> 如果 res 与预期的扁平化列表匹配，那么你的代码将会被判为正确。
>
> 
>
> **提示：**
>
> - `1 <= nestedList.length <= 500`
> - 嵌套列表中的整数值在范围 `[-106, 106]` 内



##### 思路

这种嵌套式的数据结构，一定要联想到多叉树，而多叉树的遍历，就要用到遍历的基本格式

```java
public void dfs(A a){
    // 到子节点了，终止
    if(a==xxx){
        // ...
        return;
    }
    for(A cur: a.getList()){
        traverse(cur);
    }
}
```

因此方法一，就是按照多叉树的遍历来做的



而为了实现惰性，即一开始初始化的时候不要全部搞出来，就要在hasNext()的时候才把list不断打平到第一个数是数字，这就是普通的循环方法，思路对了应该没啥问题







##### 注意点

- 方法一中，迭代器的写法要多熟悉

  ```java
  LinkedList<Integer> list = new LinkedList<>();
  Iterator<Integer> it = list.iterator();
  boolean a = it.hasNext();
  int a = it.next();
  ```

- 方法二中，一开始的list初始化，可以直接调用LinkedList的构造函数

  ```java
  public NestedIterator(List<NestedInteger> nestedList) {
          list = new LinkedList<>(nestedList);
      	// 这个方法略显多余
      	// list = new LinkedList<>();
          // for(NestedInteger cur: nestedList){
          //     list.add(cur);
          // }
      }
  ```

- 方法二中，hasNext()返回值是list是否为空

- 方法二中，数据结构用LinkedList比较好，因为会在队首查数据（ArrayList用时会明显偏高）



##### 代码

1. 多叉树的递归

```java
/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return empty list if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class NestedIterator implements Iterator<Integer> {

    public Iterator<Integer> it;

    public NestedIterator(List<NestedInteger> nestedList) {
        ArrayList<Integer> res = new ArrayList<>();
        for(NestedInteger cur : nestedList){
            traverse(cur, res);
        }

        it = res.iterator();

    }

    @Override
    public Integer next() {
        return it.next();
    }

    @Override
    public boolean hasNext() {
        return it.hasNext();
    }

    public void traverse(NestedInteger cur, ArrayList<Integer> res){
        if(cur.isInteger()){
            res.add(cur.getInteger());
            return;
        }

        for(NestedInteger tmp : cur.getList()){
            traverse(tmp, res);
        }

    }

}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */
```

2. 惰性方法

```java
/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return empty list if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class NestedIterator implements Iterator<Integer> {

    LinkedList<NestedInteger> list;

    public NestedIterator(List<NestedInteger> nestedList) {
        list = new LinkedList<>(nestedList);
        // for(NestedInteger cur: nestedList){
        //     list.add(cur);
        // }

    }

    @Override
    public Integer next() {
        return list.removeFirst().getInteger();
    }

    @Override
    public boolean hasNext() {
        
        while(!list.isEmpty() && !list.getFirst().isInteger()){
            NestedInteger fir = list.removeFirst();
            List<NestedInteger> fir_list = fir.getList();
            int n = fir_list.size();
            for(int i=n-1; i>=0; i--){
                list.addFirst(fir_list.get(i));
            }
        }

        return !list.isEmpty();

    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */
```

