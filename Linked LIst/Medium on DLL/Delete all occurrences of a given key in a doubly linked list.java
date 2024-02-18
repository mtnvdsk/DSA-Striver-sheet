/****************************************************************

 Following is the class structure of the Node class:

 class Node {
     public int data;
     public Node next;
     public Node prev;

     Node()
     {
         this.data = 0;
         this.next = null;
         this.prev = null;
     }
     Node(int data)
     {
         this.data = data;
         this.next = null;
         this.prev = null;
     }
     Node(int data, Node next, Node prev)
     {
         this.data = data;
         this.next = next;
         this.prev = prev;
     }
 }

 *****************************************************************/

 public class Solution {
    public static Node deleteAllOccurrences(Node head, int k) {
        Node curr = head;
        Node prev = null;

        while (curr != null) {
            if (curr.data == k) {
                if (prev == null) {
                    // If the node to be deleted is the head
                    head = curr.next;
                    if (head != null) {
                        head.prev = null;
                    }
                } else {
                    prev.next = curr.next;
                    if (curr.next != null) {
                        curr.next.prev = prev;
                    }
                }
            } else {
                prev = curr;
            }

            curr = curr.next;
        }

        return head;
    }
}
