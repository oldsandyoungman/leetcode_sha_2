package com.example.leetcode_sha_2.labuladong;

public class s2 {

    public static void main(String[] args) {
        MaxPQ<Integer> qq = new MaxPQ<>(20);
        qq.insert(1);
        qq.insert(4);
        qq.insert(2);
        qq.insert(3);
        System.out.println(qq.delMax());
        System.out.println(qq.delMax());
        System.out.println(qq.delMax());
        System.out.println(qq.delMax());
    }

    // 二叉堆：
    // https://labuladong.gitee.io/algo/2/19/50/


}

//class MaxPQ
//<Key extends Comparable<Key>>{
//    Key[] pq;
//    int N;
//
//    MaxPQ(int cap){
//        pq = (Key[]) new Comparable[cap+1];
//        N = 0;
//    }
//
//    public Key max(){
//        return pq[1];
//    }
//
//    void exch(int i, int j){
//        Key tmp = pq[i];
//        pq[i] = pq[j];
//        pq[j] = tmp;
//    }
//
//    boolean less(int i, int j){
//        return pq[i].compareTo(pq[j])<0;
//    }
//
//    int parent(int k){
//        return k/2;
//    }
//
//    int left(int k){
//        return k*2;
//    }
//
//    int right(int k){
//        return k*2+1;
//    }
//
//    void swim(int k){
//        while(k>1 && less(parent(k),k)){
//            exch(parent(k),k);
//            k = parent(k);
//        }
//    }
//
//    void sink(int k){
//        while (left(k)<=N){
//            int old = left(k);
//            if(right(k)<=N && less(old, right(k))){
//                old = right(k);
//            }
//
//            if (less(old, k)) {
//                break;
//            }
//
//            exch(k, old);
//
//            k = old;
//
//        }
//    }
//
//    public void insert(Key e){
//        N++;
//        pq[N] = e;
//        swim(N);
//    }
//
//    public Key delMax(){
//        Key res = pq[1];
//        exch(1, N);
//        pq[N] = null;
//        N--;
//        sink(1);
//        return res;
//    }
//
//
//}


class MaxPQ
<Key extends Comparable<Key>>{

    Key[] pq;
    int N;

    MaxPQ(int cap){
        // 这边记得+1
        pq = (Key[]) new Comparable[cap+1];
        N = 0;
    }

    Key max(){
        return pq[1];
    }

    void exch(int i, int j){
        Key tmp = pq[i];
        pq[i] = pq[j];
        pq[j] = tmp;
    }

    boolean less(int i, int j){
        return pq[i].compareTo(pq[j])<0;
    }

    int parent(int k){
        return k/2;
    }

    int left(int k){
        return 2*k;
    }

    int right(int k){
        return 2*k+1;
    }

    void swim(int k){
        while (k>1 && less(parent(k), k)) {
            exch(parent(k), k);
            k = parent(k);
        }
    }

    void sink(int k){
        while (left(k)<=N) {
            int old = left(k);
            if(right(k)<=N && less(old, right(k))){
                old = right(k);
            }
            if(less(old, k)){
                break;
            }
            exch(old, k);
            k = old;
        }
    }

    void insert(Key e){
        N++;
        pq[N] = e;
        swim(N);
    }

    Key delMax(){
        Key res = pq[1];
        exch(1, N);
        pq[N] = null;
        N--;
        sink(1);
        return res;
    }


}
