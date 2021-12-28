package com.example.leetcode_sha_2.leetcode_origin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class s18 {

    public static void main(String[] args) {
        int[] nums = {1,0,-1,0,-2,2};
        int target = 0;
        System.out.println(fourSum(nums, target));
    }


//    给你一个由 n 个整数组成的数组 nums ，和一个目标值 target 。请你找出并返回满足下述全部条件且不重复的四元组 [nums[a], nums[b], nums[c], nums[d]] （若两个四元组元素一一对应，则认为两个四元组重复）：
//
//            0 <= a, b, c, d < n
//    a、b、c 和 d 互不相同
//    nums[a] + nums[b] + nums[c] + nums[d] == target
//    你可以按 任意顺序 返回答案 。
//
//    来源：力扣（LeetCode）
//    链接：https://leetcode-cn.com/problems/4sum
//    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。



    public static List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        return nSum(nums, target, 4, 0);
    }
    public static List<List<Integer>> nSum(int[] nums, int target, int N, int start){
        int n = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        if(N==2){
            int left = start;
            int right = n-1;
            while(left<right){
                int ln = nums[left];
                int rn = nums[right];
                int s = ln+rn;
                if(s>target){
                    right--;
                    while(left<right && nums[right]==rn){
                        right--;
                    }
                }else if(s<target){
                    left++;
                    while(left<right && nums[left]==ln){
                        left++;
                    }
                }else{
                    List<Integer> tmp = new ArrayList<>();
                    tmp.add(ln);
                    tmp.add(rn);
                    res.add(tmp);
                    right--;
                    while(left<right && nums[right]==rn){
                        right--;
                    }
                    left++;
                    while(left<right && nums[left]==ln){
                        left++;
                    }
                }
            }
            return res;

        }else{

            int i = start;
            while(i<n){
                int tt = target - nums[i];
                List<List<Integer>> tmp = nSum(nums, tt, N-1, i+1);
                for(List<Integer> cur : tmp){
                    cur.add(nums[i]);
                    // res.add(cur);
                    res.add(new ArrayList<>(cur));
                }
                i++;
                while(i<n && nums[i]==target-tt){
                    i++;
                }
            }
            return res;

        }
    }

//    public static List<List<Integer>> fourSum(int[] nums, int target) {
//        Arrays.sort(nums);
//        return nSum(nums, target, 4, 0);
//    }
//    public static List<List<Integer>> nSum(int[] nums, int target, int N, int start) {
//        int n = nums.length;
//
//        List<List<Integer>> res = new ArrayList<>();
//
//        if(N==2){
//            int left = start;
//            int right = n-1;
//            while(left<right){
//                int left_num = nums[left];
//                int right_num = nums[right];
//                int sum = left_num + right_num;
//
//                if(sum>target){
//                    right--;
//                    while(left<right && nums[right]==right_num){
//                        right--;
//                    }
//                }else if(sum<target){
//                    left++;
//                    while(left<right && nums[left]==left_num){
//                        left++;
//                    }
//                }else{
//                    List<Integer> tmp = new ArrayList<>();
//                    tmp.add(left_num);
//                    tmp.add(right_num);
//                    res.add(tmp);
//
//                    right--;
//                    while(left<right && nums[right]==right_num){
//                        right--;
//                    }
//
//                    left++;
//                    while(left<right && nums[left]==left_num){
//                        left++;
//                    }
//
//                }
//
//            }
//
//            return res;
//
//        }else{
//
//            int i = start;
//
//            while(i<n){
//                int cur = nums[i];
//                List<List<Integer>> cur_res = nSum(nums, target-cur, N-1, i+1);
//                for(List<Integer> tmp : cur_res){
//                    tmp.add(cur);
//                    res.add(tmp);
//                }
//
//                i++;
//
//                while(i<n && nums[i]==cur){
//                    i++;
//                }
//
//            }
//
//            return res;
//
//        }
//    }

}
