package com.example.leetcode_sha_2.microsoft_sha;

public class mi1 {

    public static void main(String[] args) {
//        String s = "><^v";
//        String s = "<<^<v>>";
        String s = "><><";

        System.out.println(cal(s));
    }

    public static int cal(String s){
        char[] ss = s.toCharArray();
        int n = ss.length;
        boolean pre = true;
        int res = 0;
        for(int i=0; i<n; i++){
            if(ss[i]=='>'){
                if(i==n-1){
                    res++;
                    continue;
                }
                pre = false;
                continue;
            }

            if(ss[i]=='<'){
                if(pre){
                    res++;
                }
                continue;
            }

            res++;
            pre = true;

        }

        return res;

    }

}
