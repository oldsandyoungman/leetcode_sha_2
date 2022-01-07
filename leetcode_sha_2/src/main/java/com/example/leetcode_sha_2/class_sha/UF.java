package com.example.leetcode_sha_2.class_sha;

public class UF{

    int[] size;
    int[] parent;
    int count;

    public UF(int n){
        count = n;
        size = new int[n];
        parent = new int[n];
        for(int i=0; i<n; i++){
            size[i] = 1;
            parent[i] = i;
        }
    }

    public int find(int x){
        while(parent[x]!=x){
            parent[x] = parent[parent[x]];
            x = parent[x];
        }
        return x;
    }

    public void union(int x, int y){
        int rootx = parent[x];
        int rooty = parent[y];
        if(rootx==rooty){
            return;
        }
        if(size[rootx]>size[rooty]){
            parent[rooty] = rootx;
            size[rootx] += size[rooty];
        }else{
            parent[rootx] = rooty;
            size[rooty] += size[rootx];
        }
        count--;
    }

    public boolean connected(int x, int y){
        int rootx = find(x);
        int rooty = find(y);
        return rootx==rooty;
    }

    public int count(){
        return count;
    }



}