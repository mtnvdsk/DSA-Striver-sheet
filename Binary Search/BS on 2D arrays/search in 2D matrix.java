import java.util.ArrayList;
import java.util.List;
public class Solution {
    public static boolean bs(ArrayList<ArrayList<Integer>> matrix,int target){
        int n = matrix.size();
        int m = matrix.get(0).size();

        //apply binary search:
        int low = 0, high = n * m - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            int row = mid / m, col = mid % m;
            if (matrix.get(row).get(col) == target) return true;
            else if (matrix.get(row).get(col) < target) low = mid + 1;
            else high = mid - 1;
        }
        return false;
    }
    static boolean searchMatrix(ArrayList<ArrayList<Integer>> matrix, int target) {
        return bs(matrix,target);
    }
}
