/*********************************************

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

 *********************************************/

 import java.util.*;

 class Pair{
     int x;
     TreeNode node;
     Pair(TreeNode node,int x){
         this.x=x;
         this.node=node;
     }
 }
 public class Solution {
     public static List<Integer> bottomView(TreeNode root) {
         Queue<Pair> a=new LinkedList<Pair>();
         Map<Integer,Integer> map=new TreeMap<>();
         List<Integer> ans=new ArrayList<>();
         a.add(new Pair(root,0));
         while(!a.isEmpty()){
             Pair temp=a.poll();
             int x=temp.x;
             TreeNode node=temp.node;
             if(map.containsKey(x)) map.put(x,node.val);
             else map.put(x,node.val);
             if(node.left!=null) a.offer(new Pair(node.left,x-1));
             if(node.right!=null) a.offer(new Pair(node.right,x+1));
         }
         for(Map.Entry<Integer,Integer> e: map.entrySet()){
             ans.add(e.getValue());
         }
         return ans;
     }
 }
 