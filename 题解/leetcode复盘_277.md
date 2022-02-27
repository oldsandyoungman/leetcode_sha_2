很多题目还是一错再错，决定做个复盘，记录下自己哪里写错了



[TOC]

#### [277. 搜索名人](https://leetcode-cn.com/problems/find-the-celebrity/)

> 假设你是一个专业的狗仔，参加了一个 n 人派对，其中每个人被从 0 到 n - 1 标号。在这个派对人群当中可能存在一位 “名人”。所谓 “名人” 的定义是：其他所有 n - 1 个人都认识他/她，而他/她并不认识其他任何人。
>
> 现在你想要确认这个 “名人” 是谁，或者确定这里没有 “名人”。而你唯一能做的就是问诸如 “A 你好呀，请问你认不认识 B呀？” 的问题，以确定 A 是否认识 B。你需要在（渐近意义上）尽可能少的问题内来确定这位 “名人” 是谁（或者确定这里没有 “名人”）。
>
> 在本题中，你可以使用辅助函数 bool knows(a, b) 获取到 A 是否认识 B。请你来实现一个函数 int findCelebrity(n)。
>
> 派对最多只会有一个 “名人” 参加。若 “名人” 存在，请返回他/她的编号；若 “名人” 不存在，请返回 -1。



##### 思路

任意取两个人，四种相互关系总是可以确定至少有一个人不是名人，因此不断取两人排除一人，最后能得到唯一可能的名人，再遍历检验下就行



##### 注意点

- 最后一定要检验！！！
- 其实有时候可以排除两人，所以判断条件里的 `||` 我是觉得可以写成 `&&`



##### 代码

1. 队列版本

```java
public int findCelebrity2(int n) {
    if(n<=1){
        return 0;
    }
    LinkedList<Integer> l = new LinkedList<>();
    for(int i=0; i<n; i++){
        l.addLast(i);
    }

    while(l.size()>1){
        int a = l.removeFirst();
        int b = l.removeFirst();

        boolean a_knows_b = knows(a, b);
        boolean b_knows_a = knows(b, a);

        if(a_knows_b && !b_knows_a){
            l.addFirst(b);
        }
        if(!a_knows_b && b_knows_a){
            l.addFirst(a);
        }
    }

    int res = l.removeFirst();

    for(int i=0; i<n; i++){
        if(i!=res){
            if(knows(res, i) || !knows(i, res)){
                return -1;
            }
        }
    }

    return res;

}

private boolean knows(int can, int other) {
    return true;
}
```

2. 数字版本

```java
public int findCelebrity3(int n) {
    if(n<=1){
        return 0;
    }
    int can = 0;
    int other = 1;

    while(other<n){
        if(knows(can, other) && !knows(other, can)){
            can = other;
        }
        other++;
    }

    for(int i=0; i<n; i++){
        if(i!=can){
            if(knows(can, i) || !knows(i, can)){
                return -1;
            }
        }
    }

    return can;

}

private boolean knows(int can, int other) {
    return true;
}
```

