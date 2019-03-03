/*
Implement int sqrt(int x).

Compute and return the square root of x.

If x is not a perfect square, return floor(sqrt(x))

Example :

Input : 11
Output : 3
DO NOT USE SQRT FUNCTION FROM STANDARD LIBRARY
*/

public class Solution 
{
    public static long driverSqrt(long a, long low, long high)
    {
        long mid = (low + high)/2;
        
        if(low >= high && mid*mid < a)
            return mid;
        
        if(mid*mid == a)
            return mid;

        else if(mid*mid > a)
            return driverSqrt(a, low, mid-1);

        return driverSqrt(a, mid+1, high);
    }

    public int sqrt(int a) 
    {
        return (int)driverSqrt(a, 0, 1 + a/2);
    }
}
