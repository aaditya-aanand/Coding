/*
Given a 2D binary matrix filled with 0’s and 1’s, find the largest rectangle containing all ones and return its area.

Bonus if you can solve it in O(n^2) or less.

Example :

A : [  1 1 1
       0 1 1
       1 0 0 
    ]

Output : 4 

As the max area rectangle is created by the 2x2 rectangle created by (0,1), (0,2), (1,1) and (1,2)
*/

public class Solution 
{
    public int maximalRectangle(int[][] A) 
    {
        int rows = A.length;
        int cols = A[0].length;
        
        for(int i = 0; i<rows; i++)
        {
            for(int j = cols-2; j>=0; j--)
            {
                A[i][j] = (A[i][j+1] == 0) ? A[i][j] : A[i][j]*(A[i][j] + A[i][j+1]);
            }
        }
        
        int max = 0;
        for(int i = 0; i<rows; i++)
        {
            for(int j = 0; j<cols; j++)
            {
                if(A[i][j] != 0)
                {
                    int local_max = A[i][j];
                    int min = A[i][j];
                    int k = i;
                    while(k<rows && A[k][j] != 0)
                    {
                        min = Math.min(min, A[k][j]);
                        local_max = Math.max(local_max, (k+1-i)*min);
                        k++;
                    }
                    
                    max = Math.max(max, local_max);
                }
            }
        }
        
        return max;
    }
}
