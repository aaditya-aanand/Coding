/*
Given a positive integer which fits in a 32 bit signed integer, find if it can be expressed as A^P where P > 1 and A > 0. A and P both should be integers.

Example

Input : 4
Output : True  
as 2^2 = 4. 
*/

public class Solution 
{
    public int isPower(int A) 
    {
        if(A == 0 || A == 1)
            return A;

        for(int i = 2; i <= Math.sqrt(A); i++)
        {
            double log = Math.log10(A)/Math.log10(i);
            double eps = Math.abs(Math.round(log) - log);
            
            if(eps < 0.0000001)
                return 1;
        }

        return 0;
    }
}
