import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    public static int maximumMeetings(int[] start, int[] end) {
        int n = start.length;
        int[][] meetings = new int[n][2];
        for (int i = 0; i < n; i++) {
            meetings[i][0] = start[i];
            meetings[i][1] = end[i];
        }  
        Arrays.sort(meetings, Comparator.comparingInt(a -> a[1]));
        int maxMeetings = 1;
        int prevEnd = meetings[0][1];
        for (int i = 1; i < n; i++) {
            int currentStart = meetings[i][0];
            int currentEnd = meetings[i][1];
            if (currentStart > prevEnd) {
                maxMeetings++;
                prevEnd = currentEnd;
            }
        }

        return maxMeetings;
    }
}
