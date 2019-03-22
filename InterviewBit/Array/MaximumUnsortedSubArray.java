/*
You are given an array (zero indexed) of N non-negative integers, A0, A1 ,…, AN-1.
Find the minimum sub array Al, Al+1 ,…, Ar so if we sort(in ascending order) that sub array, then the whole array should get sorted.
If A is already sorted, output -1.

Example :

Input 1:

A = [1, 3, 2, 4, 5]

Return: [1, 2]

Input 2:

A = [1, 2, 3, 4, 5]

Return: [-1]
In the above example(Input 1), if we sort the subarray A1, A2, then whole array A should get sorted.
*/

public class Solution 
{
    public int[] subUnsort(int[] A) 
    {
        int n = A.length;
        if(n < 2) return new int[]{-1};

        int start = -1;
        int end = -1;

        for(int i = 1; i<n; i++)
        {
            if(A[i] < A[i-1])
            {
                start = i-1;
                break;
            }
        }

        for(int i = n-2; i>-1; i--)
        {
            if(A[i] > A[i+1])
            {
                end = i+1;
                break;
            }
        }

        if((start + end) == -2) return new int[]{-1};

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for(int i = start; i<=end; i++)
        {
            min = Math.min(min, A[i]);
            max = Math.max(max, A[i]);
        }

        int istart = start;
        int iend = end;

        for(int i = 0; i<start; i++)
        {
            if(A[i] > min)
            {
                istart = i;
                break;
            }
        }

        for(int i = n-1; i>end; i--)
        {
            if(A[i] < max)
            {
                iend = i;
                break;
            }
        }
        
        return new int[]{istart, iend};
    }
}
