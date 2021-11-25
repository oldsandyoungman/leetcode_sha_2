package com.example.leetcode_sha_2.leetcode_origin;

public class s34 {

    public static void main(String[] args) {

    }

//    给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
//
//    如果数组中不存在目标值 target，返回 [-1, -1]。
//
//    来源：力扣（LeetCode）
//    链接：https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array
//    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。


    public static int[] searchRange(int[] nums, int target) {
        int n = nums.length;
        int left = 0;
        int right = n-1;
        int mid = -1;
        while(left<=right){
            mid = left + (right-left)/2;
            if(nums[mid]==target){
                break;
            }else if(nums[mid]<target){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }

        if(mid == -1 || nums[mid]!=target){
            return new int[]{-1, -1};
        }


        int left1 = 0;
        int right1 = mid;
        int mid1 = -1;
        while(left1<=right1){
            mid1 = left1 + (right1-left1)/2;
            if(nums[mid1]<target){
                left1 = mid1 + 1;
            }else{
                right1 = mid1 - 1;
            }
        }

        int left2 = mid;
        int right2 = n-1;
        int mid2 = -1;
        while(left2<=right2){
            mid2 = left2 + (right2-left2)/2;
            if(nums[mid2]>target){
                right2 = mid2 - 1;
            }else{
                left2 = mid2 + 1;
            }
        }

        return new int[]{left1, right2};

    }

}
