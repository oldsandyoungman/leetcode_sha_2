package com.example.leetcode_sha_2.leetcode_origin;

public class s415 {

    public static void main(String[] args) {

    }

//    给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和并同样以字符串形式返回。
//
//    你不能使用任何內建的用于处理大整数的库（比如 BigInteger）， 也不能直接将输入的字符串转换为整数形式。
//
//    来源：力扣（LeetCode）
//    链接：https://leetcode-cn.com/problems/add-strings
//    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。


    public static String addStrings(String num1, String num2) {
        char[] s1 = num1.toCharArray();
        char[] s2 = num2.toCharArray();
        int n1 = s1.length;
        int n2 = s2.length;
        int n = Math.max(n1, n2)+1;
        char[] res = new char[n];

        int i = n1-1;
        int j = n2-1;
        int k = n-1;
        int addition = 0;
        while(i>=0 && j>=0){
            int cur = s1[i] - '0' + s2[j] - '0' + addition;
            res[k] = (char)('0' + cur%10);
            addition = cur>=10?1:0;
            i--;
            j--;
            k--;
        }

        if(i<0){
            while(j>=0){
                int cur = s2[j] - '0' + addition;
                res[k] = (char)('0' + cur%10);
                addition = cur>=10?1:0;
                j--;
                k--;
            }

        }else{
            while(i>=0){
                int cur = s1[i] - '0' + addition;
                res[k] = (char)('0' + cur%10);
                addition = cur>=10?1:0;
                i--;
                k--;
            }

        }

        res[0] = (char)('0' + addition);

        String result = new String(res);

        if(res[0]=='0'){
            return result.substring(1);
        }else{
            return result;
        }

    }

}
