/*********************************************************

Following is the TreeNode structure:

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {
        this.val = 0;
        this.left = null;
        this.right = null;
    }
    TreeNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
     }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
};
 ********************************************************/
public class Solution {
    public static TreeNode insertionInBST(TreeNode head, int val) {
        TreeNode root=head;
        while(root!=null){
            if(root.val>val){
                if(root.left==null) {
                    root.left=new TreeNode(val);
                    break;
                }
                else root=root.left;
            }
            if(root.val<val){
                if(root.right==null) {
                    root.right=new TreeNode(val);
                    break;
                }
                else root=root.right;
            }
        }
        return head;
    }
}