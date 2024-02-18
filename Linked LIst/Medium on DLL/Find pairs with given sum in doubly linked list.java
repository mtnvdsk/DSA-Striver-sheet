import java.util.*;
public class Solution {

    public static ArrayList<int[]> findPairs(Node head, int k) {
        // Traverse the linked list to the end.
        Node tempHead = head;
        Node tempTail = head;
        ArrayList<int[]> ans = new ArrayList<>();
        while(tempTail.next !=null){
            tempTail = tempTail.next;
        }
        while(tempHead != null && tempTail != null && tempHead.data < tempTail.data){
            int sum = tempHead.data + tempTail.data;
            if(sum == k){
                ans.add(new int[]{tempHead.data, tempTail.data});
                tempHead = tempHead.next;
                tempTail = tempTail.prev;
            } else if(sum > k){
                tempTail = tempTail.prev;
            } else {
                tempHead = tempHead.next;
            }
        }
        return ans;
    }

}
