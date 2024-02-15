public class Solution 
{
	public static String reverseString(String str) 
	{
		String a[]=str.split(" ");
		StringBuilder b=new StringBuilder();
		for(int i=a.length-1;i>=0;i--){
			b.append(a[i]);
			if(i!=a.length-1 || i!=0)
			b.append(" ");
		}
		return b.toString();
	}
}
