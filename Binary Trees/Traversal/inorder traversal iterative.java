/*
    Following is the TreeNode class structure:

    public class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;
        TreeNode() {
            this.data = 0;
            this.left = null;
            this.right = null;
        }
        TreeNode(int val) {
            this.data = val;
            this.left = null;
            this.right = null;
        }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.data = val;
            this.left = left;
            this.right = right;
        }
    };
*/

import java.util.*;

public class Solution {
    // public static void rec(TreeNode root,List<Integer> a){
    //     if(root==null) return;
    //     rec(root.left,a);
    //     a.add(root.data);
    //     rec(root.right,a);
    // }
    public static List< Integer > getInOrderTraversal(TreeNode root) {
        // List<Integer> a=new ArrayList<>();
        // rec(root,a);
        // return a;
        // List<Integer> s=new ArrayList<>();
        // Stack<TreeNode> a=new Stack<>();
        // while(true){
        //     if(root!=null){
        //         a.push(root);
        //         root=root.left;
        //     }
        //     else{
        //         if(a.isEmpty()) break;
        //         root=a.pop();
        //         s.add(root.data);
        //         root=root.right;
        //     }
        // }
        // return s;

        //morris traversal

        List<Integer> a=new ArrayList<>();
        TreeNode cur=root;
        while(cur!=null){
            if(cur.left==null){
                a.add(cur.data);
                cur=cur.right;
            }
            else{
                TreeNode temp=cur.left;
                while(temp.right!=null && temp.right!=cur){
                    temp=temp.right;
                }
                if(temp.right==null){
                    temp.right=cur;
                    cur=cur.left;
                }
                else{
                    temp.right=null;
                    a.add(cur.data);
                    cur=cur.right;
                }
            }
        }
        return a;
    }
}