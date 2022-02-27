很多题目还是一错再错，决定做个复盘，记录下自己哪里写错了



[TOC]

#### [207. 课程表](https://leetcode-cn.com/problems/course-schedule/)

> 你这个学期必须选修 numCourses 门课程，记为 0 到 numCourses - 1 。
>
> 在选修某些课程之前需要一些先修课程。 先修课程按数组 prerequisites 给出，其中 prerequisites[i] = [ai, bi] ，表示如果要学习课程 ai 则 必须 先学习课程  bi 。
>
> 例如，先修课程对 [0, 1] 表示：想要学习课程 0 ，你需要先完成课程 1 。
> 请你判断是否可能完成所有课程的学习？如果可以，返回 true ；否则，返回 false 。
>
> 
>
> 提示：
>
> - 1 <= numCourses <= 105
> - 0 <= prerequisites.length <= 5000
> - prerequisites[i].length == 2
> - 0 <= ai, bi < numCourses
> - prerequisites[i] 中的所有课程对 互不相同



##### 思路



方法一：DFS

这个题就是图的遍历框架的应用

```java
public void dfs(LinkedList<Integer>[] graph, int cur){
    
    // 终止条件
    if(xxxx){
        // ...
        return;
    }
    
    // 前序遍历，当前节点的更新
    path[cur] = true;
    visited[cur] = true;
    
    // 递归下一个节点
    for(int next : graph[cur]){
        dfs(graph, next);
    }
    
    // 后续遍历，撤销当前点的更新
    path[cur] = false;
    
}
```



在此基础上，因为要判断是否成环，所以需要额外的两个数组记录信息

- Path[i]：在当前的路径中，i 节点是否已经走过
- visited[i]：在所有的遍历中，i 节点是否之前已经遍历过

> 注意，这两个数组不是同一个概念：
>
> path[i] 是用来判断是否成环的
>
> visited[i] 是用来剪枝的，如果之前走过，那么就可以直接跳过，不然会死循环（因为一直走不完）





方法二：BFS

用到图论里面的一个专业术语，叫做入度，当一个节点入度为0，那么就可以以它为起点，访问相邻节点（这样能保证不存在反向依赖问题）

> 具体流程：
>
> 1. 建图，得到邻接表和入度数组
> 2. 将入度数组中为0的节点加入队列中
> 3. 循环取出队头，放入结果列表中，代表实际课程安排就是当前节点，然后对邻接节点减少它们的入度，如果有邻接节点入度为0，加入队列
> 4. 最后得到的结果列表就是安排顺序，是否成环，看结果列表长度是否就是课程总数目



##### 注意点

- 撤销更新的时候，visited[i] 不用撤销，不然一些用例会造成死循环

- 对于这种递归函数的返回值，void 或者 boolean 都可以做，void就是外层要加个变量记录最终结果，并且函数内部要加一些判断条件来剪枝



##### 代码

1. 返回值类型为 boolean

```java
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        path = new boolean[numCourses];
        visited = new boolean[numCourses];


        LinkedList<Integer>[] graph = new LinkedList[numCourses];
        for(int i=0; i<numCourses; i++){
            graph[i] = new LinkedList<>();
        }
        for(int[] tmp : prerequisites){
            graph[tmp[1]].addLast(tmp[0]);
        }

        for(int i=0; i<numCourses; i++){
            if(!dfs(graph, i)){
                return false;
            }
        }

        return true;

    }

    boolean[] path;
    boolean[] visited;

    public boolean dfs(LinkedList<Integer>[] graph, int cur){

        
        if(path[cur]){
            return false;
        }

        if(visited[cur]){
            return true;
        }

        path[cur] = true;
        visited[cur] = true;

        for(int next : graph[cur]){
            if(!dfs(graph, next)){
                return false;
            }
        }

        path[cur] = false;
        // visited[cur] = false;

        return true;

    }


}
```

2. 返回值类型为 void

```java
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        path = new boolean[numCourses];
        visited = new boolean[numCourses];
        hasCycle = false;

        LinkedList<Integer>[] graph = new LinkedList[numCourses];
        for(int i=0; i<numCourses; i++){
            graph[i] = new LinkedList<>();
        }
        for(int[] tmp : prerequisites){
            graph[tmp[1]].addLast(tmp[0]);
        }

        for(int i=0; i<numCourses; i++){
            dfs(graph, i);
        }

        return !hasCycle;

    }

    boolean[] path;
    boolean[] visited;
    boolean hasCycle;

    public void dfs(LinkedList<Integer>[] graph, int cur){

        if(hasCycle){
            return;
        }
        
        if(path[cur]){
            hasCycle = true;
            return;
        }

        if(visited[cur]){
            return;
        }

        path[cur] = true;
        visited[cur] = true;

        for(int next : graph[cur]){
            dfs(graph, next);
        }

        path[cur] = false;
        // visited[cur] = false;


    }


}
```

3. BFS的入度方法

```java
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        LinkedList<Integer>[] graph = new LinkedList[numCourses];
        int[] indegree = new int[numCourses];

        for(int i=0; i<numCourses; i++){
            graph[i] = new LinkedList<>();
        }

        for(int[] tmp : prerequisites){
            indegree[tmp[0]]++;
            graph[tmp[1]].addLast(tmp[0]);
        }

        ArrayDeque<Integer> q = new ArrayDeque<>();

        for(int i=0; i<numCourses; i++){
            if(indegree[i]==0){
                q.addLast(i);
            }
        }

        LinkedList<Integer> res = new LinkedList<>();

        while(!q.isEmpty()){
            int cur = q.removeFirst();
            res.addLast(cur);

            for(int next : graph[cur]){
                indegree[next]--;
                if(indegree[next]==0){
                    q.addLast(next);
                }
            }

        }

        return res.size()==numCourses;
    }
}
```

