package com.example.leetcode_sha_2.leetcode_origin;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.LinkedHashSet;

public class s460 {

    public static void main(String[] args) {
        int capacity = 2;
        LFUCache obj = new LFUCache(capacity);


//        [[2],[1,1],[2,2],[1],[3,3],[2],[3],[4,4],[1],[3],[4]]
        obj.put(1, 1);
        obj.put(2, 2);
        System.out.println(obj.get(1));
        obj.put(3, 3);
        System.out.println(obj.get(2));
        System.out.println(obj.get(3));
        obj.put(4, 4);
        System.out.println(obj.get(1));
        System.out.println(obj.get(3));
        System.out.println(obj.get(4));

    }





}


class LFUCache {

    public HashMap<Integer, Integer> keyToVal;
    public HashMap<Integer, Integer> keyToFre;
    public HashMap<Integer, LinkedHashSet<Integer>> freToKey;
    public int minFre;
    public int cap;

    public LFUCache(int capacity) {
        keyToVal = new HashMap<>();
        keyToFre = new HashMap<>();
        freToKey = new HashMap<>();
        minFre = 0;
        cap = capacity;
    }

    public int get(int key) {
        if(!keyToVal.containsKey(key)){
            return -1;
        }
        increaseFre(key);
        return keyToVal.get(key);
    }

    public void put(int key, int value) {
        if(keyToVal.containsKey(key)){
            keyToVal.put(key, value);
            increaseFre(key);
        }else{
            if(cap<=keyToVal.size()){
                removeMinFreKey();
            }
            keyToVal.put(key, value);
            keyToFre.put(key, 1);
            freToKey.putIfAbsent(1, new LinkedHashSet<>());
            freToKey.get(1).add(key);
            minFre = 1;
        }
    }


    public void increaseFre(int key){
        // int val = keyToVal.get(key);
        int fre = keyToFre.get(key);
        // 更新KF表
        keyToFre.put(key, fre+1);
        // 更新FK表
        freToKey.get(fre).remove(key);
        if(freToKey.get(fre).isEmpty()){
            freToKey.remove(fre);
            if(fre==minFre){
                minFre++;
            }
        }
        freToKey.putIfAbsent(fre+1, new LinkedHashSet<>());
        freToKey.get(fre+1).add(key);
    }

    public void removeMinFreKey(){
        int key = freToKey.get(minFre).iterator().next();
        keyToVal.remove(key);
        keyToFre.remove(key);
        freToKey.get(minFre).remove(key);
        if(freToKey.get(minFre).isEmpty()){
            freToKey.remove(minFre);
        }


    }


}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
