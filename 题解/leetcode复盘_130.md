很多题目还是一错再错，决定做个复盘，记录下自己哪里写错了



[TOC]

#### [130. 被围绕的区域](https://leetcode-cn.com/problems/surrounded-regions/)

> 给你一个 `m x n` 的矩阵 `board` ，由若干字符 `'X'` 和 `'O'` ，找到所有被 `'X'` 围绕的区域，并将这些区域里所有的 `'O'` 用 `'X'` 填充。
>
> 
>
> 提示：
> 
> - m == board.length
>- n == board[i].length
> - 1 <= m, n <= 200
>- board[i][j] 为 'X' 或 'O'



##### 思路

两种思路：

1. DFS：将边界的O及连通区域置为另外一个符号#（用到了DFS），之后遍历所有区域，如果是O，则置为X；如果是#，则置为O
2. Union-Find：设置一个哑结点，连接所有边缘的O及相连的O，然后再在内部区域把O连接上下左右的O，最后再遍历一次内部区域，如果O不与dummy相连，那么就说明要被换成X了



##### 注意点

- 对于DFS方法，注意边界处理完后，中间部分直接遍历即可，不需要再DFS

- 对于BFS，注意UF类里，所有找根节点用的是findRoot(i)，而不是parent[i]



##### 代码

1. DFS方法

```java
class Solution {
    public void solve(char[][] board) {

        int m = board.length;
        int n = board[0].length;

        for(int i=0; i<m; i++){
            if(board[i][0]=='O'){
                dfs(board, i, 0, m, n, 'O', '.');
            }
            if(board[i][n-1]=='O'){
                dfs(board, i, n-1, m, n, 'O', '.');
            }
        }
        for(int i=0; i<n; i++){
            if(board[0][i]=='O'){
                dfs(board, 0, i, m, n, 'O', '.');
            }
            if(board[m-1][i]=='O'){
                dfs(board, m-1, i, m, n, 'O', '.');
            }
        }

        // for(int i=1; i<m-1; i++){
        //     for(int j=1; j<n-1; j++){
        //         if(board[i][j]=='O'){
        //             dfs(board, i, j, m, n, 'O', 'X');
        //         }
        //     }
        // }

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(board[i][j]=='O'){
                    board[i][j] = 'X';
                }else if(board[i][j]=='.'){
                    board[i][j]='O';
                }
            }
        }


    }

    public void dfs(char[][] board, int i, int j, int m, int n, char src, char tar){
        if(i<0 || i>=m || j<0 || j>=n || board[i][j]!=src){
            return;
        }

        board[i][j] = tar;

        dfs(board, i-1, j, m, n, src, tar);
        dfs(board, i+1, j, m, n, src, tar);
        dfs(board, i, j-1, m, n, src, tar);
        dfs(board, i, j+1, m, n, src, tar);

    }

}
```

2. Union-Find方法

```java
class Solution {
    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        UF uf = new UF(m*n+1);
        int dummy = m*n;


        for(int i=0; i<m; i++){
            if(board[i][0]=='O'){
                uf.union(dummy, i*n);
            }
            if(board[i][n-1]=='O'){
                uf.union(dummy, i*n+n-1);
            }
        }
        for(int i=0; i<n; i++){
            if(board[0][i]=='O'){
                uf.union(dummy, i);
            }
            if(board[m-1][i]=='O'){
                uf.union(dummy, (m-1)*n+i);
            }
        }

        int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        for(int i=1; i<m-1; i++){
            for(int j=1; j<n-1; j++){
                if(board[i][j]=='O'){
                    for(int k=0; k<4; k++){
                        int x = i + dir[k][0];
                        int y = j + dir[k][1];
                        if(board[x][y]=='O'){
                            uf.union(x*n+y, i*n+j);
                        }
                    }
                }
            }
        }

        for(int i=1; i<m-1; i++){
            for(int j=1; j<n-1; j++){
                if(board[i][j]=='O'){
                    if(!uf.isConnected(dummy, i*n+j)){
                        board[i][j] = 'X';
                    }
                }
            }
        }

    }
}

class UF{

    int count;
    int[] parent;
    int[] size;

    UF(int n){
        count = n;
        parent = new int[n];
        size = new int[n];
        for(int i=0; i<n; i++){
            parent[i] = i;
            size[i] = 1;
        }
    }

    int findParent(int i){
        while(parent[i]!=i){
            parent[i] = parent[parent[i]];
            i = parent[i];
        }
        return i;
    }

    public boolean isConnected(int i, int j){
        int pa_i = findParent(i);
        int pa_j = findParent(j);
        return pa_i==pa_j;
    }
    public void union(int i, int j){
        int pa_i = findParent(i);
        int pa_j = findParent(j);
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

}
```

