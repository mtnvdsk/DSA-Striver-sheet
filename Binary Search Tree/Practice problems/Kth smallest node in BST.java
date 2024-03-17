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

 public class Solution {
    public static TreeNode rec(TreeNode root,int[] k){
        if(root==null) return null;
        TreeNode cur=rec(root.left,k);
        if(cur!=null) return cur;
        k[0]--;

        if(k[0]==0) return root;
        return rec(root.right,k);
    }
    public static int kthSmallest(TreeNode root, int k) {
        int[] a=new int[1];
        a[0]=k;
        TreeNode cur=rec(root,a);
        return cur.data;
    }
}