/*********************************************************

 Following is the TreeNode structure:

 class TreeNode {
     int data;
     TreeNode left;
     TreeNode right;
     TreeNode() {
         this.data = 0;
         this.left = null;
         this.right = null;
     }
     TreeNode(int data) {
         this.data = data;
         this.left = null;
         this.right = null;
     }
     TreeNode(int data, TreeNode left, TreeNode right) {
         this.data = data;
         this.left = left;
         this.right = right;
     }
 };
 ********************************************************/

 import java.util.*;
 public class Solution {
     public static void pred(TreeNode root,List<Integer> a,int k){
         if(root==null) return;
         else if(root.data>=k){
             pred(root.left,a,k);
         }
         else if(root.data<k){
             a.set(0,root.data);
             pred(root.right,a,k);
         }
     }
     public static void suc(TreeNode root,List<Integer> a,int k){
         if(root==null) return;
         else if(root.data>k){
             a.set(1,root.data);
             suc(root.left,a,k);
         }
         else if(root.data<=k){
             suc(root.right,a,k);
         }
     }
     public static List<Integer> predecessorSuccessor(TreeNode root, int key) {
         List<Integer> inorder=new ArrayList<>();
         inorder.add(-1);
         inorder.add(-1);
         pred(root,inorder,key);
         suc(root,inorder,key);
         return inorder;
     }
 }