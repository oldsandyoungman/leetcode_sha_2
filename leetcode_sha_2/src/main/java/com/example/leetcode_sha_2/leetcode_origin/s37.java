package com.example.leetcode_sha_2.leetcode_origin;

import java.util.Arrays;
import java.util.HashSet;

public class s37 {

    public static void main(String[] args) {
        char[][] borad = {
                {'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}
        };
        solveSudoku(borad);
        System.out.println(Arrays.deepToString(borad));

        StringBuilder sb = new StringBuilder();
        sb.append(1);
        sb.append(2);
        sb.deleteCharAt(sb.length()-1);
        System.out.println(sb.toString());

        int[][] dir = {{1, 3}, {0, 2, 4}, {1, 5}, {0, 4}, {1, 3, 5}, {2, 4}};


    }


//    编写一个程序，通过填充空格来解决数独问题。
//
//    数独的解法需 遵循如下规则：
//
//    数字 1-9 在每一行只能出现一次。
//    数字 1-9 在每一列只能出现一次。
//    数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。（请参考示例图）
//    数独部分空格内已填入了数字，空白格用 '.' 表示。
//
//    来源：力扣（LeetCode）
//    链接：https://leetcode-cn.com/problems/sudoku-solver
//    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。


    public static void solveSudoku(char[][] board) {

        System.out.println(dfs(board, 0, 0));
    }

    public static boolean dfs(char[][] board, int r, int c){

        if(r==9){
            return true;
        }

        if(c==9){
            return dfs(board, r+1, 0);
        }

        if(board[r][c]!='.'){
            return dfs(board, r, c+1);
        }

        for(char cur='1'; cur<='9'; cur++){

            if(isValid(board, r, c, cur)){
                board[r][c] = cur;
                if(dfs(board, r, c+1)){
                    return true;
                }
                board[r][c] = '.';
            }
        }

        return false;

    }

    public static boolean isValid(char[][] board, int r, int c, char cur){
        for(int i=0; i<9; i++){
            if(board[i][c]==cur && i!=r){
                return false;
            }
        }
        for(int i=0; i<9; i++){
            if(board[r][i]==cur && i!=c){
                return false;
            }
        }

        int base_r = r/3;
        base_r *= 3;
        int base_c = c/3;
        base_c *= 3;

        for(int i=0; i<9; i++){
            int rr = base_r + i/3;
            int cc = base_c + i%3;
            if(board[rr][cc]==cur && rr!=r && cc!=c){
                return false;
            }
        }

        return true;

    }

}
