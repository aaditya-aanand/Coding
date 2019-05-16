/*
Given A, how many structurally unique BST’s (binary search trees) that store values 1...A?

Example :

Given A = 3, there are a total of 5 unique BST’s.


   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3
*/

public class Solution 
{
    public int numTrees(int A) 
    {
        int dp[] = new int[A+1];
        dp[0] = dp[1] = 1;
        
        for (int i = 2; i < dp.length; i++) 
        {
            int ways = 0;
            for(int j = 1; j<=i; j++)
                ways += dp[j-1]*dp[i-j];
            
            dp[i] = ways;
        }
        
        return dp[A];
    }
}
