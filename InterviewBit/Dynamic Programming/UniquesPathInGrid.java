/*
Given a grid of size m * n, lets assume you are starting at (1,1) and your goal is to reach (m,n). At any instance, if you are on (x,y), you can either go to (x, y + 1) or (x + 1, y).

Now consider if some obstacles are added to the grids. How many unique paths would there be?
An obstacle and empty space is marked as 1 and 0 respectively in the grid.

Example :
There is one obstacle in the middle of a 3x3 grid as illustrated below.

[
  [0,0,0],
  [0,1,0],
  [0,0,0]
]
The total number of unique paths is 2.

Note: m and n will be at most 100. 
*/

public class Solution 
{
    public int uniquePathsWithObstacles(int[][] A) 
    {
        int rows = A.length;
        int cols = A[0].length;

        for(int i = 0; i<rows; i++)
            for(int j = 0; j<cols; j++)
                A[i][j] = (A[i][j]+1)%2;

        for(int i = rows-1; i>-1; i--)
        {
            for(int j = cols-1; j>-1; j--)
            {
                if(i == rows-1)
                    A[i][j] = (j == cols-1) ? A[i][j] : A[i][j+1]*A[i][j];

                else if(j == cols-1)
                    A[i][j] = (i == rows-1) ? A[i][j] : A[i+1][j]*A[i][j];

                else if(A[i][j] != 0)
                    A[i][j] = A[i][j+1] + A[i+1][j];
            }
        }

        return A[0][0];
    }
}
