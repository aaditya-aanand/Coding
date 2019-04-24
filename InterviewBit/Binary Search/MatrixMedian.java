/*
Given a N cross M matrix in which each row is sorted, find the overall median of the matrix. Assume N*M is odd.

For example,

Matrix=
[1, 3, 5]
[2, 6, 9]
[3, 6, 9]

A = [1, 2, 3, 3, 5, 6, 6, 9, 9]

Median is 5. So, we return 5.
Note: No extra memory is allowed.
*/

public class Solution 
{
    public int findMedian(int[][] A) 
    {
        int r = A.length;
        int c = A[0].length;
        
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        
        for(int i = 0; i<A.length; i++)
        {
            min = Math.min(min, A[i][0]);
            max = Math.max(max, A[i][c-1]);
        }
            
        int el = (r*c + 1)/2;
        
        while(min < max)
        {
            int mid = min + (max-min)/2;
            int num = 0;
            
            for(int i = 0; i<r; i++)
            {
                int index = Arrays.binarySearch(A[i], mid);
                
                if(index >= 0)
                {
                    while(index < c && A[i][index] == mid)
                        index++;
                    
                    num += index;
                }
                
                else
                    num = num - index - 1;
            }
            
            if(num >= el)
                max = mid;
            
            else
                min = mid + 1;
        }
                
        return min;
    }
}
