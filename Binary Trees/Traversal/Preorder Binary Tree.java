/*
	
	Following the structure used for Binary Tree
	
	class BinaryTreeNode<T> {
		T data;
		BinaryTreeNode<T> left;
		BinaryTreeNode<T> right;

		public BinaryTreeNode(T data) {
			this.data = data;
			this.left = null;
			this.right = null;
		}
	}

 */
import java.util.*;
public class Solution {

	public static void preOrder(BinaryTreeNode<Integer> root) {
		// Stack<BinaryTreeNode<Integer>> a=new Stack<>();
		// a.push(root);
		// while(!a.isEmpty())	{
		// 	root=a.peek();
		// 	System.out.print(root.data+" ");
			
		// 	if(root.right!=null){
		// 		a.add(root.right);
		// 	}
		// 	if(root.left!=null){
		// 		a.add(root.left);
		// 	}
		// }

		//morris code
		BinaryTreeNode<Integer> cur=root;
		while(cur!=null){
			if(cur.left==null){
				System.out.print(cur.data+" ");
				cur=cur.right;
			}
			else{
				BinaryTreeNode<Integer> temp=cur.left;
				while(temp.right!=null && temp.right!=cur){
					temp=temp.right;
				}
				if(temp.right==null){
					temp.right=cur;
					System.out.print(cur.data+" ");
					cur=cur.left;
				}
				else{
					temp.right=null;
					cur=cur.right;
				}
			}
		}
	}

}