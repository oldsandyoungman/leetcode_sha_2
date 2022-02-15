package com.example.leetcode_sha_2.leetcode_origin;

public class s494 {

    public static void main(String[] args) {
        int[] nums = {0,0,0,0,0,0,0,0,1};
        int target = 1;
//        int[] nums = {1,1,1,1,1};
//        int target = 3;
        System.out.println(findTargetSumWays(nums, target));

    }



// 回溯方法

    // public int findTargetSumWays(int[] nums, int target) {
    //     int n = nums.length;
    //     res = 0;
    //     backtrack(nums, 0, target, n);
    //     return res;
    // }
    // public int res;
    // public void backtrack(int[] nums, int start, int target, int N){
    //     if(start==N){
    //         if(target==0){
    //             res++;
    //         }
    //         return;
    //     }

    //     // 如果nums[start]取正号
    //     target -= nums[start];
    //     backtrack(nums, start+1, target, N);
    //     target += nums[start];

    //     // 如果nums[start]取负号
    //     target += nums[start];
    //     backtrack(nums, start+1, target, N);
    //     target -= nums[start];

    // }


//回溯+剪枝

//     public int findTargetSumWays(int[] nums, int target) {
//         int n = nums.length;
//         m = new HashMap<>();
//         return backtrack(nums, 0, target, n);
//     }
//     public HashMap<String, Integer> m;
//     public int res;
//     public int backtrack(int[] nums, int start, int target, int N){
//         if(start==N){
//             if(target==0){
//                 return 1;
//             }else{
//                 return 0;
//             }
//         }

//         String cur = start + "," + target;
//         if(m.containsKey(cur)){
//             return m.get(cur);
//         }

//         // 如果nums[start]取正号
//         target -= nums[start];
//         int res1 = backtrack(nums, start+1, target, N);
//         target += nums[start];

//         // 如果nums[start]取负号
//         target += nums[start];
//         int res2 = backtrack(nums, start+1, target, N);
//         target -= nums[start];

//         int res = res1 + res2;
//         m.put(cur, res);
//         return res;
//     }


// 动态规划

    public static int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        int sum = 0;
        for(int num : nums){
            sum += num;
        }
        int new_target = sum + target;
        if(Math.abs(target)>sum || new_target%2==1){
            return 0;
        }
        new_target /= 2;
        return bag(nums, new_target);

    }
    public static int bag(int[] nums, int target){
//        int n = nums.length;
//        int[][] dp = new int[n+1][target+1];
//        // for(int i=0; i<=target; i++){
//        //     dp[0][i] = 0;
//        // }
//        for(int i=0; i<=n; i++){
//            dp[i][0] = 1;
//        }
//
//        for(int i=1; i<=n; i++){
//            for(int j=0; j<=target; j++){
//                if(j>=nums[i-1]){
//                    dp[i][j] = dp[i-1][j-nums[i-1]] + dp[i-1][j];
//                }else{
//                    dp[i][j] = dp[i-1][j];
//                }
//            }
//        }
//
//        return dp[n][target];


        int n = nums.length;
        // dp[i][j]: nums[0]-nums[i-1]中任选物品，使得总和为j的方案数量
        int[][] dp = new int[n+1][target+1];
        // base
        // dp[i][0] = 1 （dp[i][0]只是初始化为1，因为nums中可能有0，所以之后可能会继续变大）
        // dp[0][j] = 0;
        for(int i=0; i<=n; i++){
            dp[i][0] = 1;
        }

        for(int i=1; i<=n; i++){
            for(int j=0; j<=target; j++){
                if(nums[i-1]<=j){
                    dp[i][j] = dp[i-1][j-nums[i-1]] + dp[i-1][j];
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

//        System.out.println(Arrays.deepToString(dp));

        return dp[n][target];


    }



}
