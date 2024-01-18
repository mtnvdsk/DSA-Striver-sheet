import java.util.*;

public class Solution 
{
    public static void func( ArrayList<Integer> arr, ArrayList<ArrayList<Integer>> res, ArrayList<Integer> inner, int idx)
    {

        res.add(new ArrayList<>(inner));
        for(int i=idx; i<arr.size(); i++)
        {
            if( i > idx && arr.get(i) == arr.get(i-1) )
            {
                continue;
            }
            inner.add(arr.get(i));
            func( arr,  res, inner, i+1);
            inner.remove(inner.size()-1);
        }
    }

    public static ArrayList<ArrayList<Integer>> combinationSum2(ArrayList<Integer> arr, int n)
    {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        ArrayList<Integer> inner = new ArrayList<>();
        func( arr, res, inner, 0);
        return res;
    }
}