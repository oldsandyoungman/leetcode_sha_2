package com.example.leetcode_sha_2.jian_zhi_offer;

import java.util.ArrayList;
import java.util.Arrays;

public class s57_2_no {

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(findContinuousSequence(15)));
    }

//    输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。
//
//    序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。
//
//    来源：力扣（LeetCode）
//    链接：https://leetcode-cn.com/problems/he-wei-sde-lian-xu-zheng-shu-xu-lie-lcof
//    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。


    public static int[][] findContinuousSequence(int target) {

        int sum = 0;

        int left = 1;
        int right = 1;

        ArrayList<int[]> res = new ArrayList<>();

        while(right<=1+target/2){

            sum += right;

            right++;

            while(sum>=target){

                if(sum==target){
                    int[] tmp = new int[right-left];
                    for(int i=left; i<right; i++){
                        tmp[i-left] = i;
                    }
                    res.add(tmp);
                }

                sum -= left;
                left++;

            }

        }

//        int[][] sss = res.toArray(new int[0][]);
//
//        return sss;

        return res.toArray(new int[0][]);

    }

}
