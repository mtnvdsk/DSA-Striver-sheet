/*
    Time Complexity  : O(N)
    Space Complexity : O(N)

    Where 'N' is the total number of nodes in the binary tree.
*/

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class Solution {

    private static List<Integer> getInOrderTraversal(TreeNode root) {

        // Create answer array to store traversal.
        List<Integer> answer = new ArrayList<>();

        // Base case.
        if (root == null) {
            return answer;
        }

        // Create an empty stack.
        Stack<TreeNode> s = new Stack<>();

        // Initialize current node as 'ROOT'.
        TreeNode current = root;

        // Run a loop until 'CURRENT'!= NULL or stack is not empty.
        while (current != null || s.empty() == false) {
            while (current != null) {
                // Push current node to stack.
                s.push(current);

                // Move to left subtree of 'CURRENT'.
                current = current.left;
            }

            // 'CURRENT' must be NULL at this point.

            current = s.pop();

            // Add data of popped node to answer.
            answer.add(current.data);

            // Visit right subtree of current node.
            current = current.right;

        }

        return answer;

    }

    private static List<Integer> getPreOrderTraversal(TreeNode root) {

        // Create answer array to store traversal.
        List<Integer> answer = new ArrayList<>();

        // Base case.
        if (root == null) {
            return answer;
        }

        // Create an empty stack.
        Stack<TreeNode> s = new Stack<>();

        // Push 'ROOT' to stack.
        s.push(root);

        // Run a loop until stack is not empty.
        while (s.empty() == false) {

            // Get the top node from stack.
            TreeNode node = s.pop();

            // Add data of top node to 'ANSWER'.
            answer.add(node.data);

            // Push right subtree of node to stack.
            if (node.right != null) {
                s.push(node.right);
            }

            // Push left subtree of node to stack.
            if (node.left != null) {
                s.push(node.left);
            }
        }

        return answer;
    }

    private static List<Integer> getPostOrderTraversal(TreeNode root) {

        // Create answer array to store traversal.
        List<Integer> answer = new ArrayList<>();

        // Base case.
        if (root == null) {
            return answer;
        }

        // Create an empty stack.
        Stack<TreeNode> s = new Stack<>();
        TreeNode current = root;

        // Push current to stack.
        s.push(current);

        // Run a loop until stack is not empty.
        while (!s.empty()) {

            // Pop a node from 'S'.
            current = s.pop();

            // Add data of popped node to 'ANSWER'.
            answer.add(current.data);

            // Push left child of current node to stack.
            if (current.left != null) {
                s.push(current.left);
            }

            // Push right child of current node to stack.
            if (current.right != null) {
                s.push(current.right);
            }

        }

        // Reverse all elements of 'ANSWER' array.
        Collections.reverse(answer);

        return answer;
    }

    public static List<List<Integer>> getTreeTraversal(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        // Call function to get inOrder Traversal.
        result.add(getInOrderTraversal(root));

        // Call function to get preOrder Traversal.
        result.add(getPreOrderTraversal(root));

        // Call function to get postOrder Traversal.
        result.add(getPostOrderTraversal(root));

        // Return all 3 tree traversals.
        return result;
    }
}