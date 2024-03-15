/************************************************************

 Following is the Binary Tree node structure:

 class TreeNode {
     int data;
     TreeNode left;
     TreeNode right;

     TreeNode(int data) {
         this.data = data;
         this.left = null;
         this.right = null;
     }
 }

 ************************************************************/

 import java.util.*;

 public class Solution {
     public static boolean isLeaf(TreeNode root){
         return root.left==null && root.right==null;
     }
     public static void addLeft(TreeNode root,List<Integer> bound){
         root=root.left;
         while(root!=null){
             if(!isLeaf(root)) bound.add(root.data);
             if(root.left!=null) root=root.left;
             else root=root.right;
         }
     }
     public static void addRight(TreeNode root,List<Integer> bound){
         List<Integer> temp=new ArrayList<>();
         root=root.right;
         while(root!=null){
             if(!isLeaf(root)) temp.add(root.data);
             if(root.right!=null) root=root.right;
             else root=root.left;
         }
         for(int i=temp.size()-1;i>=0;i--)
             bound.add(temp.get(i));
     }
     public static void addLeaf(TreeNode root,List<Integer> bound){
         if(isLeaf(root)) {
             bound.add(root.data);
             return;
         }
         if(root.left!=null) addLeaf(root.left,bound);
         if(root.right!=null) addLeaf(root.right,bound);
     }
     public static List<Integer> traverseBoundary(TreeNode root){
         List<Integer> bound=new ArrayList<>();
         if(!isLeaf(root)) bound.add(root.data);
         addLeft(root,bound);
         addLeaf(root,bound);
         addRight(root,bound);
         return bound;
     }
 }