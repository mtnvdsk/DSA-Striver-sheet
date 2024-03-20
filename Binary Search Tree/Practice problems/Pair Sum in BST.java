import java.util.*;
public class Solution {
    public static boolean pairSumBst(TreeNode temp, int k) {
        Stack<TreeNode> a=new Stack<>();
        HashSet<Integer> b=new HashSet<>();
        while(temp!=null||!a.isEmpty()){
            while(temp!=null){
                a.push(temp);
                temp=temp.left;                
            }
            temp=a.pop();
            if(b.contains(k-temp.data)) return true;
            b.add(temp.data);
            temp=temp.right;
        }
        return false;
    }
}