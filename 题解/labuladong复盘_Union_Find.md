很多题目还是一错再错，决定做个复盘，记录下自己哪里写错了



[TOC]

#### [Union-Find](https://labuladong.gitee.io/algo/2/19/38/)

> UNION-FIND算法详解



##### 思路

成员变量

- int count
- int[] parent
- int[] size

成员函数

- void union(int i, int j);
- boolean isConnected(int i, int j);
- int findRoot(int i);



##### 注意点

- 不管在调用union，还是isConnect，里面在找根节点的时候，用的是findRoot(i)，而不是parent[i]，因为在更新的过程中，root和parent早已不是一个东西了

- 平衡高度的代码

  ```java
  public int findRoot(int x){
          while(parent[x]!=x){
              parent[x] = parent[parent[x]];
              x = parent[x];
          }
          return x;
      }
  ```

  

##### 代码

```java
class UF{

    int count;
    int[] parent;
    int[] size;

    public UF(int n){
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
```
