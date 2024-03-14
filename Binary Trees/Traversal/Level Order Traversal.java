/*********************************************************

 Following is the TreeNode structure:

 class TreeNode<T>
 {
     T data;
     TreeNode<T> left;
     TreeNode<T> right;

     TreeNode(T data)
     {
         this.data = data;
         left = null;
         right = null;
     }
 };
 ********************************************************/

 import java.util.*;
 public class Solution {
     public static List<Integer> levelOrder(TreeNode<Integer> root){
         // List<Integer> ans=new ArrayList<>();
         // Queue<TreeNode<Integer>> a=new LinkedList<>();
         // a.add(root);
         // while(!a.isEmpty()){
         //     TreeNode<Integer> node=a.poll();
         //     ans.add(node.data);
         //     if(node.left!=null){
         //         a.add(node.left);
         //     }
         //     if(node.right!=null)
         //         a.add(node.right);
         // }
         // return ans;
         List<Integer> a=new ArrayList<>();
         Queue<TreeNode<Integer>> s=new LinkedList<>();
         s.add(root);
         while(!s.isEmpty()){
             TreeNode<Integer> b=s.poll();
             a.add(b.data);
             if(b.right!=null){
                 s.add(b.right);
             }
             if(b.left!=null){
                 s.add(b.left);
             }
         }
         return a;
     }
 }