package com.example.leetcode_sha_2.wangyi_leihuo;

import java.util.PriorityQueue;
import java.util.Scanner;

public class sha4 {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        int N = in.nextInt();
        int M = in.nextInt();

        int X = in.nextInt();
        X--;
        int Y = in.nextInt();
        Y--;

        int Z = in.nextInt();
        Z--;
        int W = in.nextInt();
        W--;

        int[][] nums = new int[N][M];

        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                nums[i][j] = in.nextInt();
            }
        }

        int res = calMin(nums, N, M, X, Y, Z, W);

        System.out.println(res);

    }

    // 三种优化：
    // 1.普通版本，优先级队列+BFS
    // 2.稍微升级版本呢。优先级队列+双向BFS
    // 3.尝试再升级，每次更新不是轮回，而是看谁的值更小就更新哪个

    // 4.结束后想到，用 二分 + 并查集，复杂度大大降低
    // 5.跟倪神交流，用 二分 + BFS，复杂度更低

    public static int calMin(int[][] nums, int N, int M, int X, int Y, int Z, int W){

        int start_x;
        int start_y;
        int end_x;
        int end_y;

        if(nums[X][Y]>nums[Z][W]){
            start_x = Z;
            start_y = W;
            end_x = X;
            end_y = Y;
        }else{
            start_x = X;
            start_y = Y;
            end_x = Z;
            end_y = W;
        }

        PriorityQueue<State> q = new PriorityQueue<>((o1, o2) -> {
            return Integer.compare(o1.maxFromStart, o2.maxFromStart);
        });
        q.offer(new State(start_x, start_y, nums[start_x][start_y]));

        int[][] res = new int[N][M];
        res[start_x][start_y] = nums[start_x][start_y];

        int[][] dir = {{-1,0}, {1, 0}, {0, -1}, {0, 1}};

        while(!q.isEmpty()){
            State cur = q.poll();
            int cur_x = cur.x;
            int cur_y = cur.y;
            int cur_max = cur.maxFromStart;

            if(cur_x==end_x && cur_y==end_y){
                return cur_max;
            }

            if(cur_max<=res[cur_x][cur_y]){
                continue;
            }

            for(int i=0; i<4; i++){
                int next_x = cur_x + dir[i][0];
                int next_y = cur_y + dir[i][1];

                if(next_x<0 || next_x>=N || next_y<0 || next_y>=M){
                    continue;
                }

                int next_max = Math.max(cur_max, nums[next_x][next_y]);

                if(next_max>res[next_x][next_y]){
                    res[next_x][next_y] = next_max;
                    q.offer(new State(next_x, next_y, next_max));
                }

            }

        }

        return res[end_x][end_y];

    }


}


class State{
    int x;
    int y;
    int maxFromStart;

    public State(int aa, int bb, int cc){
        x = aa;
        y = bb;
        maxFromStart = cc;
    }
}