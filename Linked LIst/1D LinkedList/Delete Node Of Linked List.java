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
    public static Node deleteLast(Node list){
        Node a=list;
        while(a.next!=null && a.next.next!=null){
            a=a.next;
        }
        a.next=null;
        return list;
    }
}