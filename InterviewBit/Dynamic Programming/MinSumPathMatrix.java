/*
Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.

 Note: You can only move either down or right at any point in time. 
Example :

Input : 

    [  1 3 2
       4 3 1
       5 6 1
    ]

Output : 8
     1 -> 3 -> 2 -> 1 -> 1
     
*/

public class Solution 
{
    public int minPathSum(int[][] A) 
    {
        int rows = A.length;
        int cols = A[0].length;

        for(int i = 0; i<rows; i++)
        {
            for(int j = 0; j<cols; j++)
            {
                if(i == 0)
                    A[i][j] = (j == 0) ? A[i][j] : A[i][j] + A[i][j-1];

                else if(j == 0)
                    A[i][j] = (i == 0) ? A[i][j] : A[i][j] + A[i-1][j];

                else
                    A[i][j] += Math.min(A[i-1][j], A[i][j-1]);
            }
        }

        return A[rows-1][cols-1];
    }
}
