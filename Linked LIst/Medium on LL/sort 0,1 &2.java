public class Solution
{
    public static Node sortList(Node head)
    {
        Node ptr = head;
        int[] cnt = new int[3];

        // Iterate while ptr is not empty
        while(ptr != null)
        {
            cnt[ptr.data]++;
            ptr = ptr.next;
        }

        ptr = head;
        int i = 0;

        // Updating data.
        while(ptr != null)
        {
            while(cnt[i] == 0)
            {
                i++;
            }

            ptr.data = i;
            cnt[i]--;
            ptr = ptr.next;
        }

        // Return head
        return head;
    }
}