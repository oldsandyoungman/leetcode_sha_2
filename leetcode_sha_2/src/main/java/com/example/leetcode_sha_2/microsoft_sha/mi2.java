package com.example.leetcode_sha_2.microsoft_sha;

public class mi2 {

    public static void main(String[] args) {
        String aa = "dBacaAA";
        String bb = "caBdaaA";
        System.out.println(cal(aa, bb));
    }

    public static int cal(String A, String B){
        char[] aa = A.toCharArray();
        char[] bb = B.toCharArray();
        int n = bb.length;

        int res = 0;

        for(int i=0; i<n; i++){
            int[] memo = new int[52];
            for(int j=i; j<n; j++){
                memo[aa[j]-'A']++;
                memo[bb[j]-'A']--;

                boolean flag = true;
                for(int k=0; k<52; k++){
                    if(memo[k]!=0){
                        flag = false;
                        break;
                    }
                }
                if(flag){
                    res++;
                }

            }

        }

        return res;

    }

}
