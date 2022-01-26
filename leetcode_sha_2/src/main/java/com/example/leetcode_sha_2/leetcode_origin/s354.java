package com.example.leetcode_sha_2.leetcode_origin;

import java.util.Arrays;

public class s354 {

    public static void main(String[] args) {
        int[][] envelops = {{4,5},{4,6},{6,7},{2,3},{1,1},{1,1}};
        System.out.println(maxEnvelopes(envelops));
    }

//    给你一个二维整数数组 envelopes ，其中 envelopes[i] = [wi, hi] ，表示第 i 个信封的宽度和高度。
//
//    当另一个信封的宽度和高度都比这个信封大的时候，这个信封就可以放进另一个信封里，如同俄罗斯套娃一样。
//
//    请计算 最多能有多少个 信封能组成一组“俄罗斯套娃”信封（即可以把一个信封放到另一个信封里面）。
//
//    注意：不允许旋转信封。
//
//    来源：力扣（LeetCode）
//    链接：https://leetcode-cn.com/problems/russian-doll-envelopes
//    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。


    public static int maxEnvelopes(int[][] envelopes) {
        int n = envelopes.length;
        Arrays.sort(envelopes, (o1, o2) -> {
            if(o1[0]==o2[0]){
                return Integer.compare(o2[1], o1[1]);
            }else{
                return Integer.compare(o1[0], o2[0]);
            }
        });

        // 最长递增子序列
        //// 动态规划方法
        // int[] dp =  new int[n];
        // Arrays.fill(dp, 1);
        // for(int i=1; i<n; i++){
        //     for(int j=0; j<i; j++){
        //         if(envelopes[j][1]<envelopes[i][1]){
        //             dp[i] = Math.max(dp[i], dp[j]+1);
        //         }
        //     }
        // }

        // int res = 1;
        // for(int i=0; i<n; i++){
        //     res = Math.max(res, dp[i]);
        // }
        // return res;

        //// patience game 方法
        int[] top = new int[n];
        int piles = 0;

        for(int i=0; i<n; i++){
            int tar = envelopes[i][1];
            int left = 0;
            int right = piles - 1;
            while(left<=right){
                int mid = left + (right-left)/2;
                if(top[mid]<tar){
                    left = mid + 1;
                }else{
                    right = mid -1;
                }
            }
            if(left>=piles){
                piles++;
            }
            top[left] = tar;
        }

        return piles;

    }

}
