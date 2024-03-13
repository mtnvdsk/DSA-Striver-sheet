import java.util.*;
public class Solution {
  public static int[][] addInterval(int[][] intervals, int n, int[] newInterval) {
    List<int[]> merged = new ArrayList<>();
    int i = 0;
    // Add all intervals that come before the new interval
    while (i < n && intervals[i][1] < newInterval[0]) {
      merged.add(intervals[i]);
      i++;
    }
    // Merge any overlapping intervals
    while (i < n && intervals[i][0] <= newInterval[1]) {
      newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
      newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
      i++;
    }
    merged.add(newInterval);
    // Add all intervals that come after the new interval
    while (i < n) {
      merged.add(intervals[i]);
      i++;
    }
    return merged.toArray(new int[merged.size()][]);
  }
}