/*
Given an integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.

Example:

Given n = 3,

You should return the following matrix:

[
  [ 1, 2, 3 ],
  [ 8, 9, 4 ],
  [ 7, 6, 5 ]
]
*/

public class Solution 
{
    public int[][] generateMatrix(int n) 
    {
        int rows = n;
        int cols = n;
        int A[][] = new int[rows][cols];

        int top = 0;
        int bot = rows-1;

        int left = 0;
        int right = cols-1;

        int dir = 0;
        int c = 0;
        while(top <= bot && left <= right)
        {
            if(dir == 0)
            {
                for(int i = left; i<=right; i++)
                    A[top][i] = ++c;

                top++;
            }

            else if(dir == 1)
            {
                for(int i = top; i<=bot; i++)
                    A[i][right] = ++c;

                right--;
            }

            else if(dir == 2)
            {
                for(int i = right; i>=left; i--)
                    A[bot][i] = ++c;

                bot--;
            }

            else
            {
                for(int i = bot; i>=top; i--)
                    A[i][left] = ++c;

                left++;
            }

            dir = (dir+1)%4;
        }

        return A;
        
    }
}
