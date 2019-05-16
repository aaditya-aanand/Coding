/*
Given a string s, partition s such that every substring of the partition is a palindrome.

Return the minimum cuts needed for a palindrome partitioning of s.

Example : 
Given 
s = "aab",
Return 1 since the palindrome partitioning ["aa","b"] could be produced using 1 cut.
*/

public class Solution 
{
    public static boolean isPalin(String s, int start, int end)
    {
        while(start < end)
        {
            if(s.charAt(start++) != s.charAt(end--))
                return false;
        }
        
        return true;
    }
    
    public int minCut(String A) 
    {
        int n = A.length();
        int dp[][] = new int[n][n];

        for(int i = 1; i<dp.length; i++)
        {
            int r = 0;
            int c = i;

            while(r < dp.length && c < dp[0].length)
            {
                if(isPalin(A, r, c))
                {
                    dp[r++][c++] = 0;
                    continue;
                }
                
                int min = Integer.MAX_VALUE;
                for(int k = r; k<c; k++)
                    min = Math.min(min, dp[r][k] + dp[k+1][c] + 1);

                dp[r++][c++] = min;
            }
        }

        return dp[0][n-1];
    }
}
