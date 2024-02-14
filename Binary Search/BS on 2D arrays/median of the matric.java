import java.util.Arrays;

public final class Solution 
{
    public static int findMedian(int matrix[][], int M, int N) 
    {

        int maximum = Integer.MIN_VALUE;
        int minimum = Integer.MAX_VALUE;

        // To find the minimum and maximum in the matrix
        for (int i = 0; i < M; i++) 
        {

            if (matrix[i][0] < minimum) 
            {
                minimum = matrix[i][0];
            }

            if (matrix[i][N - 1] > maximum) 
            {
                maximum = matrix[i][N - 1];
            }
        }

        // Count for the number to be the median
        int checkCount = (M * N + 1) / 2;

        // Binary search for the median
        while (minimum < maximum) 
        {
            int mid = minimum + (maximum - minimum) / 2;
            int count = 0;
            int find = 0;

            for (int i = 0; i < M; ++i) 
            {
                
                // Binary search for finding the count in each row
                find = Arrays.binarySearch(matrix[i], mid);

                
                // If the element is not present, get the position of where it should be
                // inserted
                
                if (find < 0) 
                {
                    
                    // Minus one because Arrays.BinarySearch return -(insertionPoint + 1)
                    find = Math.abs(find) - 1;
                }

                else 
                {
                    
                    // If the element is found then check for the best position of it Means in case
                    //  of duplicate elements just increase the index
                    while (find < matrix[i].length && matrix[i][find] == mid) 
                    {
                        find += 1;
                    }
                }
                
                // Increment count
                count = count + find;
            }

            if (count < checkCount) 
            {
                minimum = mid + 1;
            }
            else 
            {
                maximum = mid;
            }
        }
        
        // Finally return the answer
        return minimum;
    }

}

//solution2
public final class Solution {
    public static int countSmallerThanMid(int[] A, int mid, int n) {
      int l = 0, h = n - 1;
      while (l <= h) {
        int md = (l + h) >> 1;
        if (A[md] <= mid) {
          l = md + 1;
        } else {
          h = md - 1;
        }
      }
      return l;
    }
  
    public static int Median(int[][] A, int row, int col) {
      int low = 1;
      int high = 0;
      for (int j = 0; j < row; j++) {
        high = Math.max(high, A[j][col - 1]);
      }
      int n = row;
      int m = col;
      while (low <= high) {
        int mid = (low + high) >> 1;
        int cnt = 0;
        for (int i = 0; i < n; i++) {
          cnt += countSmallerThanMid(A[i], mid, m);
        }
        if (cnt <= (n * m) / 2)
          low = mid + 1;
        else
          high = mid - 1;
      }
      return low;
    }
  
    public static int findMedian(int matrix[][], int m, int n) {
      return Median(matrix, m, n);
    }
  }
  