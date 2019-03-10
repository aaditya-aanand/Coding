/*
Given a matrix of m * n elements (m rows, n columns), return all elements of the matrix in spiral order.

Example:

Given the following matrix:

[
    [ 1, 2, 3 ],
    [ 4, 5, 6 ],
    [ 7, 8, 9 ]
]
You should return

[1, 2, 3, 6, 9, 8, 7, 4, 5]
*/

public class Solution 
{
    public int[] spiralOrder(final int[][] A) 
    {
        int rows = A.length;
        int cols = A[0].length;
        int ans[] = new int[rows*cols];

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
                    ans[c++] = A[top][i];

                top++;
            }

            else if(dir == 1)
            {
                for(int i = top; i<=bot; i++)
                    ans[c++] = A[i][right];

                right--;
            }

            else if(dir == 2)
            {
                for(int i = right; i>=left; i--)
                    ans[c++] = A[bot][i];

                bot--;
            }

            else
            {
                for(int i = bot; i>=top; i--)
                    ans[c++] = A[i][left];

                left++;
            }

            dir = (dir+1)%4;
        }

        return ans;
        
    }
}
