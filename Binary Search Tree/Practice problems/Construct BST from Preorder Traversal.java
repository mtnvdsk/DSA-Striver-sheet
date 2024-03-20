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
    public static TreeNode preOrderTree(int[] preorder) {
        if (preorder == null || preorder.length == 0) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[0]);
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        for (int i = 1; i < preorder.length; i++) {
            TreeNode current = null;

            while (!stack.isEmpty() && preorder[i] > stack.peek().data) {
                current = stack.pop();
            }

            if (current != null) {
                current.right = new TreeNode(preorder[i]);
                stack.push(current.right);
            } else {
                current = stack.peek();
                current.left = new TreeNode(preorder[i]);
                stack.push(current.left);
            }
        }

        return root;
    }
}