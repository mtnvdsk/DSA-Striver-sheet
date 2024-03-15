/************************************************************

 Following is the BinaryTreeNode class structure
 class BinaryTreeNode<T>
 {
     public:
     T data;
     BinaryTreeNode<T> left;
     BinaryTreeNode<T> right;
    
     BinaryTreeNode(T data)
     {
         this.data = data;
         left = null;
         right = null;
     }
 };
 ************************************************************/
public class Solution {
    public static int rec(BinaryTreeNode<Integer> root,int[] max){
        if(root==null) return 0;
        int ls=Math.max(0,rec(root.left,max));
        int rs=Math.max(0,rec(root.right,max));
        max[0]=Math.max(max[0],ls+rs+root.data);
        return root.data+Math.max(ls,rs);
    }
    public static int maxPathSum(BinaryTreeNode<Integer> root) {
        int []max=new int[1];
        max[0]=Integer.MIN_VALUE;
        rec(root,max);
        return max[0];
    }
}
