package com.example.leetcode_sha_2.leetcode_origin;

import java.util.HashSet;

public class s391 {

    public static void main(String[] args) {
        int[][] rec = {{1,1,3,3},{3,1,4,2},{3,2,4,4},{1,3,2,4},{2,3,3,4}};
        System.out.println(isRectangleCover(rec));
    }


//    给你一个数组 rectangles ，其中 rectangles[i] = [xi, yi, ai, bi] 表示一个坐标轴平行的矩形。这个矩形的左下顶点是 (xi, yi) ，右上顶点是 (ai, bi) 。
//
//    如果所有矩形一起精确覆盖了某个矩形区域，则返回 true ；否则，返回 false 。
//
//    来源：力扣（LeetCode）
//    链接：https://leetcode-cn.com/problems/perfect-rectangle
//    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。


    public static boolean isRectangleCover(int[][] rectangles) {
        // 最外层矩阵坐标
        int xx1 = 100001;
        int yy1 = 100001;
        int xx2 = -100001;
        int yy2 = -100001;

        // 矩阵的面积累和
        int sum = 0;

        // 记录顶点
        HashSet<String> memo = new HashSet<>();

        for(int[] rec : rectangles){
            int x1 = rec[0];
            int y1 = rec[1];
            int x2 = rec[2];
            int y2 = rec[3];

            // 更新最外层矩阵的坐标
            xx1 = Math.min(xx1, x1);
            yy1 = Math.min(yy1, y1);
            xx2 = Math.max(xx2, x2);
            yy2 = Math.max(yy2, y2);

            // 更新各矩阵累和
            sum += (x2-x1)*(y2-y1);

            // 更新顶点坐标
            String tmp;
            tmp = x1 + "," + y1;
            if(memo.contains(tmp)){
                memo.remove(tmp);
            }else{
                memo.add(tmp);
            }
            tmp = x1 + "," + y2;
            if(memo.contains(tmp)){
                memo.remove(tmp);
            }else{
                memo.add(tmp);
            }
            tmp = x2 + "," + y1;
            if(memo.contains(tmp)){
                memo.remove(tmp);
            }else{
                memo.add(tmp);
            }
            tmp = x2 + "," + y2;
            if(memo.contains(tmp)){
                memo.remove(tmp);
            }else{
                memo.add(tmp);
            }

        }

        // 判断面积是否对头
        int target_sum = (xx2-xx1)*(yy2-yy1);
        if(target_sum!=sum){
            return false;
        }

        // 判断顶点坐标是否为4个
        if(memo.size()!=4){
            return false;
        }

        // 判断最外层的顶点坐标是否在memo内
        String tmp;
        tmp = xx1 + "," + yy1;
        if(!memo.contains(tmp)){
            return false;
        }
        tmp = xx1 + "," + yy2;
        if(!memo.contains(tmp)){
            return false;
        }
        tmp = xx2 + "," + yy1;
        if(!memo.contains(tmp)){
            return false;
        }
        tmp = xx2 + "," + yy2;
        if(!memo.contains(tmp)){
            return false;
        }

        return true;

    }
}
