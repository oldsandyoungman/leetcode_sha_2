package com.example.leetcode_sha_2.leetcode_origin;

public class s1011 {

    public static void main(String[] args) {
        int[] weights = {1,2,3,4,5,6,7,8,9,10};
        int days = 5;

        System.out.println(fun(weights, 15));

    }

//    传送带上的包裹必须在 days 天内从一个港口运送到另一个港口。
//
//    传送带上的第 i 个包裹的重量为 weights[i]。每一天，我们都会按给出重量（weights）的顺序往传送带上装载包裹。我们装载的重量不会超过船的最大运载重量。
//
//    返回能在 days 天内将传送带上的所有包裹送达的船的最低运载能力。
//
//    来源：力扣（LeetCode）
//    链接：https://leetcode-cn.com/problems/capacity-to-ship-packages-within-d-days
//    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

    public static int shipWithinDays(int[] weights, int days) {
        int max = 0;
        int sum = 0;
        for(int cur : weights){
            max = Math.max(max, cur);
            sum += cur;
        }
        int left = max;
        int right = sum;
        while(left<=right){
            int mid = left+(right-left)/2;
            if(fun(weights, mid)>days){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        return left;
    }
    public static int fun(int[] weights, int k){
         int res = 0;
         int tmp = 0;
         for(int cur : weights){
             if(tmp+cur<=k){
                 tmp += cur;
             }else{
                 res++;
                 tmp = cur;
             }
         }
         return res+1;
//        int days = 0;
//        for (int i = 0; i < weights.length; ) {
//            // 尽可能多装货物
//            int cap = k;
//            while (i < weights.length) {
//                if (cap < weights[i]) break;
//                else cap -= weights[i];
//                i++;
//            }
//            days++;
//        }
//        return days;
    }

}
