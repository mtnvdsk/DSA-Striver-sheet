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
 };

 *****************************************************************/

 public class Solution {
    public static Node deleteMiddle(Node head) {
        if (head==null || head.next==null) return null;
        Node s=head;
        Node f=head;
        while(f.next.next!=null && f.next.next.next!=null){
            s=s.next;
            f=f.next.next;
        }
        s.next=s.next.next;
        return head;
    }
}