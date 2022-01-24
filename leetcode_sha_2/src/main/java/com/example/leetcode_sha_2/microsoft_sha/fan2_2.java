package com.example.leetcode_sha_2.microsoft_sha;

import java.util.HashSet;

public class fan2_2 {

    public static void main(String[] args) {
//        String[] src = {"...X..", "....XX", "..X..."};
//        String[] src = {"...X.", ".X..X", "X...X", "..X.."};
//        String[] src = {"....X..", "X......", ".....X.", "......."};
        String[] src = {"."};
        System.out.println(sum(src));
//        System.out.println("666");
    }

    // 全部用当前节点的版本
    public static int sum(String[] src){
        int m = src.length;
        int n = src[0].length();
        res = 0;
        memo = new HashSet<>();
        memo2 = new HashSet<>();
        if(src[0].charAt(0)=='X'){
            return 0;
        }
//        memo.add("0,0,1");
//        res++;
        traverse(src, 0, 1, 1, m, n);
        if(!memo2.contains("0,0")){
            res++;
        }
        return res;
    }

    public static HashSet<String> memo;
    public static HashSet<String> memo2;
    public static int res;
    public static int[][] direction = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    // 方向: 上:0, 右:1, 下:2, 左:3;
    public static void traverse(String[] src, int i, int j, int dir, int m, int n){

        if(i<0 || i>=m || j<0 || j>=n || src[i].charAt(j)=='X'){
            // 如果是向右碰壁，那要先向左走一个，再向下走一格
            // 向左走一格， (dir+2)%4
            // 向下走一格， (dir-1)%4
            // 合并就是， dir
            int next_row = i+direction[(dir+2)%4][0]+direction[(dir+1)%4][0];
            int next_col = j+direction[(dir+2)%4][1]+direction[(dir+1)%4][1];
            traverse(src, next_row, next_col, (dir+1)%4, m, n);
            return;
        }


        // 检查当前位置，是否重复
//        String next = tar_row + "," + tar_col + "," + dir;
        String now = i + "," + j + "," + dir;
        if(memo.contains(now)){
            return;
        }
        memo.add(now);
        String now2 = i + "," + j;
        if(!memo2.contains(now2)){
            memo2.add(now2);
            res++;
        }

        int tar_row = i + direction[dir][0];
        int tar_col = j + direction[dir][1];
        traverse(src, tar_row, tar_col, dir, m, n);



    }



}
