import java.util.ArrayList;
import java.util.Collections;

public class Solution {
    public static void sortArray(ArrayList<Integer> arr, int n) {
        int one = 0;
        int zero = 0;
        int two = 0;

        for (int i = 0; i < n; i++) {
            if (arr.get(i) == 0) {
                zero++;
            } else if (arr.get(i) == 1) {
                one++;
            } else {
                two++;
            }
        }

        int index = 0;

        while (zero-- > 0) {
            arr.set(index, 0);
            index++;
        }

        while (one-- > 0) {
            arr.set(index, 1);
            index++;
        }

        while (two-- > 0) {
            arr.set(index, 2);
            index++;
        }
    }

}


//solution2
import java.util.ArrayList;
import java.util.Collections;

public class Solution {
    public static void sortArray(ArrayList<Integer> arr, int n) {
        int zeroPos = 0;
        int onePos = 0;
        int twoPos = n - 1;

        while (onePos <= twoPos) {
            if (arr.get(onePos) == 1) {
                onePos++;
            } else if (arr.get(onePos) == 0) {
                Collections.swap(arr, zeroPos, onePos);
                zeroPos++;
                onePos++;
            } else {
                Collections.swap(arr, twoPos, onePos);
                twoPos--;
            }
        }

    }

}