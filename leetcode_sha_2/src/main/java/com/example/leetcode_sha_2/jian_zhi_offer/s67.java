package com.example.leetcode_sha_2.jian_zhi_offer;

public class s67 {

    public static void main(String[] args) {
//        String s = "-91283472332";
//        String s = "42";
        String s = "2147483646";
        System.out.println(strToInt(s));
    }

//    写一个函数 StrToInt，实现把字符串转换成整数这个功能。不能使用 atoi 或者其他类似的库函数。
//
//             
//
//    首先，该函数会根据需要丢弃无用的开头空格字符，直到寻找到第一个非空格的字符为止。
//
//    当我们寻找到的第一个非空字符为正或者负号时，则将该符号与之后面尽可能多的连续数字组合起来，作为该整数的正负号；假如第一个非空字符是数字，则直接将其与之后连续的数字字符组合起来，形成整数。
//
//    该字符串除了有效的整数部分之后也可能会存在多余的字符，这些字符可以被忽略，它们对于函数不应该造成影响。
//
//    注意：假如该字符串中的第一个非空格字符不是一个有效整数字符、字符串为空或字符串仅包含空白字符时，则你的函数不需要进行转换。
//
//    在任何情况下，若函数不能进行有效的转换时，请返回 0。
//
//    说明：
//
//    假设我们的环境只能存储 32 位大小的有符号整数，那么其数值范围为 [−231,  231 − 1]。如果数值超过这个范围，请返回  INT_MAX (231 − 1) 或 INT_MIN (−231) 。
//
//    来源：力扣（LeetCode）
//    链接：https://leetcode-cn.com/problems/ba-zi-fu-chuan-zhuan-huan-cheng-zheng-shu-lcof
//    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。


    public static int strToInt(String str) {
        str = str.trim();
        int n = str.length();
        if(n==0){
            return 0;
        }
        char[] ss = str.toCharArray();
        int start = 0;
        int bndry = Integer.MAX_VALUE/10;
        int sign = 1;
        if(ss[0]=='-' || ss[0]=='+'){
            if(ss[0]=='-'){
                sign = -1;
            }
            start++;
        }
        int sum = 0;
        for(int i=start; i<n; i++){
            if(ss[i]>='0' && ss[i]<='9'){
                if(sum>bndry || (sum==bndry&&ss[i]>'7')){
                    return sign==1?Integer.MAX_VALUE:Integer.MIN_VALUE;
                }
                sum = 10*sum + ss[i] - '0';
            }else{
                break;
            }
        }

        return sign*sum;


    }

//    public static int strToInt(String str) {
//        str = str.trim();
//        int n = str.length();
//        char[] ss = str.toCharArray();
//        int flag = 1;
//        long sum = 0;
//        int i = 0;
//        if(ss[i]=='+' || ss[i]=='-'){
//            if(ss[i]=='-'){
//                flag = -1;
//            }
//            i++;
//        }
//        while(i<n && ss[i]>='0' && ss[i]<='9'){
//            int cur = ss[i] - '0';
//            sum = 10*sum + cur;
//            i++;
//        }
//
//        long res = flag*sum;
//
//        if(res>Integer.MAX_VALUE){
//            return Integer.MAX_VALUE;
//        }
//        if(res<Integer.MIN_VALUE){
//            return Integer.MIN_VALUE;
//        }
//
//        return (int)res;
//
//    }

}
