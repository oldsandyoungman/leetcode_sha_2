很多题目还是一错再错，决定做个复盘，记录下自己哪里写错了



[TOC]

#### [895. 最大频率栈](https://leetcode-cn.com/problems/maximum-frequency-stack/)

> 设计一个类似堆栈的数据结构，将元素推入堆栈，并从堆栈中弹出出现频率最高的元素。
>
> 实现 FreqStack 类:
>
> - FreqStack() 构造一个空的堆栈。
> - void push(int val) 将一个整数 val 压入栈顶。
> - int pop() 删除并返回堆栈中出现频率最高的元素。
>  - 如果出现频率最高的元素不只一个，则移除并返回最接近栈顶的元素。
> 
>
> 
>**提示：**
> 
>- `0 <= val <= 109`
> - `push` 和 `pop` 的操作数不大于 `2 * 104`。
> - 输入保证在调用 `pop` 之前堆栈中至少有一个元素。





##### 思路

- 因为要弹出频率最大的元素，所以得有 int maxFre 来记录最大的频率

- 因为要根据最大频率来弹出元素，所以得有一个 `fre-val` 的映射表，来找到对应的 val 值；而因为相同频率要返回最后加入的（最新的）那个，所以要有先后顺序，所以映射表的键值对是`<Integer, ArrayDeque<Integer>>`
- 因为多次加入值要更新频次，所以也得来一个 `val-fre` 映射表





##### 注意点

- 同一个值更新频次后， `val-fre` 固然要更新，但是 `fre-val` 其实并不需要删除原来的值，因为当你pop一次该 val 后，还是得用原来的fre，所以不如在添加时都留着原来的频次
- 这里的fre其实不利于接，fre换成count可能更好接受，即某个val在当前容器中的个数



##### 代码

```java
class FreqStack {

    int maxFre;
    HashMap<Integer, Integer> val_fre;
    HashMap<Integer, ArrayDeque<Integer>> fre_val;

    public FreqStack() {
        maxFre = 0;
        val_fre = new HashMap<>();
        fre_val = new HashMap<>();
    }
    
    public void push(int val) {
        int fre = val_fre.getOrDefault(val, 0);
        // if(fre>0){
        //     fre_val.get(fre).remove(val);
        // }
        fre++;
        val_fre.put(val, fre);
        fre_val.putIfAbsent(fre, new ArrayDeque<>());
        fre_val.get(fre).addLast(val);
        maxFre = Math.max(maxFre, fre);
    }
    
    public int pop() {
        ArrayDeque<Integer> cur = fre_val.get(maxFre);
        int val = cur.removeLast();
        val_fre.put(val, maxFre-1);
        if(cur.isEmpty()){
            maxFre--;
        }
        return val;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */
```

