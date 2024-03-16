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
    public static TreeNode build(int[] inorder,int[] preorder,int instart,int inend,int prestart,int preend,Map<Integer,Integer> map){
        if(instart>inend || prestart>preend) return null;
        TreeNode root=new TreeNode(preorder[prestart]);
        int inroot=map.get(root.data);
        int numleft=inroot-instart;
        root.left=build(inorder,preorder,instart,inroot-1,prestart+1,prestart+numleft+1,map);
        root.right=build(inorder,preorder,inroot+1,inend,prestart+numleft+1,preend,map);
        return root;
    }
    public static TreeNode buildBinaryTree(int[] inorder, int[] preorder) {
        Map<Integer,Integer> map=new TreeMap<>();
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        TreeNode curr=build(inorder,preorder,0,inorder.length,0,preorder.length-1,map);
        return curr;
    }
}