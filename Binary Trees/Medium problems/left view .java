/*************************************************************

     Following is thr TreeNode class structure

     class BinaryTreeNode<T>
     {
         T data;
         BinaryTreeNode<T> left;
         BinaryTreeNode<T> right;

         BinaryTreeNode(T data) {
             this.data = data;
             left = null;
             right = null;
         }
     };

 *************************************************************/
import java.util.*;
public class Solution {
    public static void printLeftView(TreeNode<Integer> root) {
        Queue<TreeNode<Integer>> q = new LinkedList<>();
        q.add(root);
        while(q.size()>0){
            int sizeofq=q.size();
            for(int i =1; i<=sizeofq; i++){
                root = q.poll();
                if(i==1){
                    System.out.print(root.data+" ");
                }
                if(root.left!=null){
                    q.add(root.left);
                }
                if(root.right!=null){
                    q.add(root.right);
                }
            }
        }
    }
}
