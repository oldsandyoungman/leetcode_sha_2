package com.example.leetcode_sha_2.leetcode_origin;

import java.util.ArrayList;
import java.util.List;

public class s46 {

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3};
        System.out.println(permute(nums));
    }

//    给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。

    public static List<List<Integer>> permute(int[] nums) {
        res = new ArrayList<>();
        List<Integer> track = new ArrayList<>();
        backtrack(nums, track);
        return res;
    }
    public static List<List<Integer>> res;
    public static void backtrack(int[] nums, List<Integer> track){
        if (track.size()==nums.length){
            res.add(new ArrayList<>(track));
            return;
        }

        for (int num : nums) {
            if (!track.contains(num)){
                track.add(num);
                backtrack(nums, track);
                track.remove(track.size()-1);
            }
        }

    }

}
