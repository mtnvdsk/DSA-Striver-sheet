public class Solution
{
    public static Node reverseLinkedList(Node head)
    {
        if (head == null || head.next == null)
        {
            return head;
        }
        Node prev = null;
        Node next = null;
        Node curr = head;

        while (curr != null)
        {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }
}