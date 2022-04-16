package com.example.leetcode_sha_2.wangyi_leihuo;

import java.util.Scanner;

public class sha1 {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int m = in.nextInt();
        int x = in.nextInt();
        int y = in.nextInt();

        int sum = 0;

        for(int i=1; i<=n; i++){
            for(int j=1; j<=m; j++){
                int cur = in.nextInt();
                if(i==x && y==y){
                    continue;
                }
                sum += cur;
            }
        }

        sum++;

        System.out.println(sum);

    }

}
