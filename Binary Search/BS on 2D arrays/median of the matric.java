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