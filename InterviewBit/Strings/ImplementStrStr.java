/*
Please Note:
Another question which belongs to the category of questions which are intentionally stated vaguely. 
Expectation is that you will ask for correct clarification or you will state your assumptions before you start coding.

Implement strStr().

strstr - locate a substring ( needle ) in a string ( haystack ). 
Try not to use standard library string functions for this question.

Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

NOTE: Good clarification questions:
What should be the return value if the needle is empty?
What if both haystack and needle are empty?
For the purpose of this problem, assume that the return value should be -1 in both cases.
*/

public class Solution 
{
    public int strStr(final String A, final String key) 
    {
        int la = A.length();
        int lk = key.length();

    lab:for(int i = 0; i<la-lk+1; i++)
        {
            for(int j = i; j<i+lk; j++)
            {
                if(A.charAt(j) != key.charAt(j-i))
                    continue lab;
            }

            return i;
        }

        return -1;
    }
}
