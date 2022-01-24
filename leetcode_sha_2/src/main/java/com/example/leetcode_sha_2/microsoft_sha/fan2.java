package com.example.leetcode_sha_2.microsoft_sha;

import java.util.HashMap;
import java.util.HashSet;

public class fan2 {

    public static void main(String[] args) {
//        String[] src = {"...X..", "....XX", "..X..."};
        String[] src = {"...X.", ".x..X", "X...X", "..X.."};
        System.out.println(sum(src));
    }

    public static int sum(String[] src){
        int m = src.length;
        int n = src[0].length();
        res = 0;
        memo = new HashSet<>();
        if(src[0].charAt(0)=='X'){
            return 0;
        }
        memo.add("0,0,1");
        res++;
        traverse(src, 0, 0, 1, m, n);

        return res;
    }

    public static HashSet<String> memo;
    public static int res;
    public static int[][] direction = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    // 方向: 上:0, 右:1, 下:2, 左:3;
    public static void traverse(String[] src, int i, int j, int dir, int m, int n){
        int tar_row = i + direction[dir][0];
        int tar_col = j + direction[dir][1];
        if(tar_row<0 || tar_row>=m || tar_col<0 || tar_col>=n || src[tar_row].charAt(tar_col)=='X'){
            traverse(src, i, j, (dir+1)%4, m, n);
            return;
        }

        // 检查当前位置，是否重复
        String next = tar_row + "," + tar_col + "," + dir;
//        String now = i + "," + j + "," + dir;
        if(memo.contains(next)){
            return;
        }
        memo.add(next);
        res++;
        traverse(src, tar_row, tar_col, dir, m, n);



    }



}
