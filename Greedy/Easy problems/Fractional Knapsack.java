import java.util.*;
public class Solution {
    public static double maximumValue(Pair[] items, int n, int w) {
        Arrays.sort(items, (a, b) -> {
            double r1 = (double) a.value / a.weight;
            double r2 = (double) b.value / b.weight;
            return Double.compare(r2, r1);
        });

        double max = 0;
        int curr = 0;

        for (int i = 0; i < n; i++) {
            if (curr + items[i].weight <= w) {
                curr += items[i].weight;
                max += items[i].value;
            } else {
                int remainingWeight = w - curr;
                max += items[i].value * ((double) remainingWeight / items[i].weight);
                break;
            }
        }

        return max;
    }
}