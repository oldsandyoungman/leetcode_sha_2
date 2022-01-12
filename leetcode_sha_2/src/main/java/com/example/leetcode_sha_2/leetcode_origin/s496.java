package com.example.leetcode_sha_2.leetcode_origin;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashMap;

public class s496 {

    public static void main(String[] args) {
        int[] nums1 = {4,1,2};
        int[] nums2 = {1,3,4,2};

        System.out.println(Arrays.toString(nextGreaterElement(nums1, nums2)));

    }


    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        ArrayDeque<Integer> q = new ArrayDeque<>();
        HashMap<Integer, Integer> m = new HashMap<>();
        int n = nums2.length;
        for(int i=n-1; i>=0; i--){

            while(!q.isEmpty() && q.getLast()<=nums2[i]){
                q.removeLast();
            }
            m.put(nums2[i], q.isEmpty()?-1:q.getLast());
            q.addLast(nums2[i]);

        }
        int nn = nums1.length;
        int[] res = new int[nn];
        for(int i=0; i<nn; i++){
            res[i] = m.get(nums1[i]);
        }

        return res;
    }

}
