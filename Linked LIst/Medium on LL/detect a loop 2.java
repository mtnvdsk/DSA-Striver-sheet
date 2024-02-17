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
    public static Node firstNode(Node head) {
        if(head==null) return null;
        Node fast=head;
        Node slow=head;
        while(fast!=null){
            slow=slow.next;
            if(fast.next==null || fast.next.next==null) return null;
            fast=fast.next.next;
            if(fast==slow) break;
        }
        slow=head;
        while(slow!=fast){
            slow=slow.next;
            fast=fast.next;
        }
        return slow;
    }
}