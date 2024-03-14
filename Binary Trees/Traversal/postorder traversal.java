/*******************************************************
 Following is the TreeNode class structure

 class TreeNode<T> {
     T data;
     TreeNode<T> left;
     TreeNode<T> right;

     public TreeNode() {
         this.data = null;
         this.left = null;
         this.right = null;
     }

     public TreeNode(T x) {
         this.data = x;
         this.left = null;
         this.right = null;
     }

     public TreeNode(T x, TreeNode<T> left, TreeNode<T> right) {
         this.data = x;
         this.left = left;
         this.right = right;
     }
 };
 *******************************************************/

 import java.util.*;
 public class Solution {
     // public static void rec(TreeNode<Integer> root,List<Integer> a){
     //     if(root==null) return;
     //     rec(root.left,a);
     //     rec(root.right,a);
     //     a.add(root.data);
     // }
     public static List<Integer> postorderTraversal(TreeNode<Integer> root) {
         List<Integer> a=new ArrayList<>();
         // rec(root,a);
         // return a;
         Stack<TreeNode<Integer>> s1=new Stack<>();
         // Stack<TreeNode<Integer>> s2=new Stack<>();
         // s1.push(root);
         // while(!s1.isEmpty()){
         //     root=s1.pop();
         //     s2.push(root);
         //     if(root.left!=null){
         //         s1.push(root.left);
         //     }
         //     if(root.right!=null){
         //         s1.push(root.right);
         //     }
         // }
         // while(!s2.isEmpty()){
         //     a.add(s2.pop().data);
         // }
         // return a;
         s1.add(root);
         while(!s1.isEmpty()){
             root=s1.pop();
             a.add(root.data);
             if(root.left!=null){
                 s1.add(root.left);
             }
             if(root.right!=null){
                 s1.add(root.right);
             }
         }
         Collections.reverse(a);
         return a;
     }
 }
 