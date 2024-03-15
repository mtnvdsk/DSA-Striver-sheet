import java.util.*;

public class Solution {

    // Function to populate the parent map for each node
    public static void parent(BinaryTreeNode<Integer> root, Map<BinaryTreeNode<Integer>, BinaryTreeNode<Integer>> parent) {
        Queue<BinaryTreeNode<Integer>> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            BinaryTreeNode<Integer> temp = queue.poll();

            if (temp.left != null) {
                parent.put(temp.left, temp);
                queue.add(temp.left);
            }

            if (temp.right != null) {
                parent.put(temp.right, temp);
                queue.add(temp.right);
            }
        }
    }

    // Function to find nodes at distance K from the target node
    public static List<BinaryTreeNode<Integer>> printNodesAtDistanceK(
            BinaryTreeNode<Integer> root, BinaryTreeNode<Integer> target, int K) {
        Queue<BinaryTreeNode<Integer>> queue = new LinkedList<>();
        Map<BinaryTreeNode<Integer>, BinaryTreeNode<Integer>> parent = new HashMap<>();
        Set<BinaryTreeNode<Integer>> visited = new HashSet<>();

        // Populate the parent map
        parent(root, parent);

        // Start BFS from the target node
        queue.add(target);
        visited.add(target);

        int distance = 0;

        // Continue BFS until the target distance is reached
        while (!queue.isEmpty() && distance < K) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                BinaryTreeNode<Integer> current = queue.poll();

                // Add unvisited children to the queue
                if (current.left != null && visited.add(current.left)) {
                    queue.add(current.left);
                }
                if (current.right != null && visited.add(current.right)) {
                    queue.add(current.right);
                }

                // Add parent to the queue if not visited
                BinaryTreeNode<Integer> parentNode = parent.get(current);
                if (parentNode != null && visited.add(parentNode)) {
                    queue.add(parentNode);
                }
            }

            distance++;
        }

        // Extract the nodes at the target distance from the queue
        List<BinaryTreeNode<Integer>> result = new ArrayList<>(queue);
        return result;
    }
}
