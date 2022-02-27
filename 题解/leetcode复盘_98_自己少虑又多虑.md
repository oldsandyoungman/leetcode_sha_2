很多题目还是一错再错，决定做个复盘，记录下自己哪里写错了



[TOC]

#### [98. 验证二叉搜索树](https://leetcode-cn.com/problems/validate-binary-search-tree/)

> 给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。
>
> 有效 二叉搜索树定义如下：
>
> 节点的左子树只包含 小于 当前节点的数。
> 节点的右子树只包含 大于 当前节点的数。
> 所有左子树和右子树自身必须也是二叉搜索树。
>
> 
>
> **提示：**
>
> - 树中节点数目范围在`[1, 104]` 内
> - `-231 <= Node.val <= 231 - 1`



##### 思路

需要在递归的时候，额外加入最大值和最小值都参数即可，每次递归判断是否会非法



##### 注意点

因为测试用例会有 Integer.MAX_VALUE，所以还是得用Integer类型的null优势，来辅助判断

> Integer本身在递归时并不需要很多操作，直接传就行，是我自己多虑了而已



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
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, null, null);
    }

    public boolean isValidBST(TreeNode root, Integer min, Integer max){
        if(root==null){
            return true;
        }

        if(min!=null && root.val<=min){
            return false;
        }

        if(max!=null && root.val>=max){
            return false;
        }

        return isValidBST(root.left, min, root.val) && isValidBST(root.right, root.val, max);

    }

}
```



