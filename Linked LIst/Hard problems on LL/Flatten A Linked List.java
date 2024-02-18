import java.util.ArrayList;
import java.util.Collections;

public class Solution {
    public static Node flattenLinkedList(Node head) {
        ArrayList<Integer> answer = new ArrayList<Integer>();
        while (head != null) {
            answer.add(head.data);
            Node temp = head;
            while (temp.child != null) {
                answer.add(temp.child.data);
                temp = temp.child;
            }
            head = head.next;
        }
        Collections.sort(answer);

        Node root = null;
        Node tail = null;
        for (int i = 0; i < answer.size(); ++i) {
            Node newNode = new Node(answer.get(i));

            if (root == null) {
                root = newNode;
            } else {
                tail.child = newNode;
            }
            tail = newNode;
        }
        return root;
    }
}