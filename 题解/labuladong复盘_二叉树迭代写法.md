很多题目还是一错再错，决定做个复盘，记录下自己哪里写错了



[TOC]

#### [二叉树的迭代写法](https://labuladong.gitee.io/algo/2/18/33/)

> 二叉树八股文：递归改迭代



##### 思路

核心需要：

- 一个栈：记录迭代访问的节点

- 一个visited指针：判断当前是中序还是后序遍历的结果。如果是中序，那么左子树是null或者是visited且右子树不是visited

  > 如果 left==null || left==visited，并且right!=visited，那么就是中序遍历
  >
  > 如果 right==null || right==visited，那么就是后续遍历





##### 注意点

- 中序遍历要额外pushleft右子树，后续遍历要弹出栈中元素，并且更新为visited
- 中序遍历判断的 `right!=visited`不能省，不然 [1, null, 2, 3, null]，就会一直在[2,3]间来回走



##### 代码

```java
public static List<Integer> res;

    public static ArrayDeque<TreeNode> q;

    public static void pushLeft(TreeNode root){
        while(root!=null){
            q.addLast(root);

            // 前序


            root = root.left;
        }
    }

    public static List<Integer> traverse(TreeNode root){
        res = new ArrayList<>();
        q = new ArrayDeque<>();

        pushLeft(root);

        TreeNode visited = new TreeNode(-1);

        while(!q.isEmpty()){
            TreeNode cur = q.getLast();

            if ((cur.left==null || cur.left==visited)) {

                // 中序遍历

                pushLeft(cur.right);

            }

            if (cur.right==null || cur.right==visited) {
                res.add(cur.val);
                visited = q.removeLast();

            }



        }

        return res;

    }

```
