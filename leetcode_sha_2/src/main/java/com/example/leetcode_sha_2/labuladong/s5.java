package com.example.leetcode_sha_2.labuladong;

import java.util.Arrays;
import java.util.TreeSet;

public class s5 {

    public static void main(String[] args) {
//        int[] nums = new int[]{3,3,3,3,3};
        int[] nums = new int[]{4,1,6,3,2,5};
//        int[] nums = new int[]{2,1};
        sort(nums);
        System.out.println(Arrays.toString(nums));


//        TreeSet<Integer> ss = new TreeSet<>();
//
//        TreeSet<int[]> s = new TreeSet<>((o1, o2) -> {
//           if(o1[0]==o2[0]){
//               return o2[1]-o1[1];
//           }else{
//               return o1[0]-o2[0];
//           }
//        });
//
//        s.add(new int[]{1,2});
//        s.add(new int[]{1,3});
//        s.add(new int[]{2,1});
//        System.out.println(Arrays.toString(s.first()));
//        System.out.println(Arrays.toString(s.last()));
//        System.out.println("111");
//        s.pollFirst();

    }

    // 快排
    // https://labuladong.gitee.io/algo/4/31/129/





// 快排重做一遍
    public static void sort(int[] nums){
        sort(nums, 0, nums.length-1);
    }

    public static void sort(int[] nums, int lo, int hi){
        if(lo>=hi){
            return;
        }

        int index = partition(nums, lo, hi);
        sort(nums, lo, index-1);
        sort(nums, index+1, hi);

    }

    public static int partition(int[] nums, int lo, int hi){
        if(lo >= hi){
            return lo;
        }

        int pivot = nums[lo];
        int i = lo;
        int j = hi+1;

        while (true) {

            while(nums[++i]<pivot){
                if (i>=hi) {
                    break;
                }
            }
            while (nums[--j]>pivot) {
                if (j<=lo) {
                    break;
                }
            }
            if (i>=j) {
                break;
            }
            swap(nums, i, j);

        }
        swap(nums, lo, j);
        return j;

    }

    public static void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }



















//    public static void sort(int[] nums){
//        sort(nums, 0, nums.length-1);
//    }
//
//    public static void sort(int[] nums, int lo, int hi){
//        if (lo>=hi) {
//            return;
//        }
//        int index = partition(nums, lo, hi);
//        sort(nums, lo, index-1);
//        sort(nums, index+1, hi);
//    }
//
//    public static int partition(int[] nums, int lo, int hi){
//        if (lo>=hi) {
//            return lo;
//        }
//
//        int pivot = nums[lo];
//        int i = lo;
//        int j = hi+1;
//
//        while (true) {
//
//            while (nums[++i]<pivot){
//                i++;
//                if(i>=hi){
//                    break;
//                }
//            }
//
//            while (nums[--j]>pivot) {
//                j--;
//                if (j<=lo) {
//                    break;
//                }
//            }
//
//            if (i>=j) {
//                break;
//            }
//
//            swap(nums, i, j);
//
//        }
//
//        swap(nums, lo, j);
//
//        return j;
//    }
//
//    public static void swap(int[] nums, int i, int j){
//        int tmp = nums[i];
//        nums[i] = nums[j];
//        nums[j] = tmp;
//    }












//    /* 快速排序主函数 */
//    public static void sort(int[] nums) {
//        // 一般要在这用洗牌算法将 nums 数组打乱，
//        // 以保证较高的效率，我们暂时省略这个细节
//        sort(nums, 0, nums.length - 1);
//    }
//
//    /* 快速排序核心逻辑 */
//    public static void sort(int[] nums, int lo, int hi) {
//        if(lo>=hi){
//            return;
//        }
//        int index = partition(nums, lo, hi);
//        sort(nums, lo, index-1);
//        sort(nums, index+1, hi);
//    }
//
//    public static int partition(int[] nums, int lo, int hi) {
//        if (lo==hi) {
//            return lo;
//        }
//
//        int pivot = nums[lo];
//        int i = lo+1;
//        int j = hi;
//
//        while (true){
//
//            while (i<hi && nums[i]<pivot){
//                i++;
//            }
//
//            while (j>lo && nums[j]>pivot){
//                j--;
//            }
//
//            if (i>=j) {
//                break;
//            }
//
//            swap(nums, i, j);
//
//        }
//
//        swap(nums, lo, j);
//
//        return j;
//
//    }
//
//    public static void swap(int[] nums, int i, int j){
//        int tmp = nums[i];
//        nums[i] = nums[j];
//        nums[j] = tmp;
//    }










//    /* 快速排序主函数 */
//    private static void sort(int[] nums) {
//        // 一般要在这用洗牌算法将 nums 数组打乱，
//        // 以保证较高的效率，我们暂时省略这个细节
//        sort(nums, 0, nums.length - 1);
//    }
//
//    /* 快速排序核心逻辑 */
//    private static void sort(int[] nums, int lo, int hi) {
//        if (lo >= hi) return;
//        // 通过交换元素构建分界点索引 p
//        int p = partition(nums, lo, hi);
//        // 现在 nums[lo..p-1] 都小于 nums[p]，
//        // 且 nums[p+1..hi] 都大于 nums[p]
//        sort(nums, lo, p - 1);
//        sort(nums, p + 1, hi);
//    }
//
//    private static int partition(int[] nums, int lo, int hi) {
//        if (lo == hi) return lo;
//        // 将 nums[lo] 作为默认分界点 pivot
//        int pivot = nums[lo];
//        // j = hi + 1 因为 while 中会先执行 --
//        int i = lo, j = hi + 1;
//        while (true) {
//            // 保证 nums[lo..i] 都小于 pivot
//            while (nums[++i] < pivot) {
//                if (i == hi) break;
//            }
//            // 保证 nums[j..hi] 都大于 pivot
//            while (nums[--j] > pivot) {
//                if (j == lo) break;
//            }
//            if (i >= j) break;
//            // 如果走到这里，一定有：
//            // nums[i] > pivot && nums[j] < pivot
//            // 所以需要交换 nums[i] 和 nums[j]，
//            // 保证 nums[lo..i] < pivot < nums[j..hi]
//            swap(nums, i, j);
//        }
//        // 将 pivot 值交换到正确的位置
//        swap(nums, j, lo);
//        // 现在 nums[lo..j-1] < nums[j] < nums[j+1..hi]
//        return j;
//    }
//
//    // 交换数组中的两个元素
//    private static void swap(int[] nums, int i, int j) {
//        int temp = nums[i];
//        nums[i] = nums[j];
//        nums[j] = temp;
//    }



}
