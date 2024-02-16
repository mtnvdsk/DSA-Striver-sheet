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

     Node(int data, Node next)
     {
         this.data = data;
         this.next = next;
         this.prev = next;
     }
 };

 *****************************************************************/

 public class Solution
 {
     public static Node reverseDLL(Node head)
     {
         if(head == null || head.next == null)
             return head;
         Node list = head;
         while(list != null)
         {
             if(list.next == null)
                head = list;
             Node newNode = new Node();
             newNode.next = list.next;
             list.next = list.prev;
             list.prev = newNode.next;    
             list = newNode.next;
         }
         return head;
     }
 }