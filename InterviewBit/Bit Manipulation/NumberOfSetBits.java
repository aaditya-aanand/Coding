/*
Write a function that takes an unsigned integer and returns the number of 1 bits it has.

Example:

The 32-bit integer 11 has binary representation

00000000000000000000000000001011
so the function should return 3.

Note that since Java does not have unsigned int, use long for Java
*/

public class Solution 
{
    public int numSetBits(long a) 
    {
        long n = 1;
        int k = 32;

        int ans = 0;
        while(k > 0)
        {
            if((n&a) != 0)
                ans++;

            n = n<<1;
            k--;
        }

        return ans;
    }
}
