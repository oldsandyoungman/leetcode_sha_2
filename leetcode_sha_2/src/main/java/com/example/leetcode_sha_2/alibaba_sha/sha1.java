package com.example.leetcode_sha_2.alibaba_sha;

import java.util.*;

public class sha1{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        List<Long> l = new ArrayList<>();

        char[] ss = s.toCharArray();
        long mod_sha = (long) (Math.pow(10,9)+7);
        int n = ss.length;
        int max = 2;
        for(int i=0; i<n; i++){
            if(ss[i]>='A'){
                max = Math.max(max, ss[i]-'A'+11);
            }else{
                max = Math.max(max, ss[i]-'0'+1);
            }
        }
        int index = 0;
        for(int i=max; i<=16; i++){
            long res = 0;
            long num = 1;
            for(int j=n-1; j>=0; j--){
                if(ss[j]>='A'){
                    res = (res+((ss[j]-'A'+10)*num)%mod_sha)%mod_sha;
                }else{
                    res = (res+((ss[j]-'0')*num)%mod_sha)%mod_sha;
                }
                num = (num*i)%mod_sha;
            }
            if (!l.contains(res)){
                l.add(res);
            }

        }
        Collections.sort(l);
        for (Long tmp : l) {
            System.out.println(tmp);
        }
    }
}