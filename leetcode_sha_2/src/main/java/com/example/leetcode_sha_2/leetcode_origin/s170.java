package com.example.leetcode_sha_2.leetcode_origin;

import java.util.HashMap;
import java.util.HashSet;

public class s170 {

    public static void main(String[] args) {

    }

//    设计一个数据结构，可以执行：
//    1、添加一个数；
//    2、给定一个数n nn，判断已经添加的数里是否有两个数的和恰好是n nn。已经添加的数每个数只能用一次。



}


// 方法一：加的复杂度为 O(1)，查的复杂度为 O(N)
//class TwoSum {
//
//    HashMap<Integer, Integer> m;
//
//    /**
//     * Initialize your data structure here.
//     */
//    public TwoSum() {
//        m = new HashMap<>();
//    }
//
//    /**
//     * Add the number to an internal data structure..
//     */
//    public void add(int number) {
//        m.put(number, m.getOrDefault(number, 0)+1);
//    }
//
//    /**
//     * Find if there exists any pair of numbers which sum is equal to the value.
//     */
//    public boolean find(int value) {
//        for (Integer num : m.keySet()) {
//            int other = value - num;
//            if (other==num && m.get(num)>1) {
//                return true;
//            }
//            if (other!=num && m.containsKey(other)){
//                return true;
//            }
//        }
//        return false;
//    }
//}


// 方法二：加的复杂度为 O(N)，查的复杂度为 O(1)
//class TwoSum {
//
//    HashSet<Integer> sum;
//    HashSet<Integer> nums;
//
//    /**
//     * Initialize your data structure here.
//     */
//    public TwoSum() {
//        sum = new HashSet<>();
//        nums = new HashSet<>();
//    }
//
//    /**
//     * Add the number to an internal data structure..
//     */
//    public void add(int number) {
//        for (Integer num : nums) {
//            int target = num + number;
//            sum.add(target);
//        }
//        nums.add(number);
//    }
//
//    /**
//     * Find if there exists any pair of numbers which sum is equal to the value.
//     */
//    public boolean find(int value) {
//        return sum.contains(value);
//    }
//
//}



// 方法一
//class TwoSum {
//
//    HashMap<Integer, Integer> memo;
//    /**
//     * Initialize your data structure here.
//     */
//    public TwoSum() {
//        memo = new HashMap<>();
//    }
//
//    /**
//     * Add the number to an internal data structure..
//     */
//    public void add(int number) {
//        memo.put(number, memo.getOrDefault(number, 0)+1);
//    }
//
//    /**
//     * Find if there exists any pair of numbers which sum is equal to the value.
//     */
//    public boolean find(int value) {
//        for(int num : memo.keySet()){
//            int other = value - num;
//            if (other==num){
//                if (memo.get(num)>=2) {
//                    return true;
//                }
//            }else{
//                if (memo.containsKey(other)) {
//                    return true;
//                }
//            }
//        }
//        return false;
//    }
//
//}


// 方法一
class TwoSum {

    HashSet<Integer> sum;
    HashSet<Integer> memo;

    /**
     * Initialize your data structure here.
     */
    public TwoSum() {
        sum = new HashSet<>();
        memo = new HashSet<>();
    }

    /**
     * Add the number to an internal data structure..
     */
    public void add(int number) {
        for(int cur : memo){
            sum.add(cur+number);
        }
        memo.add(number);
    }

    /**
     * Find if there exists any pair of numbers which sum is equal to the value.
     */
    public boolean find(int value) {
        return sum.contains(value);
    }

}

