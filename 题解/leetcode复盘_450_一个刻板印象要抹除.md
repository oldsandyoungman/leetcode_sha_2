很多题目还是一错再错，决定做个复盘，记录下自己哪里写错了



[TOC]

#### [450. 删除二叉搜索树中的节点](https://leetcode-cn.com/problems/delete-node-in-a-bst/)

> 给定一个二叉搜索树的根节点 root 和一个值 key，删除二叉搜索树中的 key 对应的节点，并保证二叉搜索树的性质不变。返回二叉搜索树（有可能被更新）的根节点的引用。
>
> 一般来说，删除节点可分为两个步骤：
>
> 首先找到需要删除的节点；
> 如果找到了，删除它。
>
> 
>
> 提示:
>
> 节点数的范围 [0, 104].
> -105 <= Node.val <= 105
> 节点值唯一
> root 是合法的二叉搜索树
> -105 <= key <= 105



##### 思路

两个步骤：

- 找到目标节点

- 删除目标节点
  - 如果为空，直接删
  - 如果只有一个子树，返回那个子树即可
  - 如果两边都有子树，找到一边的最值节点，先删除再用目标值节点指向，最后返回即可





##### 注意点

- 二叉树题目的一个很有用的技巧，返回类型设为TreeNode，这样上一级调用写成：

  ```java
  root.left = dfs(root.left)
  ```

  就可以改变两层之间的相互关系

- 之前一直有的刻板印象要抹除，即删除节点是完全可以不改变节点值来达成的（参考思路的2.3）

- 思路的2.3，删 min 节点的时候，还是得用注意点第一点的格式，不然会成环

  ```java
  root.right = dfs(root.right, min.val);
  ```





##### 代码

```java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        return dfs(root, key);
    }

    public TreeNode dfs(TreeNode root, int key){
        if(root==null){
            return null;
        }
        if(root.val<key){
            root.right = dfs(root.right, key);
        }else if(root.val>key){
            root.left = dfs(root.left, key);
        }else{
            if(root.left==null){
                return root.right;
            }
            if(root.right==null){
                return root.left;
            }
            TreeNode min = findMin(root.right);
            root.right = dfs(root.right, min.val);
            min.left = root.left;
            min.right = root.right;
            return min;
        }
        return root;
    }

    public TreeNode findMin(TreeNode root){
        TreeNode min = root;
        while(min.left!=null){
            min = min.left;
        }
        return min;
    }

}
```

2. patience sort方法

```java
class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        int n = envelopes.length;
        Arrays.sort(envelopes, (o1, o2) -> {
            if(o1[0]==o2[0]){
                return Integer.compare(o2[1], o1[1]);
            }else{
                return Integer.compare(o1[0], o2[0]);
            }
        });

        // 最长递增子序列
        //// patience game 方法
        int[] top = new int[n];
        int piles = 0;

        for(int i=0; i<n; i++){
            int tar = envelopes[i][1];
            int left = 0;
            int right = piles - 1;
            while(left<=right){
                int mid = left + (right-left)/2;
                if(top[mid]<tar){
                    left = mid + 1;
                }else{
                    right = mid -1;
                }
            }
            if(left>=piles){
                piles++;
            }
            top[left] = tar;
        }

        return piles;  

    }
}
```
