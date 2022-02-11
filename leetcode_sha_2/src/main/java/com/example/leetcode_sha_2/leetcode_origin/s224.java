package com.example.leetcode_sha_2.leetcode_origin;

import java.util.ArrayDeque;

public class s224 {

    public static void main(String[] args) {
//        String s = "1 + 1";
        String s = "(1+(4+5+2)-3)+(6+8)";
        System.out.println(calculate(s));

    }

    public static int calculate(String s) {
        char[] ss = s.toCharArray();
        ArrayDeque<Character> q = new ArrayDeque<>();

        for(char c : ss){
            q.addLast(c);
        }

        return calculate(q);

    }

    public static int calculate(ArrayDeque<Character> q) {

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

    public static boolean isdigit(char c){
        if(c>='0' && c<='9'){
            return true;
        }
        return false;
    }

}
