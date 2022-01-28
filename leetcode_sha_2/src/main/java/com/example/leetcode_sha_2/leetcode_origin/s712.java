package com.example.leetcode_sha_2.leetcode_origin;

public class s712 {

    public static void main(String[] args) {
        String s1 = "a";
        String s2 = "b";
        System.out.println(minimumDeleteSum(s1, s2));
    }

    public static int minimumDeleteSum(String s1, String s2) {
        char[] t1 = s1.toCharArray();
        char[] t2 = s2.toCharArray();

        int n1 = t1.length;
        int n2 = t2.length;

        int[][] dp = new int[n1+1][n2+1];

        for(int i=1; i<=n1; i++){
            dp[i][0] = dp[i-1][0] + t1[i-1];
        }
        for(int j=1; j<=n2; j++){
            dp[0][j] = dp[0][j-1] + t2[j-1];
        }


        for(int i=1; i<=n1; i++){
            for(int j=1; j<=n2; j++){
                if(t1[i-1]==t2[j-1]){
                    dp[i][j] = dp[i-1][j-1];
                }else{
                    dp[i][j] = Math.min(dp[i-1][j]+t1[i-1], dp[i][j-1]+t2[j-1]);
                }
            }
        }

        return dp[n1][n2];
    }

}
