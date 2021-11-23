package com.example.leetcode_sha_2.leetcode_origin;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

public class s752_no {

    public static void main(String[] args) {
//        String s = "123";
//        char[] chars = s.toCharArray();
//        String res = Arrays.toString(chars);
//        System.out.println(res);

        String[] deadends = {"0201","0101","0102","1212","2002"};
        String target = "0202";
        System.out.println(openLock(deadends, target));

    }

//    你有一个带有四个圆形拨轮的转盘锁。每个拨轮都有10个数字： '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' 。每个拨轮可以自由旋转：例如把 '9' 变为 '0'，'0' 变为 '9' 。每次旋转都只能旋转一个拨轮的一位数字。
//
//    锁的初始数字为 '0000' ，一个代表四个拨轮的数字的字符串。
//
//    列表 deadends 包含了一组死亡数字，一旦拨轮的数字和列表里的任何一个元素相同，这个锁将会被永久锁定，无法再被旋转。
//
//    字符串 target 代表可以解锁的数字，你需要给出解锁需要的最小旋转次数，如果无论如何不能解锁，返回 -1 。
//
//    来源：力扣（LeetCode）
//    链接：https://leetcode-cn.com/problems/open-the-lock
//    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

    public static int openLock(String[] deadends, String target) {

        if (target.equals("0000")){
            return 0;
        }

        HashSet<String> d = new HashSet<>();
        Collections.addAll(d, deadends);

        if (d.contains("0000")){
            return -1;
        }

        d.add("0000");

        ArrayDeque<String> q = new ArrayDeque<>();
        q.addLast("0000");

        int res = 0;

        while (!q.isEmpty()){

            int n = q.size();

            for (int i = 0; i < n; i++) {

                String cur = q.removeFirst();

                if (cur.equals(target)){
                    return res;
                }

                for (int j = 0; j < 4; j++) {
                    String up = up_sha(cur, j);
                    if (!d.contains(up)){
                        q.addLast(up);
                        d.add(up);
                    }
                    String down = down_sha(cur, j);
                    if (!d.contains(down)) {
                        q.addLast(down);
                        d.add(down);
                    }

                }

            }

            res++;

        }

        return -1;


    }


    public static String up_sha(String src, int x){
        char[] chars = src.toCharArray();
        char c = chars[x];
        if (c=='9'){
            chars[x] = '0';
        }else {
            chars[x] += 1;
        }
//        return chars.toString();
        return new String(chars);
    }

    public static String down_sha(String src, int x){
        char[] chars = src.toCharArray();
        char c = chars[x];
        if (c=='0'){
            chars[x] = '9';
        }else {
            chars[x] -= 1;
        }
//        return chars.toString();
        return new String(chars);
    }


}
