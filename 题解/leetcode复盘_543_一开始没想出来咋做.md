很多题目还是一错再错，决定做个复盘，记录下自己哪里写错了



[TOC]

#### [543. 二叉树的直径](https://leetcode-cn.com/problems/diameter-of-binary-tree/)

> 给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过也可能不穿过根结点。
>
> 
>
> **注意：**两结点之间的路径长度是以它们之间边的数目表示。



##### 思路

转化成求最大深度，直径等于左右子树的深度相加

> 一开始没想到这一层，卡了挺久



> 2022.2.23
>
> 居然还是不会，不过这次只是做错，没想到最大直径不一定是经过根节点



##### 注意点

这个题也提醒我们，有时候dfs的定义不一定是最后要求的解，而是可以在求的过程中计算得到的



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
    public int diameterOfBinaryTree(TreeNode root) {
        max = 0;
        dfs(root);
        return max;
    }

    public int max;

    public int dfs(TreeNode root){
        if(root==null){
            return 0;
        }

        int left = dfs(root.left);
        int right = dfs(root.right);
        max = Math.max(max, left+right);

        return 1+Math.max(left, right);

    }

}
```

