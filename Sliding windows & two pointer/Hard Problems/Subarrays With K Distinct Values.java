import java.util.HashMap;

public class Solution
{
    public static int kDistinctSubarrays(int []arr, int n, int k)
    {
        return (lessThanKDistinctSubarrays(arr,n,k)-lessThanKDistinctSubarrays(arr,n,k-1));
    }
    public static int lessThanKDistinctSubarrays(int arr[], int n, int k)
    {
        int count = 0;
        int l = 0, r = 0;
        HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
        int size = 0;

        while (r < n)
        {
            hashMap.put(arr[r], hashMap.getOrDefault(arr[r], 0) + 1);
            if (hashMap.get(arr[r]) == 1)
            {
                size++;
            }
            while (size > k)
            {
                hashMap.put(arr[l], hashMap.get(arr[l]) - 1);
                if (hashMap.get(arr[l]) == 0)
                {
                    size--;
                }
                l++;
            }
            count += r - l + 1;
            r++;
        }

        return count;
    }

}

