package com.example.leetcode_sha_2.leetcode_origin;

public class s261 {

    public static void main(String[] args) {

    }

//    给你输入编号从 0 到 n - 1 的 n 个结点，和一个无向边列表 edges（每条边用节点二元组表示），请你判断输入的这些边组成的结构是否是一棵树。

    // 判断输入的若干条边是否能构造出一棵树结构
    public static boolean validTree(int n, int[][] edges) {
        UF uf = new UF(n);
        for (int[] tmp : edges){
            int a = tmp[0];
            int b = tmp[1];
            if (!uf.connected(a, b)) {
                uf.union(a, b);
            }else {
                return false;
            }
        }
        return uf.count()==1;
    }

}

class UF{

    public int count;
    public int[] size;
    public int[] parent;

    public UF(int n){
        count = n;
        size = new int[n];
        parent = new int[n];

        for (int i = 0; i < n; i++) {
            size[i] = 1;
            parent[i] = i;
        }

    }

    public int find(int a){
        while (parent[a]!=a) {
            parent[a] = parent[parent[a]];
            a = parent[a];
        }
        return a;
    }

    public void union(int a, int b){

        int roota = find(a);
        int rootb = find(b);

        if (roota==rootb){
            return;
        }

        if (size[roota]>size[rootb]) {
            parent[rootb] = roota;
            size[roota] += size[rootb];
        }else {
            parent[roota] = rootb;
            size[rootb] += size[roota];
        }

        count--;

    }

    public boolean connected(int a, int b){
        int roota = find(a);
        int rootb = find(b);
        return roota==rootb;
    }

    public int count(){
        return count;
    }

}
