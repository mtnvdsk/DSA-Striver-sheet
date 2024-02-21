public class Solution {
    public static int[] countGreater(int []arr, int []query) {
        // Initialize integer variables 'n' and 'q' with arr.length and query.length respectively.
        int n = arr.length, q = query.length;

        // Declare an integer array 'answer' of length 'q'.
        int []answer = new int[q];

        for (int i = 0; i < q; i++) {
            int queryIndex = query[i];

            // Check for all the greater elements to the right.
            for (int j = queryIndex + 1; j < n; j++) {
                if (arr[j] > arr[queryIndex]) {
                    answer[i]++;
                }
            }
        }

        // Return 'answer'
        return answer;
    }
}