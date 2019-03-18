/*
Given an m x n matrix of 0s and 1s, if an element is 0, set its entire row and column to 0.

Do it in place.

Example

Given array A as

1 0 1
1 1 1 
1 1 1
On returning, the array A should be :

0 0 0
1 0 1
1 0 1
Note that this will be evaluated on the extra memory used. Try to minimize the space and time complexity.
*/

public class Solution 
{
    public void setZeroes(ArrayList<ArrayList<Integer>> a) 
    {
        int row = a.size();
        int col = a.get(0).size();

        boolean row_flag = false;
        boolean col_flag = false;

        for(int i = 0; i<row; i++)
        {
            for(int j = 0; j<col; j++)
            {
                if(a.get(i).get(j) == 0)
                {
                    a.get(0).set(j, 0);
                    a.get(i).set(0, 0);

                    if(i == 0)
                        col_flag = true;

                    if(j == 0)
                        row_flag = true;    
                }
            }
        }

        for(int i = 1; i<row; i++)
        {
            if(a.get(i).get(0) == 0)
            {
                for(int j = 0; j<col; j++)
                    a.get(i).set(j, 0);
            }
        }

        for(int i = 1; i<col; i++)
        {
            if(a.get(0).get(i) == 0)
            {
                for(int j = 0; j<row; j++)
                    a.get(j).set(i, 0);
            }
        }

        if(col_flag)
        {
            for(int j = 0; j<col; j++)
                    a.get(0).set(j, 0);
        }

        if(row_flag)
        {
            for(int j = 0; j<row; j++)
                a.get(j).set(0, 0);
        }
    }
}
