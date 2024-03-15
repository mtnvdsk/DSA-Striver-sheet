/************************************************************

 Following is the TreeNode class structure

 class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;

     TreeNode(int val) {
         this.val = val;
         this.left = null;
         this.right = null;
     }
 }


 ************************************************************/
import java.util.*;
public class Solution {
    public static int getMaxWidth(TreeNode root) {
         int ans=0;
         Queue<TreeNode> a=new LinkedList<>();
         if(root==null) return 0;
         a.add(root);
         while(!a.isEmpty()){
             int size=a.size();
             int c=0;
             for(int i=0;i<size;i++){
                c++;
                TreeNode node=a.poll();
                if(node.left!=null){
                    a.add(node.left);
                }
                if(node.right!=null){
                    a.add(node.right);
                }
            }
            ans=Math.max(ans,c);
         }
        return ans;
    }
}