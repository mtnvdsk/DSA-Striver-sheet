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
    public static Node sortList(Node head) {
        if(head==null || head.next==null) return head;
        Node left=head;
        Node middle=mid(head);
        Node right=middle.next;
        middle.next=null;
        Node lefthead=sortList(left);
        Node righthead=sortList(right);
        return merge(lefthead,righthead);
    }
    public static Node mid(Node head){
        Node fast=head.next;
        Node slow=head;
        while(fast!=null && fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        return slow;
    }
    public static Node merge(Node left, Node right) {
        Node result = null;
        Node temp = null; // Change from temp=result to temp=null

        while (left != null && right != null) {
            if (left.data < right.data) {
                if (result == null) {
                    result = left;
                } else {
                    temp.next = left;
                }
                temp = left;
                left = left.next;
            } else {
                if (result == null) {
                    result = right;
                } else {
                    temp.next = right;
                }
                temp = right;
                right = right.next;
            }
        }

        if (left != null) {
            temp.next = left;
        } else {
            temp.next = right;
        }

        return result;
    }

}