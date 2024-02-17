import java.util.* ;
import java.io.*; 
public class Solution {
    static LinkedListNode addTwoNumbers(LinkedListNode head1, LinkedListNode head2) {
        LinkedListNode a=head1;
        LinkedListNode b=head2;
        int carry=0;
        LinkedListNode result=null;
        LinkedListNode prev=result;
        int sum;
        while(a!=null || b!=null){
            int x = (a!=null) ? a.data : 0;
            int y = (b!=null) ? b.data : 0;
            sum = carry + x + y;
            carry = sum / 10;
            sum = sum % 10;
            LinkedListNode temp = new LinkedListNode(sum);
            if(result == null){
                result = temp;
            }else{
                prev.next = temp;
            }
            prev = temp;
            if(a!=null) a=a.next;
            if(b!=null) b=b.next;
        }
        if(carry > 0){
            prev.next = new LinkedListNode(carry);
        }
        return result;
    }
}