/*************************************************************

 Following is the Binary Tree Node structure:

 class TreeNode<T> {
     public T data;
     public BinaryTreeNode<T> left;
     public BinaryTreeNode<T> right;

     TreeNode(T data) {
         this.data = data;
         left = null;
         right = null;
     }
 }

 *************************************************************/

 public class Solution {
    public static int rec(TreeNode<Integer> a,int[] max){
        if(a==null) return 0;
        int lh=rec(a.left,max);
        int rh=rec(a.right,max);
        max[0]=Math.max(max[0],lh+rh);
        return 1+Math.max(lh,rh);
    }
    public static int diameterOfBinaryTree(TreeNode<Integer> root) {
        int []max=new int[1];
        rec(root,max);
        return max[0];
    }
}