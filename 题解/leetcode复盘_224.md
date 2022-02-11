很多题目还是一错再错，决定做个复盘，记录下自己哪里写错了



[TOC]

#### [224. 基本计算器](https://leetcode-cn.com/problems/basic-calculator/)

> 给你一个字符串表达式 `s` ，请你实现一个基本计算器来计算并返回它的值。
>
> 
>
> **提示：**
>
> - `1 <= s.length <= 3 * 105`
> - `s` 由数字、`'+'`、`'-'`、`'('`、`')'`、和 `' '` 组成
> - `s` 表示一个有效的表达式



##### 思路

最大的框架是栈，最开始栈的数据结构引入也是类似的问题，框架大致如下：

> 以符号为划分，将每个部分结果存入栈中，最后累加即可

之后再进行系列细化：

1. 如果遇到乘除法，先将栈顶元素取出，与当前元素计算，再将新的结果压入栈中
2. 如果遇到空格，直接跳过
3. 如果遇到括号，那么利用递归的思想，重新调用该函数处理之后的结果；



##### 注意点

1. 对于递归，除了遇到左括号重新调用外，遇到右括号，直接进入计算栈内和的过程
2. 每次的 `if` 判断，并不是一旦进入第一个之后就不再判断，而是要接着判断，这样就不会漏掉 `结尾` 处没把当前的 `num` 放入栈中
3. 对于右括号的 `if` ，一定要放到 `符号或结尾` 的 `if` 后面，不然当前的 `num` 就不会计算在内



##### 代码

```java
class Solution {
    public int calculate(String s) {
        char[] ss = s.toCharArray();
        ArrayDeque<Character> q = new ArrayDeque<>();

        for(char c : ss){
            q.addLast(c);
        }

        return calculate(q);        

    }

    public int calculate(ArrayDeque<Character> q) {

        ArrayDeque<Integer> res = new ArrayDeque<>();
        char sign = '+';
        int num = 0;
        
        while(!q.isEmpty()){
            char cur = q.removeFirst();
            if(isdigit(cur)){
                num = 10*num + (cur-'0');
                // continue;
            }
            if(cur=='('){
                num = calculate(q);
                // continue;
            }
            if((!isdigit(cur) && cur!=' ') || q.isEmpty()){
                int pre;
                switch(sign){
                    case '+':
                        res.addLast(num);
                        break;
                    case '-':
                        res.addLast(-num);
                        break;
                    case '*':
                        pre = res.removeLast();
                        res.addLast(pre*num);
                        break;
                    case '/':
                        pre = res.removeLast();
                        res.addLast(pre/num);
                }
                sign = cur;
                num = 0;
        
            }
            if(cur==')'){
                break;
            }
               
        }

        int result = 0;
        while(!res.isEmpty()){
            result += res.removeFirst();
        }

        return result;

    }

    public boolean isdigit(char c){
        if(c>='0' && c<='9'){
            return true;
        }
        return false;
    }

}
```

