package com.example.leetcode_sha_2.leetcode_origin;

import java.util.LinkedList;

public class s28 {

    public static void main(String[] args) {

//        String haystack = "mississippi";
//        String needle = "issip";

        String haystack = "hello";
        String needle = "ll";

        KMP kmp = new KMP(needle);

        KMP2 kmp2 = new KMP2(needle);

        KMP3 kmp3 = new KMP3(needle);

        System.out.println(kmp.search(haystack));
        System.out.println(kmp2.search(haystack));
        System.out.println(kmp3.search(haystack));
        System.out.println("1");


    }

//    实现 strStr() 函数。
//
//    给你两个字符串 haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串出现的第一个位置（下标从 0 开始）。如果不存在，则返回  -1 。
//
//             
//
//    说明：
//
//    当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
//
//    对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与 C 语言的 strstr() 以及 Java 的 indexOf() 定义相符
//
//    来源：力扣（LeetCode）
//    链接：https://leetcode-cn.com/problems/implement-strstr
//    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。




}

class KMP2{

    // dp[i][j]: 当前在状态i，如果遇到j字符，跳转到状态为dp[i][j]的位置
    int[][] dp;
    int N;

    public KMP2(String needle){
        int n = needle.length();
        N = n;
        char[] ss = needle.toCharArray();
        dp = new int[n][26];

        dp[0][ss[0]-'a'] = 1;

        int i = 1;
        int x = 0;
        while(i<n){
            for(int k=1; k<26; k++){
                if(k==ss[i]-'a'){
                    dp[i][k] = i+1;
                }else{
                    dp[i][k] = dp[x][k];
                }
            }

            x = dp[x][ss[i]-'a'];

            i++;

        }



    }

    public int search(String haystack){
        if(N==0){
            return 0;
        }
        char[] ss = haystack.toCharArray();
        int n = ss.length;
        // ss中的位置
        int i = 0;
        // kmp的状态机的位置
        int j = 0;

        while(i<n){
            j = dp[j][ss[i]-'a'];
            if(j==N){
                return i-N+1;
            }
            i++;
        }
        return -1;

    }




}





class KMP {
    private int[][] dp;
    private String pat;

    public KMP(String pat) {
        this.pat = pat;
        int M = pat.length();
        // dp[状态][字符] = 下个状态
        dp = new int[M][26];
        // base case
        dp[0][pat.charAt(0)-'a'] = 1;
        // 影子状态 X 初始为 0
        int X = 0;
        // 构建状态转移图（稍改的更紧凑了）
        for (int j = 1; j < M; j++) {
            for (int c = 0; c < 26; c++)
                dp[j][c] = dp[X][c];
            dp[j][pat.charAt(j)-'a'] = j + 1;
            // 更新影子状态
            X = dp[X][pat.charAt(j)-'a'];
        }
    }

    public int search(String txt) {
        int M = pat.length();
        int N = txt.length();
        // pat 的初始态为 0
        int j = 0;
        for (int i = 0; i < N; i++) {
            // 计算 pat 的下一个状态
            j = dp[j][txt.charAt(i)-'a'];
            // 到达终止态，返回结果
            if (j == M) return i - M + 1;
        }
        // 没到达终止态，匹配失败
        return -1;
    }
}



class KMP3{

    int[][] dp;
    int N;

    public KMP3(String needle){

        char[] ss = needle.toCharArray();
        int n = ss.length;
        N = n;

        dp = new int[n][26];

        if(N>0){
            dp[0][ss[0]-'a'] = 1;
            int x = 0;
            for(int i=1; i<n; i++){
                for(int k=0; k<26; k++){
                    dp[i][k] = dp[x][k];
                }
                dp[i][ss[i]-'a'] = i+1;
                x = dp[x][ss[i]-'a'];
            }

        }

    }

    public int search(String haystack){
        if(N==0){
            return 0;
        }

        char[] hh = haystack.toCharArray();
        int m = hh.length;
        int start = 0;
        for(int i=0; i<m; i++){
            start = dp[start][hh[i]-'a'];
            if(start==N){
                return i-N+1;
            }
        }
        return -1;

    }


}
