package com.example.leetcode_sha_2.leetcode_origin;

import java.util.*;

public class s1631 {

    public static void main(String[] args) {
//        int[][] heights = {
//                {1,2,1,1,1},
//                {1,2,1,2,1},
//                {1,2,1,2,1},
//                {1,2,1,2,1},
//                {1,1,1,2,1}
//        };

        int[][] heights = {{1,2,2},{3,8,2},{5,3,5}};
        System.out.println(minimumEffortPath(heights));
    }

//    你准备参加一场远足活动。给你一个二维 rows x columns 的地图 heights ，其中 heights[row][col] 表示格子 (row, col) 的高度。一开始你在最左上角的格子 (0, 0) ，且你希望去最右下角的格子 (rows-1, columns-1) （注意下标从 0 开始编号）。你每次可以往 上，下，左，右 四个方向之一移动，你想要找到耗费 体力 最小的一条路径。
//
//    一条路径耗费的 体力值 是路径上相邻格子之间 高度差绝对值 的 最大值 决定的。
//
//    请你返回从左上角走到右下角的最小 体力消耗值 。
//
//    来源：力扣（LeetCode）
//    链接：https://leetcode-cn.com/problems/path-with-minimum-effort
//    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。




    public static int minimumEffortPath(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;

        PriorityQueue<State1631> q = new PriorityQueue<>((o1, o2) -> {
            return Integer.compare(o1.maxGapFromStart, o2.maxGapFromStart);
        });

        q.add(new State1631(0,0,0));

        int[][] dir = new int[][]{{-1,0}, {1,0}, {0,-1}, {0,1}};

        int[][] res = new int[m][n];
        for(int[] tmp : res){
            Arrays.fill(tmp, Integer.MAX_VALUE);
        }
        res[0][0] = 0;

        while(!q.isEmpty()){
            State1631 cur = q.poll();

            if(cur.maxGapFromStart>res[cur.r][cur.c]){
                continue;
            }

            for(int i=0; i<4; i++){
                int newr = cur.r + dir[i][0];
                int newc = cur.c + dir[i][1];

                if(newr>=0 && newr<m && newc>=0 && newc<n){
                    if(res[newr][newc]>Math.max(cur.maxGapFromStart, Math.abs(heights[cur.r][cur.c]-heights[newr][newc]))){
                        res[newr][newc] = Math.max(cur.maxGapFromStart, Math.abs(heights[cur.r][cur.c]-heights[newr][newc]));
                        q.add(new State1631(newr, newc, res[newr][newc]));
                    }
                }

            }

        }

        return res[m-1][n-1];


    }


//    public static int minimumEffortPath(int[][] heights) {
//        int m = heights.length;
//        int n = heights[0].length;
//
//        int[][] minFromStart = new int[m][n];
//
//        // Arrays.fill(minFromStart, Integer.MAX_VALUE);
//
//        for (int i = 0; i < m; i++) {
//            Arrays.fill(minFromStart[i], Integer.MAX_VALUE);
//        }
//
//        minFromStart[0][0] = 0;
//
//        PriorityQueue<State2> q = new PriorityQueue<>((o1, o2) -> {
//            return Integer.compare(o1.distFromStart, o2.distFromStart);
//        });
//
//        q.offer(new State2(0,0,0));
//
//        int min_res = Integer.MAX_VALUE;
//
//        while(!q.isEmpty()){
//
//            State2 cur = q.poll();
//
//            int cur_x = cur.x;
//            int cur_y = cur.y;
//            int cur_distFromStart = cur.distFromStart;
//
//            if(cur_x==m-1 && cur_y==n-1){
//                return minFromStart[m-1][n-1];
//            }
//
//            if(cur_distFromStart > minFromStart[cur_x][cur_y]){
//                continue;
//            }
//
//            List<int[]> nei = adj(heights, cur_x, cur_y);
//
//            for(int[] tmp : nei){
//                int tmp_x = tmp[0];
//                int tmp_y = tmp[1];
//                int gap = Math.abs(heights[cur_x][cur_y] - heights[tmp_x][tmp_y]);
//
//                int max_tmp_distFromStart = Math.max(gap, minFromStart[cur_x][cur_y]);
//
//                if(max_tmp_distFromStart < minFromStart[tmp_x][tmp_y]){
//                    minFromStart[tmp_x][tmp_y] = max_tmp_distFromStart;
//                    q.offer(new State2(tmp_x, tmp_y, max_tmp_distFromStart));
//                }
//
//
//            }
//
//
//        }
//
//        return -1;
//
//
//
//
//
//    }

    public static List<int[]> adj(int[][] matrix, int x, int y){
        int m = matrix.length;
        int n = matrix[0].length;

        List<int[]> res = new LinkedList<>();

        if(x>0){
            res.add(new int[]{x-1, y});
        }
        if(x<m-1){
            res.add(new int[]{x+1, y});
        }
        if(y>0){
            res.add(new int[]{x, y-1});
        }
        if(y<n-1){
            res.add(new int[]{x, y+1});
        }
        return res;
    }

}
class State2{
    int x;
    int y;
    int distFromStart;
    State2(int a, int b, int c){
        x = a;
        y = b;
        distFromStart = c;
    }
}

class State1631{
    int r;
    int c;
    int maxGapFromStart;
    State1631(int aa, int bb, int cc){
        r = aa;
        c = bb;
        maxGapFromStart = cc;
    }
}