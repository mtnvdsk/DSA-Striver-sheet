import java.util.List;
import java.util.*;
public class Solution {
   public static List< Integer > collidingAsteroids(int []asteroids) {
       //    Write your code here.
        Stack<Integer>st=new Stack<>();

       for(int val:asteroids)
       {

           if(val>0)
           {
               st.push(val);
           }
           else{

               while(st.size()>0&&st.peek()>0&&st.peek()<-val)
               {
                   st.pop();
               }
               if(st.size()>0&&st.peek()==-val)
               {
                   st.pop();
               }
               else if(st.size()>0&&st.peek()>-val)
               {
               else{
                   st.push(val);
               }
               }
       }
       List<Integer> ans = new ArrayList<>(st);
       return ans;

   }
}