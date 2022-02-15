package com.example.leetcode_sha_2.leetcode_origin;

import java.util.HashMap;

public class s651 {

    public static void main(String[] args) {
//        int n = 3;
        int n = 7;
        System.out.println(maxNum(n));
        System.out.println(maxNum4(n));
    }

//    假设你有一个特殊的键盘包含下面的按键︰
//    Key 1: (A)︰在屏幕上打印一个'A'。
//    Key 2: (ctrl-A)︰选中整个屏幕。
//    Key 3: (ctrl-c)∶复制选中区域到缓冲区。
//    Key 4: (ctr1-v)∶将缓冲区内容输出到上次输入的结束位置，并显示在屏幕上。
//
//    现在，你只可以按键Ⅳ次（使用上述四种按键)，请问屏幕上最多可以显示几个'A呢?


// 较为普通的方法

    public static int maxNum(int n){
        memo = new HashMap<>();
        return dp(n, 0, 0);

    }

    public static HashMap<String, Integer> memo;

    // dp(i, j, k): 剩余i次操作机会，屏幕已有j个，粘贴板有k个
    public static int dp(int i, int j, int k){
        if(i<=0){
            return j;
        }
        String cur = i + "," + j + "," + k;
        if(memo.containsKey(cur)){
            return memo.get(cur);
        }

        int res1 = dp(i-1, j+1, k);
        int res2 = dp(i-1, j+k, k);
        int res3 = dp(i-2, j, j);

        int res = Math.max(Math.max(res1, res2), res3);

        memo.put(cur, res);

        return res;

    }

// 比较巧妙的定义方法
//    public static int maxNum(int n){
//        int[] dp = new int[n+1];
//
//        // base0：dp[0] = 0;
//
//        for(int i=1; i<=n; i++){
//            dp[i] = dp[i-1] + 1;
//
//            for(int j=2; j<=i; j++){
//                dp[i] = Math.max(dp[i], dp[j-2]*(i-j+1));
//            }
//
//        }
//
//        return dp[n];
//
//    }



//    public static int maxNum3(int n){
//
//        int[] dp = new int[n+1];
//        // base: dp[0]=0;
//
//        for(int i=1; i<=n; i++){
//            int res = dp[i-1]+1;
//            for(int j=1; j<=i-2; j++){
//                res = Math.max(res, dp[j]*(i-j-1));
//            }
//            dp[i] = res;
//        }
//
//        return dp[n];
//
//    }


    public static int maxNum4(int n){

        return dp4(0, 0, n);

    }

    // 屏幕上有screen个，剪贴板有clip个，还有n次操作机会，最多能在屏幕上显示的字符个数
    public static int dp4(int screen, int clip, int n){
        if(n<=0){
            return screen;
        }

        // 直接按一个
        int res1 = dp4(screen+1, clip, n-1);
        // ctrl-v一下
        int res2 = dp4(screen+clip, clip, n-1);
        // ctrl-a，ctrl-c一下
        int res3 = dp4(screen, screen, n-2);

        int res = Math.max(Math.max(res1, res2), res3);

        return res;
    }

}
