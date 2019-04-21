/*
Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete at most two transactions.

Note:
You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).

Example :

Input : [1 2 1 2]
Output : 2

Explanation : 
  Day 1 : Buy 
  Day 2 : Sell
  Day 3 : Buy
  Day 4 : Sell
*/

public class Solution 
{
    public int maxProfit(final int[] A) 
    {
        int days = A.length;
        if(days < 2) return 0;
        
        int transactions = 2;

        int mat[][] = new int[transactions+1][days];
        int arr[][] = new int[transactions+1][days];

        for(int i = 0; i<=transactions; i++)
            arr[i][0] = -A[0];

        for(int j = 1; j<days; j++)
            arr[0][j] = Math.max(arr[0][j-1], -A[j]);

        for(int i = 1; i<=transactions; i++)
        {
            for(int j = 1; j<days; j++)
            {
                mat[i][j] = Math.max(mat[i][j-1], arr[i-1][j-1] + A[j]);
                arr[i][j] = Math.max(arr[i][j-1], mat[i][j] - A[j]);
            }
        }

        return mat[transactions][days-1];
    }
}
