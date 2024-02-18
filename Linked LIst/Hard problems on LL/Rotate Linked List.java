public class Solution {
    public static Node rotate(Node head, int k) {
        Node current = head;
        int length = 1;
        while (current.next != null) {
            current = current.next;
            length++;
        }
        current.next = head;
        for (int i = 0; i < length - k % length; i++) {
            current = current.next;
        }
        head = current.next;
        current.next = null;
        return head;
    }
}