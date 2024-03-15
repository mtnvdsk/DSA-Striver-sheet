/************************************************************

 Following is the TreeNode class structure

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

 ************************************************************/

 public class Solution {
    public static TreeNode<Integer> rec(TreeNode<Integer> root,int x,int y){
        if(root==null|| root.data==x || root.data==y) {
           return root;
       }
       TreeNode<Integer> left=rec(root.left, x, y);
       TreeNode<Integer> right=rec(root.right, x, y);
       if(left==null) return right;
       else if(right==null) return left;
       else{
           return root;
       }
    }
    public static int lowestCommonAncestor(TreeNode<Integer> root, int x, int y) {
       TreeNode<Integer> a=rec(root,x,y);
       return a.data;
    }
}
