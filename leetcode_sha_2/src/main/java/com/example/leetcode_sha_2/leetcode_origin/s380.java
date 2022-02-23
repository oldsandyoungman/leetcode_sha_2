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


//    实现RandomizedSet 类：
//
//    RandomizedSet() 初始化 RandomizedSet 对象
//    bool insert(int val) 当元素 val 不存在时，向集合中插入该项，并返回 true ；否则，返回 false 。
//    bool remove(int val) 当元素 val 存在时，从集合中移除该项，并返回 true ；否则，返回 false 。
//    int getRandom() 随机返回现有集合中的一项（测试用例保证调用此方法时集合中至少存在一个元素）。每个元素应该有 相同的概率 被返回。
//    你必须实现类的所有函数，并满足每个函数的 平均 时间复杂度为 O(1) 。
//
//    来源：力扣（LeetCode）
//    链接：https://leetcode-cn.com/problems/insert-delete-getrandom-o1
//    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

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