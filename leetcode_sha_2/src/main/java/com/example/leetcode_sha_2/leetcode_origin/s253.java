package com.example.leetcode_sha_2.leetcode_origin;

import java.util.Arrays;

public class s253 {

    public static void main(String[] args) {
        int[][] meeting = new int[][]{{0,30},{5,10},{15,20}};
        System.out.println(minMeetingRooms(meeting));
        System.out.println(minMeetingRooms2(meeting));
    }

//    先说下题目，给你输入若干形如 [begin, end] 的区间，代表若干会议的开始时间和结束时间，请你计算至少需要申请多少间会议室

    // 返回需要申请的会议室数量
    public static int minMeetingRooms(int[][] meetings){
        int n = meetings.length;
        int[] begin = new int[n];
        int[] end = new int[n];

        for(int i=0; i<n; i++){
            begin[i] = meetings[i][0];
            end[i] = meetings[i][1];
        }

        Arrays.sort(begin);
        Arrays.sort(end);

        int i = 0;
        int j = 0;
        int count = 0;
        int res = 0;
        while (i<n && j<n) {
            if (begin[i]<end[j]) {
                count++;
                i++;
            }else {
                count--;
                j++;
            }
            res = Math.max(res, count);
        }

        return res;

    }


    public static int minMeetingRooms2(int[][] meetings){
        int n = meetings.length;
        int[] start = new int[n];
        int[] end = new int[n];

        for(int i=0; i<n; i++){
            start[i] = meetings[i][0];
            end[i] = meetings[i][1];
        }
        Arrays.sort(start);
        Arrays.sort(end);

        int i=0;
        int j=0;
        int count = 0;
        int res = 0;
        while(i<n && j<n){
            int now1 = start[i];
            int now2 = end[j];
            if(now1<now2){
                count++;
                res = Math.max(res, count);
                i++;
            }else{
                count--;
                j++;
            }
        }

        return res;

    }

}
