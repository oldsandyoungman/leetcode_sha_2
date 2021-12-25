package com.example.leetcode_sha_2.leetcode_origin;

import java.util.ArrayDeque;

public class s117 {

    public static void main(String[] args) {

//[1,2,3,4,5,null,6,7,null,null,null,null,8]

        Node a = new Node(1);
        Node b = new Node(2);
        Node c = new Node(3);
        Node d = new Node(4);
        Node e = new Node(5);
        Node f = new Node(6);
        Node g = new Node(7);
        Node h = new Node(8);

        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        c.right = f;
        d.left = g;
        f.right = h;

        Node res = connect(a);
        System.out.println("111");

    }

//    给定一个二叉树
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
//    进阶：
//
//    你只能使用常量级额外空间。
//    使用递归解题也符合要求，本题中递归程序占用的栈空间不算做额外的空间复杂度。
//
//
//    来源：力扣（LeetCode）
//    链接：https://leetcode-cn.com/problems/populating-next-right-pointers-in-each-node-ii
//    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。


    public static Node connect(Node root) {
        if (root==null){
            return null;
        }
        ArrayDeque<Node> q = new ArrayDeque<>();
        q.addLast(root);

        while(!q.isEmpty()){
            int n = q.size();
            Node pre = q.removeFirst();
            if(pre.left!=null){
                q.addLast(pre.left);
            }
            if(pre.right!=null){
                q.addLast(pre.right);
            }
            for(int i=1; i<n; i++){
                Node cur = q.removeFirst();
                pre.next = cur;
                pre = cur;
                if(pre.left!=null){
                    q.addLast(pre.left);
                }
                if(pre.right!=null){
                    q.addLast(pre.right);
                }
            }
        }

        return root;

    }


//  在普通二叉树的时候，左子树的每一层连接到右子树，很麻烦，while里面不好写
    public static Node connect2(Node root) {
        traverse(root);
        return root;
    }
    public static void traverse(Node root){
        if(root==null){
            return;
        }
        traverse(root.left);
        traverse(root.right);

        if(root.val==1){
            System.out.println("111");
        }

        Node l = root.left;
        Node r = root.right;
        while(l!=null && r!=null){
            l.next = r;
            l = l.right==null?l.left:l.right;
            r = r.left==null?r.right:r.left;
        }
    }

}
/*
// Definition for a Node.
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
};
*/