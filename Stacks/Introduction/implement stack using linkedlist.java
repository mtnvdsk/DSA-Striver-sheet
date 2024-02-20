/****************************************************************

 Following is the class structure of the Node class:

 static class Node
 {
     int data;
     Node next;
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
    static class Stack {
        //Write your code here
        Node stac;
        Stack()
        {
           this.stac=null;
        }

        int getSize()
        {
            int size=0;
            Node head=stac;
            while(head!=null){
                head=head.next;
                size++;
            }
            return size;
        }

        boolean isEmpty()
        {
            return stac==null;
        }

        void push(int data)
        {
            Node temp=new Node(data);
            temp.next=stac;
            stac=temp;
        }

        void pop()
        {
            if(stac!=null) stac=stac.next;
        }

        int getTop()
        {
            if(stac!=null) return stac.data;
            return -1;
        }
    }
}
