public class Solution {
    public static TreeNode FixBST(TreeNode root) {
        TreeNode first = null, second = null, prev = new TreeNode(-1);

        TreeNode curr = root;

        // Using Morris Traversal to traverse the BST in the inorder fashion.
        while (curr != null) {
            if (curr.left == null) {
                if (curr.data < prev.data) {
                    if (first == null) {
                        first = prev;
                    }
                    second = curr;
                }
                prev = curr;
                curr = curr.right;
            }
            else {
                TreeNode temp = curr.left;
                while (temp.right != null && temp.right != curr) {

                    temp = temp.right;
                }

                if (temp.right == null) {
                    temp.right = curr;
                    curr = curr.left;
                }
                else {
                    temp.right = null;
                    if (curr.data < prev.data) {
                        if (first == null) {
                            first = prev;
                        }
                        second = curr;
                    }
                    prev = curr;
                    curr = curr.right;
                }
            }
        }

        // Swapping the data of the incorrect nodes to fix the BST.
        int temp;
        temp = second.data;
        second.data = first.data;
        first.data = temp;

        return root;
    }
}