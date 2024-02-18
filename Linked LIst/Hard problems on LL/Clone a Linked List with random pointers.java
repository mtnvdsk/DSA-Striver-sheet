public class Solution {
    public static Node cloneLL(Node head) {
        Node dummy = new Node();
        Node current = head;
        Node newCurrent = dummy;
        while (current != null) {
            newCurrent.next = new Node(current.data);
            newCurrent.next.random = current.random;

            newCurrent = newCurrent.next;
            current = current.next;
        }

        return dummy.next;
    }
}
