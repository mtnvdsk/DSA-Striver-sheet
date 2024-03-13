import java.util.*;

public class Solution {
    public static int calculateMinPatforms(int at[], int dt[], int n) {
        // HashMap<Integer, Integer> a = new HashMap<>();
        // for (int i = 0; i < n; i++)
        //     a.put(at[i], dt[i]);

        // List<Map.Entry<Integer, Integer>> list = new ArrayList<>(a.entrySet());
        // list.sort((i, j) -> {
        //     if (i.getValue() > j.getValue()) return 1;
        //     if (i.getValue().equals(j.getValue())) return 0;
        //     return -1;
        // });

        Arrays.sort(at);
        Arrays.sort(dt);

        int platforms = 1;
        int result = 1;
        int i = 1, j = 0;

        while (i < n && j < n) {
            if (at[i] <= dt[j]) {
                platforms++;
                i++;
            } else if (at[i] > dt[j]) {
                platforms--;
                j++;
            }

            result = Math.max(result, platforms);
        }

        return result;
    }
}
