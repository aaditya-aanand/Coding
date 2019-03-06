/*
Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.

For example, given the following triangle

[
     [2],
    [3,4],
   [6,5,7],
  [4,1,8,3]
]
The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).

Note:
Bonus point if you are able to do this using only O(n) extra space, where n is the total number of rows in the triangle. 
*/

public class Solution 
{
    public int minimumTotal(ArrayList<ArrayList<Integer>> a) 
    {
        int rows = a.size();

        for(int i = rows-2; i>-1; i--)
            for(int j = 0; j<=i; j++)
                a.get(i).set(j, a.get(i).get(j) + Math.min(a.get(i+1).get(j), a.get(i+1).get(j+1)));

        return a.get(0).get(0);
    }
}
