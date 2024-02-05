public class Solution {
    public static int getSingleElement(int []arr){
        
        int x=0;
        for(int i=0;i<arr.length;i++){
            x=x^arr[i];
        }
        return x;
    }
}

//solution2

import java.util.*;
public class Solution {
    public static int getSingleElement(int []arr){
        int n = arr.length;
        int ans = 0;

        // Traversing through the array.
        for(int i = 0; i < n; ++i){

            // Checking if 'Arr[i]' is neither equal to 'Arr[i - 1]' and 'Arr[i + 1]'.
            if((i == 0 || arr[i] != arr[i - 1]) && (i == n - 1 || arr[i] != arr[i + 1])){
                ans = arr[i];
                break;
            }
        }
        return ans;
    }
}


//solution3
import java.util.*;
public class Solution {
    public static int getSingleElement(int []arr){
        int n = arr.length;

        // Creating an empty stack named, 'St'.
        Stack< Integer > st = new Stack<>();

        // Traversing through the array.
        for(int i = 0; i < n; ++i){
            if(st.isEmpty() || st.peek() != arr[i])
                st.add(arr[i]);
            else
                st.pop();
        }
        return st.peek();
    }
}

//solution4
import java.util.*;
public class Solution {
    public static int getSingleElement(int []arr){
        int n = arr.length;

        // Creating an empty hashmap named 'Frequency' to store the frequency of an element in 'Arr'.
        HashMap<Integer, Integer> frequency = new HashMap<>();
        for(int i = 0; i < n; ++i){
            frequency.put(arr[i], frequency.getOrDefault(arr[i], 0) + 1);
        }
        int ans = 0;

        // Finding the element which occurs only once.
        for(int i = 0; i < n; ++i){
            if(frequency.getOrDefault(arr[i], 0) == 1)
                ans = arr[i];
        }
        return ans;
    }
}