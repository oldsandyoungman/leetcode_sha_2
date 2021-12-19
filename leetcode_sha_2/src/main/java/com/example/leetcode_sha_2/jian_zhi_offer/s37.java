package com.example.leetcode_sha_2.jian_zhi_offer;

import com.example.leetcode_sha_2.class_sha.TreeNode;

import java.util.ArrayDeque;

public class s37 {

    public static void main(String[] args) {
        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(3);
        TreeNode d = new TreeNode(4);
        TreeNode e = new TreeNode(5);

        a.left = b;
        a.right = c;
        c.left = d;
        c.right = e;

        String tmp = serialize(a);
        System.out.println(tmp);
        TreeNode res = deserialize(tmp);
        System.out.println(res);

//        ArrayDeque<Integer> q = new ArrayDeque<>();
//        q.addLast(1);
//        q.clear();
//        System.out.println();
    }

//    请实现两个函数，分别用来序列化和反序列化二叉树。
//
//    你需要设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 / 反序列化算法执行逻辑，你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串反序列化为原始的树结构。
//
//    提示：输入输出格式与 LeetCode 目前使用的方式一致，详情请参阅 LeetCode 序列化二叉树的格式。你并非必须采取这种方式，你也可以采用其他的方法解决这个问题。
//
//    来源：力扣（LeetCode）
//    链接：https://leetcode-cn.com/problems/xu-lie-hua-er-cha-shu-lcof
//    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

    public static String SEP = ",";
    public static String NULL = "#";

    // Encodes a tree to a single string.
    public static String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        traverse(root, sb);
        return sb.toString();
    }
    public static void traverse(TreeNode root, StringBuilder sb){
        if(root==null){
            sb.append(NULL).append(SEP);
            return;
        }
        sb.append(root.val).append(SEP);
        traverse(root.left, sb);
        traverse(root.right, sb);
    }

    // Decodes your encoded data to tree.
    public static TreeNode deserialize(String data) {
        String[] ss = data.split(SEP);
        ArrayDeque<String> q = new ArrayDeque<>();
        for(String s : ss){
            q.addLast(s);
        }
        return traverse2(q);

    }
    public static TreeNode traverse2(ArrayDeque<String> q){
        if(q.isEmpty()){
            return null;
        }
        if(NULL.equals(q.getFirst())){
            q.removeFirst();
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(q.removeFirst()));
        root.left = traverse2(q);
        root.right = traverse2(q);
        return root;
    }

}


