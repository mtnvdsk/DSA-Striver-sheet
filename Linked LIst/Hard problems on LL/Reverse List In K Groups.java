public class Solution {
    public static Node kReverse(Node head, int k) {
        Node dummy = new Node(0);
        dummy.next = head; 
        Node prevTail = dummy; 
        Node curr = head; 
        while (curr != null) {
            Node temp = prevTail.next;
            int count = 0;
            while (count < k && curr != null) {
                curr = curr.next; 
                count++;
            }
            if (count == k) { 
                prevTail = reverseKGroup(prevTail, temp, curr); 
            }
        }
        return dummy.next; 
    }

    private static Node reverseKGroup(Node prevTail, Node head, Node tail) {
        Node prev = tail; 
        while (head != tail) { 
            Node next = head.next;
            head.next = prev;
            prev = head; 
            head = next; 
        }
        Node temp = prevTail.next; 
        prevTail.next = prev; 
        temp.next = head;
        return temp; 
    }
}