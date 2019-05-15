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

//Laying histogram method by STACK

public class Solution
{
    public int maximalRectangle(int[][] A)
    {
        int rows = A.length;
        int cols = A[0].length;

        for(int i = 0; i<rows; i++)
            for(int j = cols-2; j>=0; j--)
                A[i][j] = (A[i][j+1] == 0) ? A[i][j] : A[i][j]*(A[i][j] + A[i][j+1]);
        
        int maximum = 0;
        for(int j = 0; j<cols; j++)
        {
            int next_small_left_index[] = new int[rows];
            int next_small_right_index[] = new int[rows];

            Stack<Integer> left = new Stack<Integer>();
            Stack<Integer> right = new Stack<Integer>();

            for(int i = 0; i<rows; i++)
            {
                int x = A[i][j];
                while(!left.isEmpty() && A[left.peek()][j] >= x)
                    left.pop();

                next_small_left_index[i] = (left.isEmpty()) ? -1 : left.peek();
                left.push(i);
            }

            for(int i = rows-1; i>=0; i--)
            {
                int x = A[i][j];
                while(!right.isEmpty() && A[right.peek()][j] >= x)
                    right.pop();

                next_small_right_index[i] = (right.isEmpty()) ? rows : right.peek();
                right.push(i);
            }

            int max = 0;
            for(int i = 0; i<rows; i++)
            {
                int l = next_small_left_index[i];
                int r = next_small_right_index[i];

                max = Math.max(max, (r-l-1)*A[i][j]);
            }

            maximum = Math.max(maximum, max);
        }

        return maximum;
    }
}
