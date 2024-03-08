import java.util.*;

public class Solution {
  public static int largestRectangle(ArrayList < Integer > heights) {
    Stack<Integer> a=new Stack<>();
    int n=heights.size();
    int max=0;
    for(int i=0;i<=n;i++){
      while(!a.isEmpty() && (i==n || heights.get(a.peek())>=heights.get(i))){
        int num=heights.get(a.pop());
        int w;
        if(a.isEmpty()) w=i;
        else w=i-a.peek()-1;
        max=Math.max(max,w*num);
      }
      a.push(i);
    }
    return max;
  }
}