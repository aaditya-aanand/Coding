/*
You are given an array of N integers, A1, A2 ,…, AN. Return maximum value of f(i, j) for all 1 ≤ i, j ≤ N.
f(i, j) is defined as |A[i] - A[j]| + |i - j|, where |x| denotes absolute value of x.

For example,

A=[1, 3, -1]

f(1, 1) = f(2, 2) = f(3, 3) = 0
f(1, 2) = f(2, 1) = |1 - 3| + |1 - 2| = 3
f(1, 3) = f(3, 1) = |1 - (-1)| + |1 - 3| = 4
f(2, 3) = f(3, 2) = |3 - (-1)| + |2 - 3| = 5

So, we return 5.
*/

// There are four ways to write the function f(i, j); 2 ways for |i-j| namely i-j and j-i; 2 ways for |A[i]-A[j]| in same manner, 
// once you write the expanded formula, solution comes out automatically!

public class Solution 
{
    public int maxArr(int[] A) 
    {
        int max_1 = Integer.MIN_VALUE;
        int max_2 = max_1;

        int min_1 = Integer.MAX_VALUE;
        int min_2 = min_1;

        for(int i = 0; i<A.length; i++)
        {
            max_1 = Math.max(max_1, A[i]+i);
            max_2 = Math.max(max_2, A[i]-i);
            min_1 = Math.min(min_1, A[i]+i);
            min_2 = Math.min(min_2, A[i]-i);
        }

        return Math.max(max_1-min_1, max_2-min_2);
    }
}
