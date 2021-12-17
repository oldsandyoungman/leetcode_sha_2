package com.example.leetcode_sha_2.jian_zhi_offer;

import java.util.HashMap;
import java.util.Map;

public class s20 {

    public static void main(String[] args) {
//        String s = "0";
//        String s = "e";
//        String s = "1 ";
//        String s = ". ";
//        String s = "1 4";
        String s = "46.e3";
        System.out.println(isNumber(s));
    }

//    请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
//
//    数值（按顺序）可以分成以下几个部分：
//
//    若干空格
//    一个 小数 或者 整数
//（可选）一个 'e' 或 'E' ，后面跟着一个 整数
//            若干空格
//    小数（按顺序）可以分成以下几个部分：
//
//            （可选）一个符号字符（'+' 或 '-'）
//    下述格式之一：
//    至少一位数字，后面跟着一个点 '.'
//    至少一位数字，后面跟着一个点 '.' ，后面再跟着至少一位数字
//    一个点 '.' ，后面跟着至少一位数字
//    整数（按顺序）可以分成以下几个部分：
//
//            （可选）一个符号字符（'+' 或 '-'）
//    至少一位数字
//    部分数值列举如下：
//
//            ["+100", "5e2", "-123", "3.1416", "-1E-16", "0123"]
//    部分非数值列举如下：
//
//            ["12e", "1a3.14", "1.2.3", "+-5", "12e+5.4"]
//             
//
//    来源：力扣（LeetCode）
//    链接：https://leetcode-cn.com/problems/biao-shi-shu-zhi-de-zi-fu-chuan-lcof
//    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

    public static boolean isNumber(String s) {

        HashMap<Character, Integer>[] states = new HashMap[]{
                // 下面两个方式，用的时候要把object强制转换成int
//        HashMap[] states = new HashMap[]{
//        HashMap[] states = {
                // 0
                new HashMap<Character, Integer>(){
                    {
                        put(' ', 0);
                        put('s', 1);
                        put('d', 2);
                        put('.', 9);
                    }
                },
                // 1
                new HashMap<Character, Integer>(){
                    {
                        put('d', 2);
                        put('.', 9);
                    }
                },
                // 2
                new HashMap<Character, Integer>(){
                    {
                        put('d', 2);
                        put('.', 3);
                        put('e', 5);
                        put(' ', 8);
                    }
                },
                // 3
                new HashMap<Character, Integer>(){
                    {
                        put('d', 4);
                        put('e', 5);
                        put(' ', 8);
                    }
                },
                // 4
                new HashMap<Character, Integer>(){
                    {
                        put('d', 4);
                        put('e', 5);
                        put(' ', 8);
                    }
                },
                // 5
                new HashMap<Character, Integer>(){
                    {
                        put('s', 6);
                        put('d', 7);
                    }
                },
                // 6
                new HashMap<Character, Integer>(){
                    {
                        put('d', 7);
                    }
                },
                // 7
                new HashMap<Character, Integer>(){
                    {
                        put('d', 7);
                        put(' ', 8);
                    }
                },
                // 8
                new HashMap<Character, Integer>(){
                    {
                        put(' ', 10);
                    }
                },
                // 9
                new HashMap<Character, Integer>() {
                    {
                        put('d', 10);
                    }
                },
                // 10
                new HashMap<Character, Integer>(){
                    {
                        put('d', 10);
                        put('e', 5);
                        put(' ', 8);
                    }
                },


        };

        int n = s.length();
        char[] ss = s.toCharArray();
        char t;
        int p = 0;
        for(int i=0; i<n; i++){
            t = ss[i];
            if(t>='0' && t<='9'){
                t = 'd';
            }else if(t=='+' || t=='-'){
                t = 's';
            }else if(t=='e' || t=='E'){
                t = 'e';
            }else if(t!=' ' && t!='.'){
                return false;
            }

            if(!states[p].containsKey(t)){
                return false;
            }

            p = states[p].get(t);

        }

        return p==2 || p==3 || p==4 || p==7 || p==8 || p==10;


        // s = s.trim();
        // char[] ss = s.toCharArray();

        // int i = 0;
        // boolean signed = false;

        // if(ss[i]=='+' || ss[i]=='-'){
        //     signed = true;
        //     i++;
        // }

        // while(ss[i]>='0' && ss[i]<='9'){
        //     i++;
        // }

        // if(ss[i]=='.'){
        //     i++;
        // }

        // while(ss[i]>='0' && ss[i]<='9'){
        //     i++;
        // }

        // if(ss[i]=='e' || ss[i]=='E'){
        //     i++;
        // }

        // if(ss[i]=='+' || ss[i]=='-'){
        //     signed = true;
        //     i++;
        // }

        // while(ss[i]>='0' && ss[i]<='9'){
        //     i++;
        // }

    }

}
