package com.example.leetcode_sha_2.alibaba_sha;

import java.util.*;

public class sha2 {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        float[] memo = new float[12];
        for(int i=0; i<12; i++){
            String s = in.nextLine();
            String[] ss = s.split(":");
            int n = Integer.parseInt(ss[1]);
            s = in.nextLine();
            ss = s.split(" ");

            float count = 0;


            for (int j=0; j<n; j++){
                String[] tmp = ss[j].split(":");
                String res = tmp[1];
                float num = Float.parseFloat(res);
                count += num;
            }
            memo[i] = count;

        }

        float max = Float.MIN_VALUE;
        int max_index = 0;
        float min = Float.MAX_VALUE;
        int min_index = 0;

        for (int i = 0; i < 12; i++) {
            if (memo[i]>max) {
                max = memo[i];
                max_index = i;
            }
            if (memo[i]<min){
                min = memo[i];
                min_index = i;
            }
        }

        ;

        System.out.println("January:"+String.format("%.2f",memo));
        System.out.println("February:"+memo[1]);
        System.out.println("March:"+memo[2]);
        System.out.println("April:"+memo[3]);
        System.out.println("May:"+memo[4]);
        System.out.println("June:"+memo[5]);
        System.out.println("July:"+memo[6]);
        System.out.println("August:"+memo[7]);
        System.out.println("September:"+memo[8]);
        System.out.println("October:"+memo[9]);
        System.out.println("November:"+memo[10]);
        System.out.println("December:"+memo[11]);

        System.out.println(convert_sha(min_index) + " " + convert_sha(max_index));



    }

    public static String convert_sha(int i){
        if (i==0){
            return "January";
        }
        if (i==1){
            return "February";
        }
        if (i==2){
            return "March";
        }
        if (i==3){
            return "April";
        }
        if (i==4){
            return "May";
        }
        if (i==5){
            return "June";
        }
        if (i==6){
            return "July";
        }
        if (i==7){
            return "August";
        }
        if (i==8){
            return "September";
        }
        if (i==9){
            return "October";
        }
        if (i==10){
            return "November";
        }
        return "December";


    }

}
