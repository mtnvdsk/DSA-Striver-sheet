/****************************************************************

 Following is the class structure of the Node class:

 class Node {
     public int data;
     public Node left;
     public Node right;

     Node()
     {
         this.data = 0;
         this.left = null;
         this.right = null;
     }

     Node(int data)
     {
         this.data = data;
         this.left = null;
         this.right = null;
     }

     Node(int data, Node left, Node right)
     {
         this.data = data;
         this.left = left;
         this.right = right;
     }
 }

 *****************************************************************/
import java.util.*;
public class Solution {
    public static boolean isParentSum(Node root) {
        Queue<Node> a=new LinkedList<>();
        a.add(root);
        while(!a.isEmpty()){
            int size=a.size();
            for(int i=0;i<size;i++){
                Node temp=a.poll();
                int sum=0;
                if(temp.left!=null){
                 a.add(temp.left);
                 sum+=temp.left.data;
                }
                if(temp.right!=null){
                    a.add(temp.right);
                    sum+=temp.right.data;
                }
                if(temp.left==null &&temp.right==null) continue;
                if(sum!=temp.data){
                    return false;
                }
            }
        }
        return true;
    }
}