/*
Reverse bits of an 32 bit unsigned integer

Example 1:

x = 0,

          00000000000000000000000000000000  
=>        00000000000000000000000000000000
return 0

Example 2:

x = 3,

          00000000000000000000000000000011 
=>        11000000000000000000000000000000
return 3221225472

Since java does not have unsigned int, use long
*/

public class Solution 
{
    public long reverse(long a) 
    {
        long ans = 0;
        long n = 1;
        int bits = 32;

        while(bits > 0)
        {
            if((n&a) != 0)
                ans += (long) Math.pow(2, bits-1);

            n <<= 1;
            bits--;
        }

        return ans;
    }
}
