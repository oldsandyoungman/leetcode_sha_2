package com.example.leetcode_sha_2.wangyi_huyu;

import com.example.leetcode_sha_2.class_sha.TreeNode;

import java.util.*;

public class sha3 {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        int N = in.nextInt();

        int[] nums = new int[N];

        for(int i=0; i<N; i++){
            nums[i] = in.nextInt();
        }


        int farthest = 0;
        int end = 0;
        int steps = 0;
        for(int i=0; i<N; i++){
            farthest = Math.max(farthest, nums[i]+i);
            if(end==i){
                steps++;
                end = farthest;
            }
        }

        int res = calStep(nums, N);

        System.out.println(res);


//         ArrayDeque<Integer> q = new ArrayDeque<>();
//         q.addLast(0);

//         int steps = 0;

//         while(!q.isEmpty()){

//             int n = q.size();

//             for(){

//             }


//         }


    }

//    public static int calStep(int[] nums, int N){
//
//        PriorityQueue<State> q = new PriorityQueue<>((o1, o2) -> {
//            return Integer.compare(o2.index, o1.index);
//        });
//        q.offer(new State(nums[0], 1));
//        int start_return = 0;
//        while(!q.isEmpty()){
//            State cur = q.poll();
//            int cur_index = cur.index;
//            int cur_step = cur.step;
//            if(cur_index>=N){
//                return cur_step;
//            }
//            q.offer(new State(cur_index+nums[cur_index], cur_step+1));
//            for(int i=start_return+1; i<cur_index; i++){
//                q.offer(new State(i, cur_step+1));
//            }
//            start_return = cur_index;
//        }
//
//        return -1;
//    }



//    public static int calStep(int[] nums, int N){
//
//        int[] dp1 = new int[N+1];
//        Arrays.fill(dp1, N);
//        dp1[0] = 0;
//        for(int i=1; i<=N; i++){
//            for(int j=0; j<i; j++){
//                if(j+nums[j]>=i){
//                    dp1[i] = Math.min(dp1[i], dp1[j]+1);
//                }
//            }
//        }
//        int[] dp2 = new int[N+1];
//        Arrays.fill(dp2, N);
//        dp2[0] = 0;
//        for(int i=0; i<N; i++){
////            dp2[i] = dp1[i];
//            for(int j=i+1; j<=N; j++){
//                dp2[i] = Math.min(dp2[i], dp1[j]+1);
//            }
//        }
//        int res = N;
//        for(int i=0; i<N; i++){
//            if(i+nums[i]>=N){
//                res = Math.min(res, dp2[i]+1);
//            }
//        }
//
//        return res;
//
//    }

    public static int calStep(int[] nums, int N){

        int[] dp = new int[N];

        Arrays.fill(dp, N);
        dp[0] = 0;

        int res = N;

        for(int i=0; i<N; i++){
            int index = i+nums[i];
            if(index>=N){
                res = Math.min(res, dp[i]+1);
                continue;
            }
            dp[index] = Math.min(dp[index], dp[i]+1);
            for(int j=0; j<index; j++){
                dp[j] = Math.min(dp[j], dp[i]+2);
            }
        }
        return res;
    }





//     public static int calStep(int[] nums, int N){

//         PriorityQueue<Integer> q = new PriorityQueue<>();
//         q.offer(nums[0]);
//         int step = 1;
//         while(!q.isEmpty()){

//             int n = q.size();

//             for(){

//             }

//         }


//     }


}


class State{
    int index;
    int step;
    public State(int index, int step){
        this.index = index;
        this.step = step;
    }

}
