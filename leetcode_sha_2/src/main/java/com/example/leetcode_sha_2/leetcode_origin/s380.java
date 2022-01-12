package com.example.leetcode_sha_2.leetcode_origin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class s380 {

    public static void main(String[] args) {
        ArrayList<Integer> l = new ArrayList<>();
        Random rd = new Random();
        rd.nextInt();
    }

}

class RandomizedSet {
    // val -> index
    HashMap<Integer, Integer> m;
    ArrayList<Integer> nums;
    Random rd;

    public RandomizedSet() {
        m = new HashMap<>();
        nums = new ArrayList<>();
        rd = new Random();
    }

    public boolean insert(int val) {
        if(m.containsKey(val)){
            return false;
        }

        m.put(val, nums.size());
        nums.add(val);
        return true;
    }

    public boolean remove(int val) {
        if(!m.containsKey(val)){
            return false;
        }

        int index = m.get(val);
        int lastVal = nums.get(nums.size()-1);
        m.put(lastVal, index);
        nums.set(index, lastVal);
        nums.remove(nums.size()-1);
        m.remove(val);
        return true;
    }

    public int getRandom() {
        return nums.get(rd.nextInt(nums.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */