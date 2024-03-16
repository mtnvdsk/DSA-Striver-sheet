import java.util.* ;
import java.io.*; 
/*************************************************************
 
    Following is the Binary Tree node structure

    class BinaryTreeNode<T> {
        public T data;
        public BinaryTreeNode<T> *left;
        public BinaryTreeNode<T> *right;

        BinaryTreeNode(T data) {
            this.data = data;
            left = NULL;
            right = NULL;
        }
    };

*************************************************************/

public class Solution {
    public static int countNodes(BinaryTreeNode<Integer> root) {
        Queue<BinaryTreeNode<Integer>> a=new LinkedList<>();
        a.add(root);
        int n=0;
        while(!a.isEmpty()){
            int size=a.size();
            for(int i=0;i<size;i++){
                BinaryTreeNode<Integer> temp=a.poll();
                if(temp.left!=null) a.add(temp.left);
                if(temp.right!=null) a.add(temp.right);
            }
            n+=size;
        }
        return n;
      }
}