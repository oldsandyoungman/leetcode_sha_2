package com.example.leetcode_sha_2.jian_zhi_offer;

public class s36 {

    public static void main(String[] args) {

    }

//    输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的循环双向链表。要求不能创建任何新的节点，只能调整树中节点指针的指向。
//
//             
//
//    为了让您更好地理解问题，以下面的二叉搜索树为例：
//
//    来源：力扣（LeetCode）
//    链接：https://leetcode-cn.com/problems/er-cha-sou-suo-shu-yu-shuang-xiang-lian-biao-lcof
//    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。


    public Node pre, head;
    public Node treeToDoublyList(Node root) {
        if(root==null){
            return null;
        }
        traverse(root);
        head.left = pre;
        pre.right = head;
        return head;
    }

    public void traverse(Node cur){
        if(cur==null){
            return;
        }
        traverse(cur.left);

        if(pre==null){
            head = cur;
        }else{
            pre.right = cur;
        }
        cur.left = pre;
        pre = cur;
        traverse(cur.right);

    }

}
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
}