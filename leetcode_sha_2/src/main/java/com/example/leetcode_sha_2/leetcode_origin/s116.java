package com.example.leetcode_sha_2.leetcode_origin;

public class s116 {

    public static void main(String[] args) {

    }

//    给定一个 完美二叉树 ，其所有叶子节点都在同一层，每个父节点都有两个子节点。二叉树定义如下：
//
//    struct Node {
//        int val;
//        Node *left;
//        Node *right;
//        Node *next;
//    }
//    填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
//
//    初始状态下，所有 next 指针都被设置为 NULL。
//
//             
//
//    进阶：
//
//    你只能使用常量级额外空间。
//    使用递归解题也符合要求，本题中递归程序占用的栈空间不算做额外的空间复杂度。
//
//    来源：力扣（LeetCode）
//    链接：https://leetcode-cn.com/problems/populating-next-right-pointers-in-each-node
//    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。


    public Node connect(Node root) {
        if(root==null){
            return null;
        }
        connect(root.left);
        connect(root.right);

        Node l = root.left;
        Node r = root.right;
        while(l!=null){
            l.next = r;
            l = l.right;
            r = r.left;
        }

        return root;

    }
}


class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}