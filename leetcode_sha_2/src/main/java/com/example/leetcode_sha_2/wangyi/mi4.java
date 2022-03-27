package com.example.leetcode_sha_2.wangyi;

import com.example.leetcode_sha_2.class_sha.UF;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class mi4 {

    public static void main(String[] args) {

        int m = 3;
        int n = 3;

        int[][] nums = {{1,1,2},{2,3,1},{3,2,2}};

        HashMap<Integer, List<int[]>> memo = new HashMap<>();

        memo.put(1, new ArrayList<>());
        memo.put(2, new ArrayList<>());
        memo.put(3, new ArrayList<>());

        memo.get(1).add(new int[]{0,0});
        memo.get(1).add(new int[]{0,1});
        memo.get(1).add(new int[]{1,2});

        memo.get(2).add(new int[]{0,2});
        memo.get(2).add(new int[]{1,0});
        memo.get(2).add(new int[]{2,1});
        memo.get(2).add(new int[]{2,2});

        memo.get(3).add(new int[]{1,1});
        memo.get(3).add(new int[]{2,0});

        boolean[][] isRed = new boolean[m][n];





        UF uf = new UF(m*n);



        int sum_red = 0;


        int[] target = {2,3};

        int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};

        for (int t : target) {

            for (int[] ints : memo.get(t)) {
                int x0 = ints[0];
                int y0 = ints[1];

                isRed[x0][y0] = true;

                sum_red++;

                for (int i = 0; i < 4; i++) {
                    int x = x0 + dir[i][0];
                    int y = y0 + dir[i][1];

                    if (x<0 || x>=m || y<0 || y>=n) {
                        continue;
                    }

                    if(isRed[x][y]) {
                        uf.union(x*m+y, x0*m+y0);

                    }


                }




            }

            System.out.println(sum_red - (m*n - uf.count()));

        }











    }



}
