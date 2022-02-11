很多题目还是一错再错，决定做个复盘，记录下自己哪里写错了



[TOC]

#### [43. 字符串相乘](https://leetcode-cn.com/problems/multiply-strings/)

> 给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
>
> 注意：不能使用任何内置的 BigInteger 库或直接将输入转换为整数。
>
> 
>
> 提示：
>
> 1 <= num1.length, num2.length <= 200
> num1 和 num2 只能由数字组成。
> num1 和 num2 都不包含任何前导零，除了数字0本身。



##### 思路

即模拟手写乘法算数，分解成 `个位数*个位数` ，再累加。其中关键点在于，`第i位*第j位` 在结果的`第i+j位` 和 `第i+j+1位` ，这个理解了就好做了



##### 注意点

其实没有必要将 `第i位*第j位` 先分别加到`res[i+j]和res[i+j+1]`，再判断 `res[i+j]和res[i+j+1]`是否有溢出再进位，而是直接先和 `res[i+j+1]` 累加，更新到 `res[i+j]和res[i+j+1]`上，即使有溢出，可以再下一次的 `res[i+j-1]和res[i+j]` 上处理干净，不必担心

> 注：
>
> `res[i+j]和res[i+j+1]`更新的代码稍有不同，因为你是先累加了 `res[i+j+1]` 再更新，所以 `res[i+j+1]` 上应该是  `=` 而非 `+=`



##### 代码

```java
class Solution {
    public String multiply(String num1, String num2) {
        char[] s1 = num1.toCharArray();
        char[] s2 = num2.toCharArray();

        int n1 = s1.length;
        int n2 = s2.length;
        int[] res = new int[n1+n2];

        for(int i=n1-1; i>=0; i--){
            for(int j=n2-1; j>=0; j--){
                // int t1 = s1[i] - '0';
                // int t2 = s2[j] - '0';
                // int tmp = t1*t2;
                // res[i+j] += tmp/10;
                // res[i+j+1] += tmp%10;
                // if(res[i+j+1]>9){
                //     res[i+j]++;
                //     res[i+j+1] -= 10;
                // }
                // if(res[i+j]>9){
                //     res[i+j-1]++;
                //     res[i+j] -= 10;
                // }


                int t1 = s1[i] - '0';
                int t2 = s2[j] - '0';
                int tmp = t1*t2 + res[i+j+1];
                res[i+j] += tmp/10;
                res[i+j+1] = tmp%10;

                

            }
        }

        int i=0;
        while(i<n1+n2 && res[i]==0){
            i++;
        }

        StringBuilder sb = new StringBuilder();
        for(;i<n1+n2;i++){
            sb.append(res[i]);
        }
        
        return sb.length()==0?"0":sb.toString();

    }
}
```



