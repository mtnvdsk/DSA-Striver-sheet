public class Solution {
    public static void quickSort(int[] input, int startIndex, int endIndex) { 
        if (startIndex < endIndex) { 
            int loc = Partition(input, startIndex, endIndex);
             quickSort(input, startIndex, loc - 1);
             quickSort(input, loc + 1, endIndex); 
        }
     }
    public static int Partition(int[] input, int startIndex, int endIndex) { 
 
        int pivot = input[startIndex]; 
        int start = startIndex; 
        int end = endIndex;
        while (start < end) {
             while (start < endIndex && input[start] <= pivot) {
                 start++;
             } 
            while (end > startIndex && input[end] > pivot) {
                 end--;
             } 
            if (start < end) {
                 int temp = input[start];
                 input[start] = input[end]; 
                 input[end] = temp; 
            }
         }
         input[startIndex] = input[end];
         input[end] = pivot;
         return end;
     }
  }  