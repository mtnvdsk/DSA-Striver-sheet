import java.util.*;

/****************************************************
    Following is the Node class for the Singly Linked List

    class LinkedListNode<Integer> {
        int data;
        LinkedListNode<Integer> next;

        public LinkedListNode(int data) {
            this.data = data;
        }
    }
****************************************************/

public class Solution {
    public static LinkedListNode<Integer> mergeKLists(LinkedListNode<Integer>[] listArray) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        // Add all elements to the priority queue
        for (LinkedListNode<Integer> list : listArray) {
            while (list != null) {
                pq.add(list.data);
                list = list.next;
            }
        }
        
        // Create a new linked list with the sorted elements
        LinkedListNode<Integer> dummy = new LinkedListNode<>(-1);
        LinkedListNode<Integer> current = dummy;
        
        while (!pq.isEmpty()) {
            current.next = new LinkedListNode<>(pq.poll());
            current = current.next;
        }
        
        return dummy.next;
    }
}
