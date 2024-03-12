public class Solution {
    public static int maxPoints(int []arr , int K){
        int maxScore = 0;
        for(int i = 0; i < K; i++)
            maxScore += arr[i];

        int currentScore = maxScore;
        int n = arr.length;
        for(int i = K - 1; i >= 0; i--) {
            currentScore -= arr[i];
            currentScore += arr[n - K + i];
            maxScore = Math.max(maxScore, currentScore);
        }

        return maxScore;
    }
}