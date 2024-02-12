import java.util.* ;
import java.io.*; 

public class Solution {

	public static int sqrtN(long N) {
		long low = 0;
        long high = N;
        long result = 0;

        while (low <= high) {
            long mid = low + (high - low) / 2;
            long square = mid * mid;
            if (square == N) {
                return (int)mid;
            } else if (square < N) {
                low = mid + 1;
                result = mid;
            } else {
                high = mid - 1;
            }
        }

        return (int)result;
	}
}
