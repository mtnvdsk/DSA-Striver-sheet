import java.util.ArrayList;
import java.util.List;
public class Solution {
    public static List< Integer > search(String s, String pattern){
        int n = s.length();
        int m = pattern.length();
        int l = 0, r = 0;
        String nStr = pattern + "#" + s;
        int k = nStr.length();
        List<Integer> ans = new ArrayList<>();
        int[] zarr = new int[k];
        zarr[0] = 0;
        for (int i = 1; i < k; i++) {
            if (i > r) {
                l = i;
                r = i;
                while (r < k && nStr.charAt(r - l) == nStr.charAt(r)) {
                    r++;
                }

                zarr[i] = (r--) - l;
                if (zarr[i] == m) {
                    ans.add(i + 1 - m - 1);
                }

            } else {
                int pos = i - l;

                if (zarr[pos] < r - i + 1) {
                    zarr[i] = zarr[pos];
                    if (zarr[i] == m) {
                        ans.add(i + 1 - m - 1);
                    }

                } else {
                    l = i;
                    while (r < k && nStr.charAt(r - l) == nStr.charAt(r)) {
                        r++;
                    }

                    zarr[i] = (r--) - l;
                    if (zarr[i] == m) {
                        ans.add(i + 1 - m - 1);
                    }
                }
            }
        }

        return ans;
    }
}