/*
Write an efficient algorithm that searches for a value in an m x n matrix.

This matrix has the following properties:

Integers in each row are sorted from left to right.
The first integer of each row is greater than or equal to the last integer of the previous row.
Example:

Consider the following matrix:

[
  [1,   3,  5,  7],
  [10, 11, 16, 20],
  [23, 30, 34, 50]
]
Given target = 3, return 1 ( 1 corresponds to true )

Return 0 / 1 ( 0 if the element is not present, 1 if the element is present ) for this problem

*/

public class Solution 
{
    public int searchMatrix(ArrayList<ArrayList<Integer>> a, int key) 
    {
        int num_rows = a.size();
        int num_cols = a.get(0).size();

        if(key < a.get(0).get(0) || key > a.get(num_rows-1).get(num_cols-1))
            return 0;

        int low = 0;
        int high = num_rows-1;

        while(low <= high)
        {
            int mid = low + (high-low)/2;
            int el = a.get(mid).get(0);

            if(key == el)
                return 1;

            else if(key < el)
                high = mid-1;

            else
                low = mid+1;
        }

        int row = low-1;
        low = 0; high = num_cols-1;

        while(low <= high)
        {
            int mid = low + (high-low)/2;
            int el = a.get(row).get(mid);

            if(key == el)
                return 1;

            else if(key < el)
                high = mid-1;

            else
                low = mid+1;
        }

        return 0;
    }
}
