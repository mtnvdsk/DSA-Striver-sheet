/*******************************************************
Following is the Interval class structure

    class Interval {
    int start;
    int end;

    Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
}
*******************************************************/

import java.util.*;


public class Solution {

    public static ArrayList<Interval> mergeIntervals(ArrayList<Interval> intervals) {
        ArrayList<Interval> mergedIntervals = new ArrayList<>();
        if (intervals == null || intervals.isEmpty()) {
            return mergedIntervals;
        }
        intervals.sort(Comparator.comparingInt(interval -> interval.start));
        Interval prevInterval = intervals.get(0);
        for (int i = 1; i < intervals.size(); i++) {
            Interval currentInterval = intervals.get(i);
            if (prevInterval.end >= currentInterval.start) {
                prevInterval.end = Math.max(prevInterval.end, currentInterval.end);
            } else {
                mergedIntervals.add(prevInterval);
                prevInterval = currentInterval;
            }
        }
        mergedIntervals.add(prevInterval);
        return mergedIntervals;
    }
}