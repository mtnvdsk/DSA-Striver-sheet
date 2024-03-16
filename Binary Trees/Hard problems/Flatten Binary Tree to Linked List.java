import java.util.* ;
import java.io.*; 
/************************************************************

    Following is the TreeNode class structure.

	class TreeNode<T> 
	{
	    public T data;
	    public TreeNode<T> left;
	    public TreeNode<T> right;

	    TreeNode(T data) 
	    {
	        this.data = data;
	        left = null;
	        right = null;
	    }
	}

************************************************************/

public class Solution 
{
   public static void helper(TreeNode<Integer> root, TreeNode<Integer>[] prev){
        if(root==null){
            return;
        }
        helper(root.right, prev);
        helper(root.left, prev);
        root.right = prev[0];
        root.left = null;
        prev[0] = root;
    }
    public static TreeNode<Integer> flattenBinaryTree(TreeNode<Integer> root)
    {
        TreeNode<Integer>[] prev = new TreeNode[]{null};
        helper(root, prev);
        return root;
    } 
}