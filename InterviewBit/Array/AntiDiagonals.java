/*
Give a N*N square matrix, return an array of its anti-diagonals. Look at the example for more details.

Example:

		
Input: 	

1 2 3
4 5 6
7 8 9

Return the following :

[ 
  [1],
  [2, 4],
  [3, 5, 7],
  [6, 8],
  [9]
]


Input : 
1 2
3 4

Return the following  : 

[
  [1],
  [2, 3],
  [4]
]
*/

public class Solution 
{
    public int[][] diagonal(int[][] A) 
    {
        int order = A.length;
        int mat[][] = new int[2*order-1][];

        for(int i = 0; i<mat.length; i++)
        {
            int num = (i < order) ? i+1 : mat[i-1].length-1;
            mat[i] = new int[num];

            int sr;
            int sc;
            if(i < order)
            {
                sr = 0;
                sc = i;
            }

            else
            {
                sr = 1 + i - order;
                sc = order-1;
            }

            for(int j = 0; j<num; j++)
                mat[i][j] = A[sr++][sc--];
        }

        return mat;
    }
}
