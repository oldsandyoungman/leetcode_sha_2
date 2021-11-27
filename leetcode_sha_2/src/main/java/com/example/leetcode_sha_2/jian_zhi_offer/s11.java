package com.example.leetcode_sha_2.jian_zhi_offer;

public class s11 {

    public static void main(String[] args) {

    }

//    把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。例如，数组 [3,4,5,1,2] 为 [1,2,3,4,5] 的一个旋转，该数组的最小值为1。
//
//    来源：力扣（LeetCode）
//    链接：https://leetcode-cn.com/problems/xuan-zhuan-shu-zu-de-zui-xiao-shu-zi-lcof
//    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。


    public static int minArray(int[] numbers) {
        int n = numbers.length;

        int left = 0;
        int right = n-1;

        while (left<right){
            int mid = left + (right-left)/2;
            int mid_num = numbers[mid];
            int right_num = numbers[right];

            if (mid_num<right_num){
                right = mid;
            } else if (mid_num>right_num) {
                left = mid + 1;
            }else {
                right--;
            }
        }

        return numbers[left];

    }


}
