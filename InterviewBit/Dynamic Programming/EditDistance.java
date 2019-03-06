/*
Given two words A and B, find the minimum number of steps required to convert A to B. (each operation is counted as 1 step.)

You have the following 3 operations permitted on a word:

Insert a character
Delete a character
Replace a character
Example : 
edit distance between
"Anshuman" and "Antihuman" is 2.

Operation 1: Replace s with t.
Operation 2: Insert i.
*/

public class Solution 
{
    public int minDistance(String A, String B) 
    {
        int a = A.length();
        int b = B.length();

        int dp[][] = new int[a+1][b+1];

        for(int i = 0; i<a+1; i++)
        {
            for(int j = 0; j<b+1; j++)
            {
                if(i == 0 || j == 0)
                    dp[i][j] = i+j;

                else if(A.charAt(i-1) == B.charAt(j-1))
                    dp[i][j] = dp[i-1][j-1];

                else
                    dp[i][j] = 1 + Math.min(Math.min(dp[i-1][j], dp[i][j-1]), dp[i-1][j-1]);
            }
        }

        return dp[a][b];
    }
}
