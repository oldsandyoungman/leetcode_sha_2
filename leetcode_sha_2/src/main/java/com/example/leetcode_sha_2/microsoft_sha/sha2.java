package com.example.leetcode_sha_2.microsoft_sha;

public class sha2 {

    public static void main(String[] args) {
        String[] E = new String[]{"039", "4", "14", "32", "", "34", "7"};
        System.out.println(solution(E));
    }


    public static int solution(String[] E) {
        // write your code in Java SE 8
        int n = E.length;
        int[][] matrix = new int[10][n];

        for(int i=0; i<n; i++){
            char[] t = E[i].toCharArray();
            for(char day : t){
                matrix[day-'0'][i]++;
            }
        }

        int res = 0;
        for(int i=0; i<10; i++){
            for(int j=i+1; j<10; j++){
                int tmp_res = 0;
                for(int k=0; k<n; k++){
                    if(matrix[i][k]+matrix[j][k]>0){
                        tmp_res++;
                    }
                }
                res = Math.max(tmp_res, res);
            }
        }

        return res;


    }


}
