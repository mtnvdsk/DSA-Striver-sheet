class Solution{
    public static boolean isSymmetric(TreeNode root1, TreeNode root2) {
            if (root1 == null && root2 == null)
                return true;
    
            if (root1 == null || root2 == null)
                return false;
    
            return (root1.data.equals(root2.data)) && isSymmetric(root1.left, root2.right) && isSymmetric(root1.right, root2.left);
        }
    
        public static boolean isSymmetric(TreeNode root) {
            if (root == null)
                return true;
    
            return isSymmetric(root.left, root.right);
        }
    }