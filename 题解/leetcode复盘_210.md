很多题目还是一错再错，决定做个复盘，记录下自己哪里写错了



[TOC]

#### [210. 课程表 II](https://leetcode-cn.com/problems/course-schedule-ii/)

> 现在你总共有 numCourses 门课需要选，记为 0 到 numCourses - 1。给你一个数组 prerequisites ，其中 prerequisites[i] = [ai, bi] ，表示在选修课程 ai 前 必须 先选修 bi 。
>
> 例如，想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表示：[0,1] 。
> 返回你为了学完所有课程所安排的学习顺序。可能会有多个正确的顺序，你只要返回 任意一种 就可以了。如果不可能完成所有课程，返回 一个空数组 。
>
> 提示：
>
> - 1 <= numCourses <= 2000
> - 0 <= prerequisites.length <= numCourses * (numCourses - 1)
> - prerequisites[i].length == 2
> - 0 <= ai, bi < numCourses
> - ai != bi
> - 所有[ai, bi] 互不相同



##### 思路

大体思路同 Leetcode_207，需要额外考虑的是，如何记录上课顺序：

- 对于DFS来说，上课顺序跟后续遍历有关，毕竟要把所有子树搞完才能搞自己，根据这一特性，只要把后序遍历倒序一下，就是题目要求的答案了
- 对于BFS来说，本身从队列中拿出来的顺序，就可以作为上课的顺序



##### 注意点

- BFS中，可以直接用数组+index来记录结果，这样可以省去一个LinkedList作为中间转换




##### 代码

1. 返回值类型为 boolean 的DFS

```java
class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        
        onPath = new boolean[numCourses];
        visited = new boolean[numCourses];

        LinkedList<Integer>[] graph = new LinkedList[numCourses];
        for(int i=0; i<numCourses; i++){
            graph[i] = new LinkedList<>();
        }
        // for(LinkedList<Integer> cur : graph){
        //     cur = new LinkedList<>();
        // }

        for(int[] cur : prerequisites){
            graph[cur[1]].addLast(cur[0]);
        }

        res = new LinkedList<>();

        for(int i=0; i<numCourses; i++){
            if(!dfs(graph, i, res)){
                return new int[0];
            }
        }

        int[] result = new int[numCourses];
        for(int i=0; i<numCourses; i++){
            result[i] = res.removeLast();
        } 

        return result;
    }

    LinkedList<Integer> res;

    boolean[] onPath;
    boolean[] visited;

    public boolean dfs(LinkedList<Integer>[] graph, int start, LinkedList<Integer> res){
        if(onPath[start]){
            return false;
        }

        if(visited[start]){
            return true;
        }

        onPath[start] = true;
        visited[start] = true;

        for(int next : graph[start]){
            if(!dfs(graph, next, res)){
                return false;
            }
        }

        res.addLast(start);

        onPath[start] = false;

        return true;

    }

}
```

2. 返回值类型为 void 的 DFS

```java
class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        
        onPath = new boolean[numCourses];
        visited = new boolean[numCourses];
        hasCycle = false;

        LinkedList<Integer>[] graph = new LinkedList[numCourses];
        for(int i=0; i<numCourses; i++){
            graph[i] = new LinkedList<>();
        }
        // for(LinkedList<Integer> cur : graph){
        //     cur = new LinkedList<>();
        // }

        for(int[] cur : prerequisites){
            graph[cur[1]].addLast(cur[0]);
        }

        res = new LinkedList<>();

        for(int i=0; i<numCourses; i++){
            dfs(graph, i, res);
        }

        if(hasCycle){
            return new int[0];
        }

        int[] result = new int[numCourses];
        for(int i=0; i<numCourses; i++){
            result[i] = res.removeLast();
        } 

        return result;
    }

    LinkedList<Integer> res;

    boolean[] onPath;
    boolean[] visited;
    boolean hasCycle;

    public void dfs(LinkedList<Integer>[] graph, int start, LinkedList<Integer> res){
        if(hasCycle){
            return;
        }
        if(onPath[start]){
            hasCycle = true;
            return;
        }
        if(visited[start]){
            return;
        }

        onPath[start] = true;
        visited[start] = true;

        for(int next : graph[start]){
            dfs(graph, next, res);
        }

        res.addLast(start);

        onPath[start] = false;

    }

}
```

3. BFS的入度方法

```java
class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {

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

        int[] res = new int[numCourses];
        int count = 0;

        while(!q.isEmpty()){
            int cur = q.removeFirst();
            res[count] = cur;
            count++;

            for(int next : graph[cur]){
                indegree[next]--;
                if(indegree[next]==0){
                    q.addLast(next);
                }
            }

        }

        if(count<numCourses){
            return new int[0]; 
        }

        return res;


    }
}
```

