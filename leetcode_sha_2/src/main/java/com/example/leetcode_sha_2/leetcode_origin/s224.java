package com.example.leetcode_sha_2.leetcode_origin;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;

public class s224 {

    public static void main(String[] args) {
//        String s = "1 + 1";
        String s = "(1+(4+5+2)-3)+(6+8)";
        System.out.println(calculate(s));

        HashSet<String> memo;

        ArrayList<Integer> a = new ArrayList<>();
        ArrayDeque<Integer> b = new ArrayDeque<>();

    }

//    public static int calculate(String s) {
//        char[] ss = s.toCharArray();
//        ArrayDeque<Character> q = new ArrayDeque<>();
//
//        for(char c : ss){
//            q.addLast(c);
//        }
//
//        return calculate(q);
//
//    }
//
//    public static int calculate(ArrayDeque<Character> q) {
//
//        ArrayDeque<Integer> res = new ArrayDeque<>();
//        char sign = '+';
//        int num = 0;
//
//        while(!q.isEmpty()){
//            char cur = q.removeFirst();
//            if(isdigit(cur)){
//                num = 10*num + (cur-'0');
//                // continue;
//            }
//            if(cur=='('){
//                num = calculate(q);
//                // continue;
//            }
//            if((!isdigit(cur) && cur!=' ') || q.isEmpty()){
//                int pre;
//                switch(sign){
//                    case '+':
//                        res.addLast(num);
//                        break;
//                    case '-':
//                        res.addLast(-num);
//                        break;
//                    case '*':
//                        pre = res.removeLast();
//                        res.addLast(pre*num);
//                        break;
//                    case '/':
//                        pre = res.removeLast();
//                        res.addLast(pre/num);
//                }
//                sign = cur;
//                num = 0;
//
//            }
//
//            if(cur==')'){
//                break;
//            }
//
//        }
//
//        int result = 0;
//        while(!res.isEmpty()){
//            result += res.removeFirst();
//        }
//
//        return result;
//
//    }
//
//    public static boolean isdigit(char c){
//        if(c>='0' && c<='9'){
//            return true;
//        }
//        return false;
//    }






//    // 还是不能用while里纯if-else，因为确实有可能num本身为0
//    public static int calculate(String s) {
//        char[] ss = s.toCharArray();
//        LinkedList<Character> l = new LinkedList<>();
//        for(char tmp : ss){
//            if(tmp==' '){
//                continue;
//            }
//            l.addLast(tmp);
//        }
//        return calculate(l);
//    }
//
//
//    public static int calculate(LinkedList<Character> l) {
//
//        ArrayDeque<Integer> q = new ArrayDeque<>();
//
//        int num = 0;
//        char sign = '+';
//
//        while(!l.isEmpty()){
//            char cur = l.removeFirst();
//            if(isDigit(cur)){
//                num = 10*num + cur-'0';
//            }else{
//
//                if(cur=='('){
//                    num = calculate(l);
////                    q.addLast(cur_res);
//                    continue;
//                }
//
//                if(cur==')'){
//                    break;
//                }
//
//                switch(sign){
//                    case '+':
//                        q.addLast(num);
//                        break;
//                    case '-':
//                        q.addLast(-num);
//                        break;
//                    case '*':
//                        q.addLast(q.removeLast()*num);
//                        break;
//                    case '/':
//                        q.addLast(q.removeLast()/num);
//                }
//
//                num = 0;
//                sign = cur;
//
//            }
//
//        }
//
//        if(num!=0){
//            switch(sign){
//                case '+':
//                    q.addLast(num);
//                    break;
//                case '-':
//                    q.addLast(-num);
//                    break;
//                case '*':
//                    q.addLast(q.removeLast()*num);
//                    break;
//                case '/':
//                    q.addLast(q.removeLast()/num);
//            }
//        }
//
//        int res = 0;
//        while(!q.isEmpty()){
//            res += q.removeFirst();
//        }
//
//        return res;
//
//    }
//
//    public static boolean isDigit(char a){
//        return a>='0'&&a<='9';
//    }






    public static int calculate(String s) {
        char[] ss = s.toCharArray();
        LinkedList<Character> l = new LinkedList<>();
        for(char tmp : ss){
            if(tmp==' '){
                continue;
            }
            l.addLast(tmp);
        }
        return calculate(l);
    }


    public static int calculate(LinkedList<Character> l) {

        ArrayDeque<Integer> q = new ArrayDeque<>();

        int num = 0;
        char sign = '+';

        while(!l.isEmpty()){
            char cur = l.removeFirst();
            if(isDigit(cur)){
                num = 10*num + cur-'0';
            }

            if(!isDigit(cur) || l.isEmpty()){

                if(cur=='('){
                    num = calculate(l);

                }

                switch(sign){
                    case '+':
                        q.addLast(num);
                        break;
                    case '-':
                        q.addLast(-num);
                        break;
                    case '*':
                        q.addLast(q.removeLast()*num);
                        break;
                    case '/':
                        q.addLast(q.removeLast()/num);
                }

                num = 0;
                sign = cur;

                if(cur==')'){
                    break;
                }

            }

        }

        // if(num!=0){
        //     switch(sign){
        //         case '+':
        //             q.addLast(num);
        //             break;
        //         case '-':
        //             q.addLast(-num);
        //             break;
        //         case '*':
        //             q.addLast(q.removeLast()*num);
        //             break;
        //         case '/':
        //             q.addLast(q.removeLast()/num);
        //     }
        // }

        int res = 0;
        while(!q.isEmpty()){
            res += q.removeFirst();
        }

        return res;

    }

    public static boolean isDigit(char a){
        return a>='0'&&a<='9';
    }








}
