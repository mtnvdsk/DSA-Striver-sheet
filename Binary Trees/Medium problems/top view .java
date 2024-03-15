/*********************************************

 Following is the TreeNode class structure

 class TreeNode {
     int data;
     TreeNode left;
     TreeNode right;

     TreeNode(int data) {
         this.data = data;
         this.left = null;
         this.right = null;
     }
 }

 *********************************************/

 import java.util.*;

 class Pair{
     int hd;
     TreeNode node;
     Pair(TreeNode node,int col){
         this.node=node;
         this.hd=col;
     }
 }
 public class Solution {
     public static List<Integer> getTopView(TreeNode root) {
         ArrayList<Integer> ans = new ArrayList<>(); 
         if(root == null) return ans;
         Map<Integer, Integer> map = new TreeMap<>();
         Queue<Pair> q = new LinkedList<Pair>();
         q.add(new Pair(root, 0)); 
         while(!q.isEmpty()) {
             Pair it = q.remove();
             int hd = it.hd; 
             TreeNode temp = it.node; 
             if(map.get(hd) == null) map.put(hd, temp.data); 
             if(temp.left != null) {
                 
                 q.add(new Pair(temp.left, hd - 1)); 
             }
             if(temp.right != null) {
                 
                 q.add(new Pair(temp.right, hd + 1)); 
             }
         }
     
         for (Map.Entry<Integer,Integer> entry : map.entrySet()) {
             ans.add(entry.getValue()); 
         }
         return ans;
     }
 }
 