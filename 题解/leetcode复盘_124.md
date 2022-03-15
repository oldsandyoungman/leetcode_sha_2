很多题目还是一错再错，决定做个复盘，记录下自己哪里写错了



[TOC]

#### [124. 二叉树中的最大路径和](https://leetcode-cn.com/problems/binary-tree-maximum-path-sum/)

> 路径 被定义为一条从树中任意节点出发，沿父节点-子节点连接，达到任意节点的序列。同一个节点在一条路径序列中 至多出现一次 。该路径 至少包含一个 节点，且不一定经过根节点。
>
> 路径和 是路径中各节点值的总和。
>
> 给你一个二叉树的根节点 root ，返回其 最大路径和 。
>
> **提示：**
>
> - 树中节点数目范围是 `[1, 3 * 104]`
> - `-1000 <= Node.val <= 1000`





##### 思路

基本上会想到是用后序遍历，利用子树信息来做，然后 `dfs` 函数的定义应该也想得出来，就是返回以根节点开始的最大路径和（末尾不一定是叶子节点），但是中间的逻辑可能要稍微斟酌一下：

> 最后的答案，无非几种形式：
>
> 1. 中间节点+左子树+右子树
> 2. 中间节点+左子树
> 3. 中间节点+右子树
> 4. 中间节点



> 所以在已知左右子树的dfs函数值后，每次更新答案 res 无非那么几种：
>
> 1. root.val + l_max + r_max
> 2. root.val + l_max
> 3. root.val + r_max
> 4. root.val



**特别注意：反正每次都会更新res，所以可以在每次的函数里，只考虑包含root的上述四种情况，至于只有左子树/右子树，那是之前几轮里会更新的，不用担心**



> 最后的返回值，也是取这几者中的最大值：
>
> 1. root.val + l_max
> 2. root.val + r_max
> 3. root.val





综上的逻辑，可以总结如下：

```java
int l_max = Math.max(dfs(root.left), 0);
int r_max = Math.max(dfs(root.right), 0);

int cur = root.val+l_max+r_max;

res = Math.max(res, cur);

return Math.max(l_max, r_max) + root.val;
```





##### 注意点

相同上面的分析以后，就没啥好注意的



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
    public int maxPathSum(TreeNode root) {
        res = Integer.MIN_VALUE;
        dfs(root);
        return res;
    }

    int res;

    // 以根节点为开始，到叶子节点的最大路径和
    public int dfs(TreeNode root){
        if(root==null){
            return 0;
        }

        int l_max = Math.max(dfs(root.left), 0);
        int r_max = Math.max(dfs(root.right), 0);

        int cur = root.val+l_max+r_max;

        res = Math.max(res, cur);

        return Math.max(l_max, r_max) + root.val;

    }

}
```

