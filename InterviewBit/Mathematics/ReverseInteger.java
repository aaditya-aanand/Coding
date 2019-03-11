/*
Reverse digits of an integer.

Example1:

x = 123,

return 321
Example2:

x = -123,

return -321

Return 0 if the result overflows and does not fit in a 32 bit signed integer
*/

public class Solution 
{
    public int reverse(int A) 
    {
        long n = A;
        boolean neg = false;
        if(A<0)
        {
            A = -A;
            neg = true;
        }

        long rev = 0;
        while(A > 0)
        {
            rev = 10*rev + A%10;
            A = A/10;
        }

        if(rev > Integer.MAX_VALUE || rev < Integer.MIN_VALUE)
            rev = 0;
        
        return neg ? (int) -rev : (int) rev;
    }
}
