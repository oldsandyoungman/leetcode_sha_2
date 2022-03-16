package com.example.leetcode_sha_2.leetcode_origin;

public class s165 {

    public static void main(String[] args) {
        String version1 = "0.1";
        String version2 = "1.1";

        System.out.println(compareVersion(version1, version2));
    }

    public static int compareVersion(String version1, String version2) {
        String[] s1 = version1.split("\\.");
        String[] s2 = version2.split("\\.");
        int n1 = s1.length;
        int n2 = s2.length;
        int min_sha = Math.min(n1, n2);
        int index = 0;
        while(index<min_sha){

            int num1 = Integer.parseInt(s1[index]);
            int num2 = Integer.parseInt(s2[index]);

            if(num1>num2){
                return 1;
            }else if(num1<num2){
                return -1;
            }

            index++;


            // char[] ss1 = s1[index].toCharArray();
            // char[] ss2 = s2[index].toCharArray();

            // int i = 0;
            // int j = 0;
            // int nn1 = ss1.length;
            // int nn2 = ss2.length;

            // while(i<nn1 && ss1[i]=='0'){
            //     i++;
            // }
            // while(j<nn2 && ss2[j]=='0'){
            //     j++;
            // }

            // while(){

            // }

        }

        if(index==n1){
            while(index<n2){
                int num2 = Integer.parseInt(s2[index]);
                if(num2!=0){
                    return -1;
                }
                index++;
            }
            return 0;
        }else{
            while(index<n1){
                int num1 = Integer.parseInt(s1[index]);
                if(num1!=0){
                    return 1;
                }
                index++;
            }
            return 0;
        }

    }

}
