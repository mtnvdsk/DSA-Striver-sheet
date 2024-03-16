/*********************************************************

 Following is the BinaryTreeNode structure:

 class BinaryTreeNode {
     int data;
     BinaryTreeNode left;
     BinaryTreeNode right;
     BinaryTreeNode() {
         this.data = 0;
         this.left = null;
         this.right = null;
     }
     BinaryTreeNode(int data) {
         this.data = data;
         this.left = null;
         this.right = null;
     }
     BinaryTreeNode(int data, BinaryTreeNode left, BinaryTreeNode right) {
         this.data = data;
         this.left = left;
         this.right = right;
     }
 };
 ********************************************************/

 public class Solution {
    public static boolean searchInBST(BinaryTreeNode root, int x) {
        BinaryTreeNode curr=root;
        while(curr!=null){
            if(curr.data==x) return true;
            if(curr.data>x) curr=curr.left;
            else curr=curr.right;
        }
        return false;
    }
}