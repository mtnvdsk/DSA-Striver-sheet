public class Solution
{
    public static int lengthOfLoop(Node head) {
        Node fast=head,slow=head,curr=null;
        while(fast.next!=null && fast.next.next!=null){
          slow=slow.next;
          fast=fast.next.next;
          if(slow==fast){
            curr=slow;
            break;
          }
        }
        if(curr==null) return 0;
        int len=0;
        Node nc=curr.next;
        while(nc!=curr){
          nc=nc.next;
          len++;
        }
        return len+1;
    }
}