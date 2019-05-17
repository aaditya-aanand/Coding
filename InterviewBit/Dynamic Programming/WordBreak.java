/*
Given a string s and a dictionary of words dict, determine if s can be segmented into a space-separated sequence of one or more dictionary words.

For example, given

s = "myinterviewtrainer",
dict = ["trainer", "my", "interview"].
Return 1 ( corresponding to true ) because "myinterviewtrainer" can be segmented as "my interview trainer".

Return 0 / 1 ( 0 for false, 1 for true ) for this problem
*/

public class Solution 
{
    public int wordBreak(String word, String[] B) 
    {
        int n = B.length;
        HashSet<String> dict = new HashSet<String>();

        for(int i = 0; i<n; i++)
            dict.add(B[i]);

        int len = word.length();
        boolean dp[] = new boolean[len];

    lab:for(int i = 0; i<len; i++)
        {
            for(int j = 0; j<i; j++)
            {
                dp[i] = (dp[j] & dict.contains(word.substring(j+1, i+1)));
                if(dp[i]) continue lab;
            }
                
            if(dict.contains(word.substring(0, i+1)))
                dp[i] = true;
        }
        
        return dp[len-1] ? 1 : 0;
    }
}
