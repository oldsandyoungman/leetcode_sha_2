package com.example.leetcode_sha_2.leetcode_origin;

import javax.print.DocFlavor;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class s51_no {

    public static void main(String[] args) {
        System.out.println(solveNQueens(4));
        System.out.println(solveNQueens(1));
    }

//    n 皇后问题 研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
//
//    给你一个整数 n ，返回所有不同的 n 皇后问题 的解决方案。
//
//    每一种解法包含一个不同的 n 皇后问题 的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
//
//    来源：力扣（LeetCode）
//    链接：https://leetcode-cn.com/problems/n-queens
//    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

    public static List<List<String>> solveNQueens(int n) {
        res = new ArrayList<>();
        List<String> panel = new ArrayList<>();
        backtrack(panel, 0, n);
        return res;
    }
    public static List<List<String>> res;
    // Q: 有棋子
    // .: 没棋子
    public static void backtrack(List<String> panel, int k, int n){
        if (k==n){
            res.add(new ArrayList<>(panel));
            return;
        }

        for (int i = 0; i < n; i++) {

            if (isValid(panel, k, i, n)){

                StringBuilder sb = new StringBuilder();
                sb.append(".".repeat(i));
                sb.append('Q');
                sb.append(".".repeat(Math.max(0, n - (i + 1))));

                panel.add(sb.toString());

                backtrack(panel, k+1, n);

                panel.remove(panel.size()-1);
            }

        }

    }

    private static boolean isValid(List<String> panel, int k, int i, int n) {
        for (int j = 0; j < k; j++) {
            char cur = panel.get(j).charAt(i);
            if (cur=='Q'){
                return false;
            }
        }
        int cur_l_col = i-1;
        int cur_l_row = k-1;
        while (cur_l_col>=0 && cur_l_row>=0){
            char cur = panel.get(cur_l_row).charAt(cur_l_col);
            if (cur=='Q'){
                return false;
            }
            cur_l_row--;
            cur_l_col--;
        }

        int cur_r_col = i+1;
        int cur_r_row = k-1;
        while (cur_r_col<n && cur_r_row>=0){
            char cur = panel.get(cur_r_row).charAt(cur_r_col);
            if (cur=='Q'){
                return false;
            }
            cur_r_row--;
            cur_r_col++;
        }

        return true;

    }


}
