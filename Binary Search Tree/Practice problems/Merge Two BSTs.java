import java.util.ArrayList;
import java.util.List;
public class Solution {
    public static List<Integer> mergeBST(TreeNode root1, TreeNode root2) {
        List<Integer> temp1 = new ArrayList<>();
        storeInOrder(root1, temp1);
        List<Integer> temp2 = new ArrayList<>();
        storeInOrder(root2, temp2);
        List<Integer> answer = mergeSortedArrays(temp1, temp2);
        return answer;
    }
    public static List<Integer> mergeSortedArrays(List<Integer> arr1, List<Integer> arr2)
    {
        int i = 0, j = 0;
        List<Integer> arr = new ArrayList<>();
        while (i < arr1.size() && j < arr2.size())
        {
            if (arr1.get(i) < arr2.get(j))
            {
                arr.add(arr1.get(i));
                i++;
            }
            else
            {
                arr.add(arr2.get(j));
                j++;
            }
        }
        while (i < arr1.size())
        {
            arr.add(arr1.get(i));
            i++;
        }
        while (j < arr2.size())
        {
            arr.add(arr2.get(j));
            j++;
        }

        return arr;
    }
    public static void storeInOrder(TreeNode root, List<Integer> arr)
    {
        if (root != null)
        {
            storeInOrder(root.left, arr);
            arr.add(root.data);
            storeInOrder(root.right, arr);
        }
    }
}