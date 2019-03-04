/*
Given numRows, generate the first numRows of Pascal’s triangle.

Pascal’s triangle : To generate A[C] in row R, sum up A’[C] and A’[C-1] from previous row R - 1.

Example:

Given numRows = 5,

Return

[
     [1],
     [1,1],
     [1,2,1],
     [1,3,3,1],
     [1,4,6,4,1]
]
*/

public class Solution 
{
    public int[][] solve(int A) 
    {
        int pascal[][] = new int[A][];
        for(int i = 0; i<A; i++)
        {
            pascal[i] = new int[i+1];
            for(int j = 0; j<i+1; j++)
            {
                if(j == 0 || j == i)
                    pascal[i][j] = 1;

                else
                    pascal[i][j] = pascal[i-1][j] + pascal[i-1][j-1];
            }
        }

        return pascal;
    }
}
