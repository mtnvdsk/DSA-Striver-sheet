/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Queue<TreeNode> a=new LinkedList<>();
        List<List<Integer>> b=new ArrayList<>();
        if(root==null) return b;
        a.add(root);
        boolean flag=true;
        while(!a.isEmpty()){
            int size=a.size();  
            List<Integer> c=new ArrayList<Integer>(size);
            for(int i=0;i<size;i++){
                if(a.peek().left!=null) a.offer(a.peek().left);
                if(a.peek().right!=null) a.offer(a.peek().right);
                if(flag==true) c.add(a.poll().val);
                else{
                    c.add(0,a.poll().val);
                }
            }
            flag=!flag;
            b.add(c);
        }
        return b;
    }
}