/*
Write a function to find the longest common prefix string amongst an array of strings.

Longest common prefix for a pair of strings S1 and S2 is the longest string S which is the prefix of both S1 and S2.

As an example, longest common prefix of "abcdefgh" and "abcefgh" is "abc".

Given the array of strings, you need to find the longest S which is the prefix of ALL the strings in the array.

Example:

Given the array as:

[

  "abcdefgh",

  "aefghijk",

  "abcefgh"
]

The answer would be “a”.
*/

public class Solution 
{
    public static String lcp(String a, String b)
    {
        String ans = "";
        int i = 0;
        
        while(i < a.length() && i < b.length())
        {
            if(a.charAt(i) == b.charAt(i))
                ans += a.charAt(i++);
            
            else
                break;
        }

        return ans;
    }

    public String longestCommonPrefix(String[] A) 
    {
        String ans = A[0];

        for(int i = 1; i<A.length; i++)
            ans = lcp(ans, A[i]);

        return ans;
    }
}
