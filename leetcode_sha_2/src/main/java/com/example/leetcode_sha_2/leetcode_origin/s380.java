package com.example.leetcode_sha_2.leetcode_origin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class s380 {

    public static void main(String[] args) {
//        ArrayList<Integer> l = new ArrayList<>();
//        Random rd = new Random();
//        rd.nextInt();


        RandomizedSet r = new RandomizedSet();
        System.out.println(r.remove(0));
        System.out.println(r.remove(0));
        System.out.println(r.insert(0));

        System.out.println(r.getRandom());

        System.out.println(r.remove(0));
        System.out.println(r.insert(0));



    }

}

//class RandomizedSet {
//    // val -> index
//    HashMap<Integer, Integer> m;
//    ArrayList<Integer> nums;
//    Random rd;
//
//    public RandomizedSet() {
//        m = new HashMap<>();
//        nums = new ArrayList<>();
//        rd = new Random();
//    }
//
//    public boolean insert(int val) {
//        if(m.containsKey(val)){
//            return false;
//        }
//
//        m.put(val, nums.size());
//        nums.add(val);
//        return true;
//    }
//
//    public boolean remove(int val) {
//        if(!m.containsKey(val)){
//            return false;
//        }
//
//        int index = m.get(val);
//        int lastVal = nums.get(nums.size()-1);
//        m.put(lastVal, index);
//        nums.set(index, lastVal);
//        nums.remove(nums.size()-1);
//        m.remove(val);
//        return true;
//    }
//
//    public int getRandom() {
//        return nums.get(rd.nextInt(nums.size()));
//    }
//}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */



class RandomizedSet {

    HashMap<Integer, Integer> valToIndex;
    int count;
    int[] nums;
    Random r;

    public RandomizedSet() {
        valToIndex = new HashMap<>();
        count = 0;
        nums = new int[200000];
        r = new Random();
    }

    public boolean insert(int val) {
        if(valToIndex.containsKey(val)){
            return false;
        }
        nums[count] = val;
        valToIndex.put(val, count);
        count++;
        return true;
    }

    public boolean remove(int val) {
        if(!valToIndex.containsKey(val)){
            return false;
        }
        int index = valToIndex.get(val);
        int tail_num = nums[count-1];
        nums[index] = tail_num;
        valToIndex.remove(val);
        valToIndex.put(tail_num, index);
        count--;
        return true;
    }

    public int getRandom() {
        int index = r.nextInt(count);
        return nums[index];
    }
}