import java.util.ArrayList;
import java.util.*;
public class Solution {
    public static List<List<Integer>> fourSum(int []nums, int target) {
        List<List<Integer>> a=new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++){
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            for(int j=i+1;j<nums.length;j++){
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;
                int l=nums.length-1;
                int k=j+1;
                while(k<l){
                    if(nums[i]+nums[j]+nums[l]+nums[k]==target){
                        List<Integer> b=new ArrayList<>();
                        b.add(nums[i]);
                        b.add(nums[j]);
                        b.add(nums[k]);
                        b.add(nums[l]);
                        a.add(b);
                        k++;
                        l--;
                        while(k<l && nums[k]==nums[k-1])k++;
                        while(k<l && nums[l]==nums[l+1])l--;
                    }else if(nums[i]+nums[j]+nums[l]+nums[k]<target)k++;
                    else l--;
                }
            }
        }
        return a;
    }
}