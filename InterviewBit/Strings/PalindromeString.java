/*
Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

Example:

"A man, a plan, a canal: Panama" is a palindrome.

"race a car" is not a palindrome.

Return 0 / 1 ( 0 for false, 1 for true ) for this problem
*/

public class Solution 
{
    public int isPalindrome(String A) 
    {
        A = A.toUpperCase();
        int start = 0;
        int end = A.length()-1;

        while(start < end)
        {
            if(!((A.charAt(start) >= 'A' && A.charAt(start) <= 'Z') || (A.charAt(start) >= '0' && A.charAt(start) <= '9')))
                start++;

            else if(!((A.charAt(end) >= 'A' && A.charAt(end) <= 'Z') || (A.charAt(end) >= '0' && A.charAt(end) <= '9')))
                end--;

            else if(A.charAt(start) == A.charAt(end))
            {
                start++;
                end--;
            }

            else
                return 0;
        }

        return 1;
    }
}
