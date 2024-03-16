import java.util.HashMap;

// class TreeNode<T> {
//     T data;
//     TreeNode<T> left;
//     TreeNode<T> right;

//     public TreeNode(T x) {
//         this.data = x;
//         this.left = null;
//         this.right = null;
//     }
// }

public class Solution {

    public static TreeNode<Integer> rec(int[] post, int ps, int pe, int[] in, int is, int ie, HashMap<Integer, Integer> map) {
        if (ps > pe || is > ie)
            return null;

        TreeNode<Integer> root = new TreeNode<>(post[pe]);
        int inroot = map.get(post[pe]);
        int ele = inroot - is;

        root.right = rec(post, pe - (ie - inroot), pe - 1, in, inroot + 1, ie, map);
        root.left = rec(post, ps, pe - (ie - inroot) - 1, in, is, inroot - 1, map);
        return root;
    }

    public static TreeNode<Integer> getTreeFromPostorderAndInorder(int[] postOrder, int[] inOrder) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inOrder.length; i++) {
            map.put(inOrder[i], i);
        }
        int n = inOrder.length;
        return rec(postOrder, 0, n - 1, inOrder, 0, n - 1, map);
    }
}
