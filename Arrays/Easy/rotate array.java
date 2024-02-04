import java.util.ArrayList;

public class Solution 
{
    public static ArrayList<Integer> rotateArray(ArrayList<Integer> arr, int k) 
    {
        int n = arr.size();
        ArrayList<Integer> rotatedArr = new ArrayList<>(arr);
        for (int i = 0; i < n; i++) {
            rotatedArr.set((i - k + n)%n, arr.get(i));
        }
        return rotatedArr;
    }
}