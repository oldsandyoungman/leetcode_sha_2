package com.example.leetcode_sha_2.leetcode_origin;

import javax.print.DocFlavor;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class s51_no {

    public static void main(String[] args) {
        System.out.println(solveNQueens(4));
        System.out.println(solveNQueens(1));

        Solution51 s = new Solution51();
        System.out.println(s.solveNQueens(4));
        System.out.println("111");
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


//    public static List<List<String>> solveNQueens(int n) {
//        res = new ArrayList<>();
//        List<String> panel = new ArrayList<>();
//        backtrack(panel, 0, n);
//        return res;
//    }
//    public static List<List<String>> res;
//    // Q: 有棋子
//    // .: 没棋子
//    public static void backtrack(List<String> panel, int k, int n){
//        if (k==n){
//            res.add(new ArrayList<>(panel));
//            return;
//        }
//
//        for (int i = 0; i < n; i++) {
//
//            if (isValid(panel, k, i, n)){
//
//                StringBuilder sb = new StringBuilder();
//                sb.append(".".repeat(i));
//                sb.append('Q');
//                sb.append(".".repeat(Math.max(0, n - (i + 1))));
//
//                panel.add(sb.toString());
//
//                backtrack(panel, k+1, n);
//
//                panel.remove(panel.size()-1);
//            }
//
//        }
//
//    }
//
//    private static boolean isValid(List<String> panel, int k, int i, int n) {
//        for (int j = 0; j < k; j++) {
//            char cur = panel.get(j).charAt(i);
//            if (cur=='Q'){
//                return false;
//            }
//        }
//        int cur_l_col = i-1;
//        int cur_l_row = k-1;
//        while (cur_l_col>=0 && cur_l_row>=0){
//            char cur = panel.get(cur_l_row).charAt(cur_l_col);
//            if (cur=='Q'){
//                return false;
//            }
//            cur_l_row--;
//            cur_l_col--;
//        }
//
//        int cur_r_col = i+1;
//        int cur_r_row = k-1;
//        while (cur_r_col<n && cur_r_row>=0){
//            char cur = panel.get(cur_r_row).charAt(cur_r_col);
//            if (cur=='Q'){
//                return false;
//            }
//            cur_r_row--;
//            cur_r_col++;
//        }
//
//        return true;
//
//    }


////  只判断有没有的剪枝方法
//    public static boolean solveNQueens(int n) {
//        res = new ArrayList<>();
//        List<String> panel = new ArrayList<>();
//
//        return backtrack(panel, 0, n);
//    }
//    public static List<List<String>> res;
//    // Q: 有棋子
//    // .: 没棋子
//    public static boolean backtrack(List<String> panel, int k, int n){
//        if (k==n){
//            res.add(new ArrayList<>(panel));
//            return true;
//        }
//
//        for (int i = 0; i < n; i++) {
//
//            if (isValid(panel, k, i, n)){
//
//                StringBuilder sb = new StringBuilder();
//                sb.append(".".repeat(i));
//                sb.append('Q');
//                sb.append(".".repeat(Math.max(0, n - (i + 1))));
//
//                panel.add(sb.toString());
//
//                boolean tmp = backtrack(panel, k+1, n);
//
//                if (tmp) {
//                    return true;
//                }
//
//                panel.remove(panel.size()-1);
//            }
//
//        }
//
//        return false;
//
//    }
//
//    private static boolean isValid(List<String> panel, int k, int i, int n) {
//        for (int j = 0; j < k; j++) {
//            char cur = panel.get(j).charAt(i);
//            if (cur=='Q'){
//                return false;
//            }
//        }
//        int cur_l_col = i-1;
//        int cur_l_row = k-1;
//        while (cur_l_col>=0 && cur_l_row>=0){
//            char cur = panel.get(cur_l_row).charAt(cur_l_col);
//            if (cur=='Q'){
//                return false;
//            }
//            cur_l_row--;
//            cur_l_col--;
//        }
//
//        int cur_r_col = i+1;
//        int cur_r_row = k-1;
//        while (cur_r_col<n && cur_r_row>=0){
//            char cur = panel.get(cur_r_row).charAt(cur_r_col);
//            if (cur=='Q'){
//                return false;
//            }
//            cur_r_row--;
//            cur_r_col++;
//        }
//
//        return true;
//
//    }
//
//
//}



// 重新做一遍
//    public static List<List<String>> solveNQueens(int n) {
//        res = new ArrayList<>();
//        LinkedList<String> matrix = new LinkedList<>();
//
//        dfs(matrix, 0, n);
//
//        return res;
//
//    }
//
//    public static List<List<String>> res;
//
//    public static void dfs(LinkedList<String> matrix, int m, int n) {
//        if (m == n) {
//            res.add(new LinkedList<>(matrix));
//            return;
//        }
//
//        for (int i = 0; i < n; i++) {
//            if (isValid(matrix, m, i, n)) {
//                StringBuilder sb = new StringBuilder();
//                for (int ii = 0; ii < i; ii++) {
//                    sb.append('.');
//                }
//                sb.append('Q');
//                for (int ii = i + 1; ii < n; ii++) {
//                    sb.append('.');
//                }
//
//                matrix.addLast(sb.toString());
//                dfs(matrix, m + 1, n);
//                matrix.removeLast();
//
//            }
//
//        }
//
//    }
//
//    public static boolean isValid(LinkedList<String> matrix, int x, int y, int n) {
//        for (int i = 0; i < x; i++) {
//            if (matrix.get(i).charAt(y) == 'Q') {
//                return false;
//            }
//        }
//
//        int r = x - 1;
//        int c = y - 1;
//        while (r >= 0 && c >= 0) {
//            if (matrix.get(r).charAt(c) == 'Q') {
//                return false;
//            }
//            r--;
//            c--;
//        }
//
//        r = x - 1;
//        c = y + 1;
//        while (r >= 0 && c < n) {
//            if (matrix.get(r).charAt(c) == 'Q') {
//                return false;
//            }
//            r--;
//            c++;
//        }
//
//        return true;
//
//    }




// 重新写一遍如何剪枝
    public static List<String> solveNQueens(int n) {

        LinkedList<String> matrix = new LinkedList<>();

        dfs(matrix, 0, n);

        return res;

    }

    public static List<String> res;

    public static boolean dfs(LinkedList<String> matrix, int m, int n) {
        if (m == n) {
            res = new LinkedList<>(matrix);
            return true;
        }

        for (int i = 0; i < n; i++) {
            if (isValid(matrix, m, i, n)) {
                StringBuilder sb = new StringBuilder();
                for (int ii = 0; ii < i; ii++) {
                    sb.append('.');
                }
                sb.append('Q');
                for (int ii = i + 1; ii < n; ii++) {
                    sb.append('.');
                }

                matrix.addLast(sb.toString());
                if(dfs(matrix, m + 1, n)){
                    return true;
                }
                matrix.removeLast();

            }

        }

        return false;

    }

    public static boolean isValid(LinkedList<String> matrix, int x, int y, int n) {
        for (int i = 0; i < x; i++) {
            if (matrix.get(i).charAt(y) == 'Q') {
                return false;
            }
        }

        int r = x - 1;
        int c = y - 1;
        while (r >= 0 && c >= 0) {
            if (matrix.get(r).charAt(c) == 'Q') {
                return false;
            }
            r--;
            c--;
        }

        r = x - 1;
        c = y + 1;
        while (r >= 0 && c < n) {
            if (matrix.get(r).charAt(c) == 'Q') {
                return false;
            }
            r--;
            c++;
        }

        return true;

    }











}


class Solution51 {
    public List<List<String>> solveNQueens(int n) {
        res = new ArrayList<>();
        LinkedList<String> path = new LinkedList<>();
        dfs(path, 0, n);
        return res;
    }

    List<List<String>> res;

    public void dfs(LinkedList<String> path, int m, int n){
        if(m==n){
            res.add(new ArrayList<>(path));
            return;
        }

        for(int i=0; i<m; i++){

            if(isValid(path, m, i, n)){

                StringBuilder sb = new StringBuilder();
                for(int j=0; j<i; j++){
                    sb.append(".");
                }
                sb.append("Q");
                for(int j=i+1; j<n; j++){
                    sb.append(".");
                }

                path.addLast(sb.toString());
                dfs(path, m+1, n);
                path.removeLast();

            }

        }

    }

    public boolean isValid(LinkedList<String> path, int x, int y, int n){
        for(int i=0; i<x; i++){
            if(path.get(i).charAt(y)=='Q'){
                return false;
            }
        }

        int row = x-1;
        int col = y-1;

        while(row>=0 && col>=0){
            if(path.get(row).charAt(col)=='Q'){
                return false;
            }
            row--;
            col--;
        }

        row = x-1;
        col = y+1;

        while(row>=0 && col<n){
            if(path.get(row).charAt(col)=='Q'){
                return false;
            }
            row--;
            col++;
        }

        return true;

    }

}