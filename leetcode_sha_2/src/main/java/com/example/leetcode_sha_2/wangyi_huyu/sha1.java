package com.example.leetcode_sha_2.wangyi_huyu;

import com.example.leetcode_sha_2.class_sha.TreeNode;

import java.util.*;

public class sha1 {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] inorder = new int[n];
        int[] postorder = new int[n];

        HashMap<Integer, Integer> memo = new HashMap<>();

        for(int i=0; i<n; i++){
            int tmp = in.nextInt();
            memo.put(tmp, i);
            inorder[i] = i;
        }
        for(int i=0; i<n; i++){
            int tmp = in.nextInt();
            postorder[i] = memo.get(tmp);
        }

        res = 0;
        buildTree(n, inorder, postorder);
//         dfs(root);
        System.out.println(res);
    }
    static int res;
    public static void buildTree(int n, int[] inorder, int[] postorder){
        buildTree(inorder, 0, n-1, postorder, 0, n-1);
    }
    public static TreeNode buildTree(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd){
        if(inStart>inEnd){
            return null;
        }
        TreeNode root = new TreeNode(postorder[postEnd]);


//         int index = inStart;
//         for(; index<=inEnd; index++){
//             if(inorder[index]==postorder[postEnd]){
//                 break;
//             }
//         }
        int index = inStart;
        int target = postorder[postEnd];
        int ll = inStart;
        int rr = inEnd;
        while(ll<=rr){
            int mid = ll+(rr-ll)/2;
            if(inorder[mid]<target){
                ll = mid + 1;
            }else if(inorder[mid]>target){
                rr = mid - 1;
            }else{
                index = mid;
            }
        }

        int len = index - inStart;

        TreeNode l = buildTree(inorder, inStart, index-1, postorder, postStart, postStart+len-1);
        TreeNode r = buildTree(inorder, index+1, inEnd, postorder, postStart+len, postEnd-1);

        root.left = l;
        root.right = r;

        res = Math.max(res, ((l==null)?0:l.val) + ((r==null)?0:r.val));

        int new_depth = Math.max((l==null)?0:l.val , (r==null)?0:r.val)+1;

        root.val = new_depth;

        return root;
    }


}



//import java.util.*;
//
//public class Main{
//
//    public static void main(String[] args){
//        Scanner in = new Scanner(System.in);
//        int n = in.nextInt();
//        int[] inorder = new int[n];
//        int[] postorder = new int[n];
//        for(int i=0; i<n; i++){
//            inorder[i] = in.nextInt();
//        }
//        for(int i=0; i<n; i++){
//            postorder[i] = in.nextInt();
//        }
//        res = 0;
//        buildTree(n, inorder, postorder);
////         dfs(root);
//        System.out.println(res);
//    }
//    static int res;
//    public static void buildTree(int n, int[] inorder, int[] postorder){
//        buildTree(inorder, 0, n-1, postorder, 0, n-1);
//    }
//    public static data_sha buildTree(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd){
//        if(inStart>inEnd){
//            return new data_sha(null, 0);
//        }
//        TreeNode root = new TreeNode(postorder[postEnd]);
//        int index = inStart;
//        for(; index<=inEnd; index++){
//            if(inorder[index]==postorder[postEnd]){
//                break;
//            }
//        }
//        int len = index - inStart;
//
//        data_sha l_data_sha = buildTree(inorder, inStart, index-1, postorder, postStart, postStart+len-1);
//        data_sha r_data_sha = buildTree(inorder, index+1, inEnd, postorder, postStart+len, postEnd-1);
//
//        root.left = l_data_sha.root;
//        root.right = r_data_sha.root;
//
//        res = Math.max(res, l_data_sha.depth + r_data_sha.depth);
//
//        int new_depth = Math.max(l_data_sha.depth, r_data_sha.depth)+1;
//
//        return new data_sha(root, new_depth);
//    }
//
////     // 返回值是树的深度
////     public static int dfs(TreeNode root){
////         if(root==null){
////             return 0;
////         }
////         int l = dfs(root.left);
////         int r = dfs(root.right);
//
////         res = Math.max(res, l+r);
//
////         return Math.max(l, r)+1;
//
////     }
//
//
//}
//
//
//class TreeNode{
//    int val;
//    TreeNode left;
//    TreeNode right;
//
//    public TreeNode(int val){
//        this.val = val;
//    }
//
//}
//
//class data_sha{
//
//    TreeNode root;
//    int depth;
//
//    public data_sha(TreeNode root, int depth){
//        this.root = root;
//        this.depth = depth;
//    }
//
//
//}