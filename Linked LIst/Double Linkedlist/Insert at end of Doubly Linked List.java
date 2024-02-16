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
 };

 *****************************************************************/

 public class Solution
 {
     public static Node insertAtTail(Node list, int K) {
         if(list==null){
             list=new Node(K);
             return list;
         }
         Node a=list;
         while(a.next!=null){
             a=a.next;
         }
         Node b=new Node(K);
         a.next=b;
         b.prev=a;
         return list;
 
     }
 }