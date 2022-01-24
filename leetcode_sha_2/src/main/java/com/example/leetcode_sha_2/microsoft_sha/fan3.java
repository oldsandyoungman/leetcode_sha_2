package com.example.leetcode_sha_2.microsoft_sha;

import java.util.Arrays;

public class fan3 {

    public static void main(String[] args) {
//        int[] H = {1, 1, 3};
//        int X = 1;
//        int Y = 1;

//        int[] H = {6, 5, 5, 4, 3};
//        int X = 8;
//        int Y = 9;


//        int[] H = {6, 5, 2, 1, 8};
//        int X = 17;
//        int Y = 5;

        int[] H = {5, 5, 4, 6};
        int X = 8;
        int Y = 8;

        System.out.println(maxNum(H, X, Y));
    }

    public static int maxNum(int[] H, int X, int Y){
        int n = H.length;
        res = 0;

        Arrays.sort(H);
        int l = 0;
        int r = n-1;
        while(l<r){
            int tmp = H[l];
            H[l] = H[r];
            H[r] = tmp;
            l++;
            r--;
        }
        backtrack(H, X, Y, 0, 0, n);
        return res;
    }

    public static int res;

    public static void backtrack(int[] H, int X, int Y, int start, int path, int n){
        if(start==n){
            res = Math.max(path, res);
            return;
        }

        // 选生产线A
        if(X>=H[start]){
            X -= H[start];
            path++;
            backtrack(H, X, Y, start+1, path, n);
            X += H[start];
            path--;
        }

        // 选生产线B
        if(Y>=H[start]){
            Y -= H[start];
            path++;
            backtrack(H, X, Y, start+1, path, n);
            Y += H[start];
            path--;
        }

        // 不选
        backtrack(H, X, Y, start+1, path, n);

    }

}
