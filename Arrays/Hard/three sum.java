import java.util.*;

public class Solution {
    public static List<List<Integer>> triplet(int n, int[] arr) {
        List<List<Integer>> b = new ArrayList<>();
        Arrays.sort(arr);

        for (int i = 0; i < n - 2; i++) {
            if (i == 0 || (i > 0 && arr[i] != arr[i - 1])) {
                int left = i + 1;
                int right = n - 1;
                int targetSum = 0 - arr[i];

                while (left < right) {
                    if (arr[left] + arr[right] == targetSum) {
                        List<Integer> triplet = new ArrayList<>();
                        triplet.add(arr[i]);
                        triplet.add(arr[left]);
                        triplet.add(arr[right]);
                        b.add(triplet);

                        while (left < right && arr[left] == arr[left + 1]) left++;
                        while (left < right && arr[right] == arr[right - 1]) right--;

                        left++;
                        right--;
                    } else if (arr[left] + arr[right] < targetSum) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }
        return b;
    }
}
