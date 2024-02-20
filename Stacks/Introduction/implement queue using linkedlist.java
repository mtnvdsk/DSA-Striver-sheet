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

 class Queue{
     Node front;
     Node rear;
     void push(){};
     Queue() {
         front = null;
         rear = null;
     }
 }

 *****************************************************************/

 public class Solution extends Queue{
    Node head=null;
    Node temp=null;
    public void push(int x) {
        Node t=new Node(x);
        if(head==null){
            head=temp=t;
            return;
        }
        temp.next=t;
        temp=t;
    }

    public int pop() {
        if(head==null) return -1;
        int front = head.data;
        if(temp==head) head=temp=null;
        else head=head.next;
        return front;
    }
}