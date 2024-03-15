/*******************************************************

 Following is the BinaryTreeNode class structure:

 class BinaryTreeNode<T> {
     T data;
     BinaryTreeNode<T> left;
     BinaryTreeNode<T> right;

     public BinaryTreeNode(T data) {
         this.data = data;
         this.left = null;
         this.right = null;
     }
 }

 *******************************************************/

 public class Solution {
    public static boolean rec(BinaryTreeNode<Integer> a,BinaryTreeNode<Integer> b){
        if(a==null && b==null) return true;
        if(a==null|| b==null) return false;
        if(a.data!=b.data) return false;
        boolean l=rec(a.left,b.left);
        boolean r=rec(a.right,b.right);
        return l&&r;
    }
    public static boolean identicalTrees(BinaryTreeNode<Integer> root1, BinaryTreeNode<Integer> root2) {
        return rec(root1,root2);
    }
}