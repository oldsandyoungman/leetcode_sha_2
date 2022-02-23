package com.example.leetcode_sha_2.leetcode_origin;

public class s323 {

    public static void main(String[] args) {
        int n = 10;
        UF323 uf = new UF323(n);
    }



}


class UF323{

    int count;
    int[] parent;
    int[] size;

    public UF323(int n){
        count = n;
        parent = new int[n];
        size = new int[n];
        for(int i=0; i<n; i++){
            parent[i] = i;
            size[i] = 1;
        }
    }

    public void union(int i, int j){
        int pa_i = findRoot(i);
        int pa_j = findRoot(j);

        if(pa_i==pa_j){
            return;
        }

        if(size[pa_i]>size[pa_j]){
            parent[pa_j] = pa_i;
            size[pa_i] += size[pa_j];
        }else{
            parent[pa_i] = pa_j;
            size[pa_j] += size[pa_i];
        }
        count--;
    }

    public boolean isConnected(int i, int j){
        int pa_i = findRoot(i);
        int pa_j = findRoot(j);
        return pa_i==pa_j;
    }

    public int findRoot(int x){
        while(parent[x]!=x){
            parent[x] = parent[parent[x]];
            x = parent[x];
        }
        return x;
    }


}