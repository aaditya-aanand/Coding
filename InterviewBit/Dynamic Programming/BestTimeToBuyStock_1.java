/*
Say you have an array for which the ith element is the price of a given stock on day i.

If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.

Example :

Input : [1 2]
Return :  1
*/

public class Solution 
{
    public int maxProfit(final int[] A) 
    {
        int max[] = new int[A.length];
        
        if(A.length != 0)
            max[A.length-1] = A[A.length-1];

        for(int i = A.length-2; i>-1; i--)
            max[i] = Math.max(A[i], max[i+1]);

        int ans = 0;
        for(int i = 0; i<A.length-1; i++)
            ans = Math.max(ans, max[i+1]-A[i]);

        return ans;
    }
}
