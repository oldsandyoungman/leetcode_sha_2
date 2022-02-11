很多题目还是一错再错，决定做个复盘，记录下自己哪里写错了



[TOC]

#### [241. 为运算表达式设计优先级](https://leetcode-cn.com/problems/different-ways-to-add-parentheses/)

> 给定一个含有数字和运算符的字符串，为表达式添加括号，改变其运算优先级以求出不同的结果。你需要给出所有可能的组合的结果。有效的运算符号包含 +, - 以及 * 。
>



##### 思路

分治算法的典型应用，在遇到一些看起来就很复杂的题目时，`回溯+动归+分治` 这 `递归` 三宝大概率会派上用途，在添加括号这类题目，就是典型的分治，只有分解到另外两个部分让它们自己算，才能破题



##### 注意点

分治也有 `base0 + 选择 + 函数定义`，本题的base0是在遍历以后res为空，别忘了写



##### 代码

```java
class Solution {
    public List<Integer> diffWaysToCompute(String expression) {
        memo = new HashMap<>();
        return traverse(expression);
    }
    
    public HashMap<String, List<Integer>> memo;
    
    public List<Integer> traverse(String expression){

        if(memo.containsKey(expression)){
            return memo.get(expression);
        }

        List<Integer> res = new ArrayList<>();

        int n = expression.length();
        for(int i=0; i<n; i++){
            char c = expression.charAt(i);
            if(c=='+' || c=='-' || c=='*'){
                List<Integer> left = traverse(expression.substring(0, i));
                List<Integer> right = traverse(expression.substring(i+1));
                
                for(int l : left){
                    for(int r : right){
                        if(c=='+'){
                            res.add(l+r);
                        }else if(c=='-'){
                            res.add(l-r);
                        }else{
                            res.add(l*r);
                        }
                    }
                }

            }
        }

        if(res.isEmpty()){
            res.add(Integer.parseInt(expression));
        }

        memo.put(expression, res);
        return res;
    }

}
```

