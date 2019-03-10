/*
Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.

If the last word does not exist, return 0.

Note: A word is defined as a character sequence consists of non-space characters only.

Example:

Given s = "Hello World",

return 5 as length("World") = 5.

Please make sure you try to solve this problem without using library functions. Make sure you only traverse the string once.
*/

public class Solution 
{
    public int lengthOfLastWord(final String A) 
    {
        String B = A.trim();
        int start = 0;
        int i = 0;

        for(i = 0; i<B.length(); i++)
        {
            if(B.charAt(i) == ' ')
                start = i+1;
        }
        
        return (B.length() > 0) ? i-start : 0;
    }
}
