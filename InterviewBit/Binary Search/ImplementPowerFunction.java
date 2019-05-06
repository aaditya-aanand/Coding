/*
Implement pow(x, n) % d.

In other words, given x, n and d,

find (xn % d)

Note that remainders on division cannot be negative. 
In other words, make sure the answer you return is non negative.

Input : x = 2, n = 3, d = 3
Output : 2

2^3 % 3 = 8 % 3 = 2.
*/

public class Solution 
{
    public int pow(int x, int n, int d) 
    {
        long base = (long) x;
        long exp = (long) n;
        long modulo = (long) d;
        
        if(modulo == 1)
            return 0;
            
        long result = 1;
        while(exp > 0)
        {
            if(exp%2 == 1)
              result = ((result%modulo)*(base%modulo))%modulo;
        
            base = ((base%modulo)*(base%modulo))%modulo;
            exp = exp/2;
        }
        
        return (int) ((result + modulo)%modulo);
    }
}
