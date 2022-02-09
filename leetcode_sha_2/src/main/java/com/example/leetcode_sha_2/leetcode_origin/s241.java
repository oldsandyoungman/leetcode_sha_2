package com.example.leetcode_sha_2.leetcode_origin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class s241 {

    public static void main(String[] args) {
        String s = "2*3-4*5";
        System.out.println(diffWaysToCompute(s));
    }

//    给定一个含有数字和运算符的字符串，为表达式添加括号，改变其运算优先级以求出不同的结果。你需要给出所有可能的组合的结果。有效的运算符号包含 +, - 以及 * 。
//
//    来源：力扣（LeetCode）
//    链接：https://leetcode-cn.com/problems/different-ways-to-add-parentheses
//    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

    public static List<Integer> diffWaysToCompute(String expression) {
        memo = new HashMap<>();
        return traverse(expression);
    }

    public static HashMap<String, List<Integer>> memo;

    public static List<Integer> traverse(String expression){

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
