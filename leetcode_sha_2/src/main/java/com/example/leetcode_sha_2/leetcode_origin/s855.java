package com.example.leetcode_sha_2.leetcode_origin;

import java.util.*;

public class s855 {

    public static void main(String[] args) {
//        TreeSet<int[]> s = new TreeSet<>((o1, o2) -> {
//            return Integer.compare(o1[0], o2[0]);
//        });
//
//        s.add(new int[]{1,2});
//        s.add(new int[]{2,1});
//        s.add(new int[]{3,2});
//        int[] last = s.last();
//
//
//        System.out.println(Arrays.toString(s.first()));
////        System.out.println(Arrays.toString(s.first()));

        ExamRoom er = new ExamRoom(4);
        System.out.println(er.seat());
        System.out.println(er.seat());
        System.out.println(er.seat());
        System.out.println(er.seat());
        er.leave(1);
        er.leave(3);
        System.out.println(er.seat());


    }

//    在考场里，一排有 N 个座位，分别编号为 0, 1, 2, ..., N-1 。
//
//    当学生进入考场后，他必须坐在能够使他与离他最近的人之间的距离达到最大化的座位上。如果有多个这样的座位，他会坐在编号最小的座位上。(另外，如果考场里没有人，那么学生就坐在 0 号座位上。)
//
//    返回 ExamRoom(int N) 类，它有两个公开的函数：其中，函数 ExamRoom.seat() 会返回一个 int （整型数据），代表学生坐的位置；函数 ExamRoom.leave(int p) 代表坐在座位 p 上的学生现在离开了考场。每次调用 ExamRoom.leave(p) 时都保证有学生坐在座位 p 上。
//
//    来源：力扣（LeetCode）
//    链接：https://leetcode-cn.com/problems/exam-room
//    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

}


class ExamRoom {

    TreeSet<int[]> pq;
    HashMap<Integer, int[]> start;
    HashMap<Integer, int[]> end;
    int N;

    public ExamRoom(int n) {
        N = n;
        pq = new TreeSet<>((o1, o2) -> {
            int dis1 = distance(o1);
            int dis2 = distance(o2);
            if(dis1==dis2){
                return o2[0]-o1[0];
            }
            return dis1-dis2;
        });
        start = new HashMap<>();
        end = new HashMap<>();
        int[] dum = new int[]{-1, n};

        add_sha(dum);

    }

    public int seat() {
        int[] cur = pq.last();
        int mid;
        if(cur[0]==-1){
            mid =0;
        }else if(cur[1]==N){
            mid = N-1;
        }else{
            mid = cur[0] + (cur[1]-cur[0])/2;
        }

        remove_sha(cur);
        int[] left = new int[]{cur[0], mid};
        int[] right = new int[]{mid, cur[1]};
        add_sha(left);
        add_sha(right);

        return mid;

    }

    public void leave(int p) {
        int[] left = end.get(p);
        int[] right = start.get(p);

        remove_sha(left);
        remove_sha(right);
        add_sha(new int[]{left[0], right[1]});

    }

    public void remove_sha(int[] cur){
        pq.remove(cur);
        start.remove(cur[0]);
        end.remove(cur[1]);
    }

    public void add_sha(int[] cur){
        pq.add(cur);
        start.put(cur[0], cur);
        end.put(cur[1], cur);
    }

    public int distance(int[] a){
        if(a[0]==-1){
            // 这样才能保证[-1,0]不会再往里面安插座位，因为距离永远是0
            return a[1];
        }
        if(a[1]==N){
            // 这样才能保证[N-1,N]不会再往里面安插座位，因为距离永远是0
            return N-1-a[0];
        }
        return (a[1]-a[0])/2;
    }

}

/**
 * Your ExamRoom object will be instantiated and called as such:
 * ExamRoom obj = new ExamRoom(n);
 * int param_1 = obj.seat();
 * obj.leave(p);
 */