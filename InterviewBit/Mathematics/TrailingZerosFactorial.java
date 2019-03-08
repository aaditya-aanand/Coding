/*
Given an integer n, return the number of trailing zeroes in n!.

Note: Your solution should be in logarithmic time complexity.

Example :

n = 5
n! = 120 
Number of trailing zeros = 1
So, return 1
*/

public class Solution 
{
    public int trailingZeroes(int A) 
    {
        int n = 5;
        int ans = 0;
        while(A/n > 0)
        {
            ans += A/n;
            n = n*5;
        }

        return ans;
    }
}
