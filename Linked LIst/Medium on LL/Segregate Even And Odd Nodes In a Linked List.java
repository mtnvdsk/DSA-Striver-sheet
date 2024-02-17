/****************************************************************

 Following is the class structure of the Node class:

 class Node {
     public int data;
     public Node next;

     Node()
     {
         this.data = 0;
         this.next = null;
     }
     Node(int data)
     {
         this.data = data;
         this.next = null;
     }
     Node(int data, Node next)
     {
         this.data = data;
         this.next = next;
     }
 }

 *****************************************************************/

 public class Solution {
    public static Node segregateEvenOdd(Node head) {
        if (head == null || head.next == null) {
            return head; // No need to segregate for an empty list or a single-node list
        }

        Node evenDummy = new Node(0); // Dummy node for even nodes
        Node oddDummy = new Node(0);  // Dummy node for odd nodes
        Node evenTail = evenDummy;   // Tail of the even list
        Node oddTail = oddDummy;     // Tail of the odd list
        Node current = head;         // Current node in the original list

        while (current != null) {
            if (current.data % 2 == 0) {
                evenTail.next = current;
                evenTail = evenTail.next;
            } else {
                oddTail.next = current;
                oddTail = oddTail.next;
            }
            current = current.next;
        }

        // Connect the even list to the odd list
        evenTail.next = oddDummy.next;
        oddTail.next = null; // Set the end of the odd list to null to avoid cycles

        return evenDummy.next; // The head of the new list is the next of the evenDummy node
    }
}
