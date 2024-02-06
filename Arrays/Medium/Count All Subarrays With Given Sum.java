import java.util.* ;
import java.io.*; 
public class Solution {
    public static int findAllSubarraysWithGivenSum(int arr[], int s) {
         int count = 0;
        int currentSum = 0;
        Map<Integer, Integer> sumCountMap = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            currentSum += arr[i];

            if (currentSum == s) {
                count++;
            }

            if (sumCountMap.containsKey(currentSum - s)) {
                count += sumCountMap.get(currentSum - s);
            }

            sumCountMap.put(currentSum, sumCountMap.getOrDefault(currentSum, 0) + 1);
        }

        return count;
    }
}