/*********************************************************

 Following is the TreeNode structure:

 class TreeNode {
     int data;
     TreeNode left;
     TreeNode right;
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
     BinaryTreeNode(int data, TreeNode left, TreeNode right) {
         this.data = data;
         this.left = left;
         this.right = right;
     }
 };
 ********************************************************/
class Node{
    public int minnode,maxnode,maxsize;
    Node(int minnode,int maxnode,int maxsize){
        
        this.minnode=minnode;
        this.maxnode=maxnode;
        this.maxsize=maxsize;
    }
}
public class Solution {
    public static Node rec(TreeNode root){
        if(root==null){
            return new Node(Integer.MAX_VALUE,Integer.MIN_VALUE,0);
        }
        Node left=rec(root.left);
        Node right=rec(root.right);
        if(left.maxnode<root.data && root.data<right.minnode){
            return new Node(Math.min(root.data,left.minnode),Math.max(root.data,right.maxnode),(left.maxsize+right.maxsize+1));
        }
        return new Node(Integer.MIN_VALUE,Integer.MAX_VALUE,Math.max(left.maxsize,right.maxsize));
    }
    public static int largestBST(TreeNode root) {
        return rec(root).maxsize;
    }
}