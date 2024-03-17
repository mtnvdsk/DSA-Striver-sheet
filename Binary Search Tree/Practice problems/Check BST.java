class Solution{
    public static boolean helper(BinaryTreeNode<Integer> root,int min,int max){
            if(root==null){
                return true;
            }
            if(root.data>=max || root.data<=min){
                return false;
            }
            boolean leftSide = helper(root.left, min, root.data);
            boolean rightSide = helper(root.right, root.data, max);
            if(leftSide&&rightSide){
                return true;
            }
            return false;
        }
        public static boolean isBST(BinaryTreeNode<Integer> root) {
            return helper(root,Integer.MIN_VALUE, Integer.MAX_VALUE);
        }
    }