/* Recursive approach */
public static long gcd(long a, long b)
{
    return b == 0 ? a : gcd(b, a%b);
}

/* Iterative approach */
public static long gcd(long a, long b)
{
    long dividend = a >= b ? a : b;
    long divisor = a <= b ? a : b;

    while(divisor != 0)
    {
        long remainder = dividend%divisor;
        dividend = divisor;
        divisor = remainder;
    }

    return dividend;
}
