import java.util.*;

public class solution {
	public static int Floor(BinaryTreeNode<Integer> node, int input)
	{	
		int ans=0;
		while(node!=null){
			if(node.data==input){
				ans=node.data;
				return ans;
			}
			if(node.data>input){
				node=node.left;
			}
			else{
				ans=node.data;
				node=node.right;
			}
		}
		return ans;
	}

}
