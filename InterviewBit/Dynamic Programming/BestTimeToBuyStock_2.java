/*
Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete as many transactions as you like (ie, buy one and sell one share of the stock multiple times). However, you may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).

Example :

Input : [1 2 3]
Return : 2
*/

public class Solution 
{
    public int maxProfit(final int[] A) 
    {
        int ans = 0;
        for(int i = 1; i<A.length; i++)
            ans += Math.max(0, A[i]-A[i-1]);
            
        return ans;
    }
}
