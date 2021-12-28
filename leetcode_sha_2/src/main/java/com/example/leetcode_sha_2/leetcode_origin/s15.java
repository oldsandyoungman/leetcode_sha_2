package com.example.leetcode_sha_2.leetcode_origin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class s15 {

    public static void main(String[] args) {
        int[] nums = {-1,0,1,2,-1,-4};
//        int[] nums = {0,0,0};
//        int[] nums = {1,1,1};
        System.out.println(threeSum(nums));
    }

//    给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
//
//    注意：答案中不可以包含重复的三元组。
//
//    来源：力扣（LeetCode）
//    链接：https://leetcode-cn.com/problems/3sum
//    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。



    public static List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> res = new LinkedList<>();
        int i = 0;
        while(i<n){
            int target = -nums[i];
            List<List<Integer>> tmp = twoSum(nums, target, i+1);
            for(List<Integer> cur : tmp){
                cur.add(nums[i]);
                res.add(new LinkedList<>(cur));
            }
            i++;
            while(i<n && nums[i]==-target){
                i++;
            }
        }
        return res;
    }

    public static List<List<Integer>> twoSum(int[] nums, int target, int start){
        int n = nums.length;
        int left = start;
        int right = n-1;
        List<List<Integer>> res = new LinkedList<>();
        while(left<=right){
            int ln = nums[left];
            int rn = nums[right];
            int s = ln + rn;
            if(s>target){
                right--;
                while(right>left && nums[right]==rn){
                    right--;
                }
            }else if(s<target){
                left++;
                while(right>left && nums[left]==ln){
                    left++;
                }
            }else{
                List<Integer> tmp = new LinkedList<>();
                tmp.add(ln);
                tmp.add(rn);
                res.add(tmp);
                left++;
                right--;
                while(right>left && nums[left]==ln){
                    left++;
                }
                while(right>left && nums[right]==rn){
                    right--;
                }
            }
        }
        return res;
    }



//    public static List<List<Integer>> threeSum(int[] nums) {
//        Arrays.sort(nums);
//        int n = nums.length;
//
//        List<List<Integer>> result = new ArrayList<>();
//
//        int i = 0;
//
//        while(i<n){
//
//            int cur_num = nums[i];
//            int target = -cur_num;
//            List<List<Integer>> res = twoSum(nums, i+1, target);
//
//            for(List<Integer> tmp : res){
//                tmp.add(cur_num);
//                result.add(tmp);
//            }
//
//            i++;
//
//            while(i<n && nums[i]==cur_num){
//                i++;
//            }
//
//        }
//
//        return result;
//
//    }
//    public static List<List<Integer>> twoSum(int[] nums, int start, int target){
//        int n = nums.length;
//        int left = start;
//        int right = n-1;
//
//        List<List<Integer>> res = new ArrayList<>();
//
//        while(left<right){
//            int left_num = nums[left];
//            int right_num = nums[right];
//            int sum = left_num + right_num;
//            if(sum<target){
//                left++;
//                while(left<right && nums[left]==left_num){
//                    left++;
//                }
//            }else if(sum>target){
//                right--;
//                while(left<right && nums[right]==right_num){
//                    right--;
//                }
//            }else{
//                List<Integer> tmp = new ArrayList<>();
//                tmp.add(left_num);
//                tmp.add(right_num);
//                res.add(tmp);
//
//                left++;
//                while(left<right && nums[left]==left_num){
//                    left++;
//                }
//
//                right--;
//                while(left<right && nums[right]==right_num){
//                    right--;
//                }
//
//            }
//        }
//
//        return res;
//
//    }

}
