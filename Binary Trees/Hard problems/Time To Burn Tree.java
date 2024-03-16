import java.util.*;
public class Solution
{
 
public static BinaryTreeNode<Integer> s=null;
public static void addParent(BinaryTreeNode<Integer> root, HashMap<BinaryTreeNode<Integer>, BinaryTreeNode<Integer>> hm, BinaryTreeNode<Integer> par, int start){
  if(root==null) return;
  hm.put(root,par);
  if(root.data==start) s=root;
  addParent(root.left,hm,root,start);
  addParent(root.right,hm,root,start);
 }
public static int timeToBurnTree(BinaryTreeNode<Integer> root, int start)
    {
        // Write your code here.
    

        HashMap<BinaryTreeNode<Integer>, BinaryTreeNode<Integer>> hm=new HashMap<>();
    addParent(root,hm,null,start);
    Queue<BinaryTreeNode<Integer>> q=new LinkedList<>();
  HashSet<Integer> vis=new HashSet<>();
    vis.add(s.data);
    q.add(s);
    int time=0;
    while(!q.isEmpty()){
      int n=q.size();
     for(int i=0;i<n;i++){
        BinaryTreeNode<Integer> rn=q.poll();
   if(rn.left!=null && !vis.contains(rn.left.data)) {
        q.add(rn.left);
        vis.add(rn.left.data);
     }
   if(rn.right!=null && !vis.contains(rn.right.data)){
            q.add(rn.right);
            vis.add(rn.right.data);
          }
if(hm.get(rn)!=null && !vis.contains(hm.get(rn).data)){
           q.add(hm.get(rn));
           vis.add(hm.get(rn).data);
       }
     }
     time++;
    }
   return time-1;

    }
}