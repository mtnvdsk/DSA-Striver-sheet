/*
    Time Complexity : O(N)
    Space Complexity : O(N)

    Where N is the number of nodes in the tree.
*/

import java.util.ArrayList;
import java.util.List;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    public static List < String > allRootToLeaf(BinaryTreeNode root) {

        // Edge Case.
        if (root == null) {
            return null;
        }

        // It is used for level order traversal in Breadh-First search technique.
        Queue < pair > bfs = new LinkedList < > ();

        // It stores the result.
        List < String > result = new ArrayList < > ();

        String str = (root.data) + " ";

        bfs.add(new pair(root, str));
        pair curr;

        while (!bfs.isEmpty()) {
            curr = bfs.peek();
            bfs.poll();

            // If the left and right child of current node is NULL, store the paths in the result array.
            if (curr.node.left == null && curr.node.right == null) {
                result.add(curr.str);
            }

            if (curr.node.left != null) {
                bfs.add(new pair(curr.node.left, curr.str + (curr.node.left.data) + " "));
            }
            if (curr.node.right != null) {
                bfs.add(new pair(curr.node.right, curr.str + (curr.node.right.data) + " "));
            }
        }

        return result;
    }
}