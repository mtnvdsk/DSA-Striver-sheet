import java.util.*;
public class Solution {
    public static List< Integer > sortedArray(int []a, int []b) {
        int n = a.length, m = b.length;
        List< Integer > unionArray = new ArrayList<>();

        int i = 0, j = 0;
        while (i < n && j < m) {
            if (a[i] <= b[j]) {
                if (unionArray.size() == 0 ||
                        unionArray.get(unionArray.size() - 1) != a[i]) {
                    unionArray.add(a[i]);
                }
                ++i;
            } else {
                if (unionArray.size() == 0 ||
                        unionArray.get(unionArray.size() - 1) != b[j]) {
                    unionArray.add(b[j]);
                }
                ++j;
            }
        }
        while (i < n) {
            if (unionArray.get(unionArray.size() - 1) != a[i]) {
                unionArray.add(a[i]);
            }
            ++i;
        }
        while (j < m) {
            if (unionArray.get(unionArray.size() - 1) != b[j]) {
                unionArray.add(b[j]);
            }
            ++j;
        }

        return unionArray;
    }
}