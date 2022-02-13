package com.example.leetcode_sha_2.leetcode_origin;

import java.util.ArrayList;
import java.util.Arrays;

public class s986 {

    public static void main(String[] args) {
        int[][] fl = {{0,2},{5,10},{13,23},{24,25}};
        int[][] rl = {{1,5},{8,12},{15,24},{25,26}};
        System.out.println(Arrays.deepToString(intervalIntersection(fl, rl)));

    }

//    给定两个由一些 闭区间 组成的列表，firstList 和 secondList ，其中 firstList[i] = [starti, endi] 而 secondList[j] = [startj, endj] 。每个区间列表都是成对 不相交 的，并且 已经排序 。
//
//    返回这 两个区间列表的交集 。
//
//    形式上，闭区间 [a, b]（其中 a <= b）表示实数 x 的集合，而 a <= x <= b 。
//
//    两个闭区间的 交集 是一组实数，要么为空集，要么为闭区间。例如，[1, 3] 和 [2, 4] 的交集为 [2, 3] 。
//
//    来源：力扣（LeetCode）
//    链接：https://leetcode-cn.com/problems/interval-list-intersections
//    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。


    public static int[][] intervalIntersection(int[][] firstList, int[][] secondList) {

        int m = firstList.length;
        int n = secondList.length;

        int l1 = firstList[0][0];
        int l2 = secondList[0][0];
        int r1 = firstList[0][1];
        int r2 = secondList[0][1];

        int i = 0;
        int j = 0;

        ArrayList<int[]> ll = new ArrayList<>();

        while(i<m && j<n){

            l1 = firstList[i][0];
            l2 = secondList[i][0];
            r1 = firstList[j][1];
            r2 = secondList[j][1];

            if(r1<l2){
                i++;
                continue;
            }
            if(r2<l1){
                j++;
                continue;
            }

            if(r1>=l2 && r2>=l1){
                ll.add(new int[]{ Math.max(l1, l2), Math.min(r1, r2) });
                if(r2>r1){
                    i++;
                }else{
                    j++;
                }
            }

        }

        return ll.toArray(new int[0][0]);

    }

}
