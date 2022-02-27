很多题目还是一错再错，决定做个复盘，记录下自己哪里写错了



[TOC]

#### [316. 去除重复字母](https://leetcode-cn.com/problems/remove-duplicate-letters/)

> 给你一个字符串 `s` ，请你去除字符串中重复的字母，使得每个字母只出现一次。需保证 **返回结果的字典序最小**（要求不能打乱其他字符的相对位置）。
>
> 
>
> **提示：**
>
> - `1 <= s.length <= 104`
>- `s` 由小写英文字母组成



##### 思路

题目提炼下，一共三个要求：

- 不重复
- 按照原来顺序
- 字典序最小



因此分别得到以下的相关信息

- 为了不重复，因此建立一个 boolean[26] 数组，记录每个字符是否已经在字符串中
- 为了按照原来顺序，需要用栈的结构，这样能保证每次都是对队尾进行操作，无论是增加还是去除，都不会影响整体的先后顺序
- 需要用单调栈的思想，每次加入元素前，先排除队尾比它大的元素，这样就能稍微达成字典序最小的效果（当然，需要另外建立数组变量，记录队尾元素是否在之后还会再出现，如果不会再出现，那么就不能删除）







##### 注意点

- 循环过程中，别忘了最后对当前元素的boolean数组置true



##### 代码

```java
class Solution {
    public String removeDuplicateLetters(String s) {
        char[] ss = s.toCharArray();
        boolean[] inRes = new boolean[26];
        int[] count = new int[26];
        ArrayDeque<Character> q = new ArrayDeque<>();

        for(char cur : ss){
            count[cur-'a']++;
        }

        for(char cur : ss){
            count[cur-'a']--;

            if(inRes[cur-'a']){
                continue;
            }

            while(!q.isEmpty() && q.getLast()>cur && count[q.getLast()-'a']>0){
                char tmp = q.removeLast();
                inRes[tmp-'a'] = false;
            }

            q.addLast(cur);
            inRes[cur-'a'] = true;

        }

        StringBuilder sb = new StringBuilder();
        while(!q.isEmpty()){
            sb.append(q.removeFirst());
        }

        return sb.toString();

    }
}
```

