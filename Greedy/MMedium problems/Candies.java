import java.util.*;
public class Solution {
    public static int requiredCandies(int[] students) {
        int []candies=new int[students.length];
        int n=students.length;
        Arrays.fill(candies,1);
        int sum=0;
        for(int i=1;i<n;i++){
            if(students[i]>students[i-1])
                candies[i]=candies[i-1]+1;
        }
        for(int i=n-2;i>=0;i--){
            if(students[i]>students[i+1]){
                candies[i]=Math.max(candies[i],candies[i+1]+1);
            }
        }
        for(int i:candies)
            sum+=i;
        return sum;
    }   
}
