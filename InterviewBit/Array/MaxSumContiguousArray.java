/*
Find the contiguous subarray within an array (containing at least one number) which has the largest sum.

For example:

Given the array [-2,1,-3,4,-1,2,1,-5,4],

the contiguous subarray [4,-1,2,1] has the largest sum = 6.

For this problem, return the maximum sum.
*/

public class Solution 
{
    public int maxSubArray(final int[] A) 
    {
        int maxEndingSoFar = Integer.MIN_VALUE;
        int maxEndingHere = 0;

        for(int i = 0; i<A.length; i++)
        {
            maxEndingHere += A[i];
            maxEndingSoFar = Math.max(maxEndingSoFar, maxEndingHere);

            if(maxEndingHere < 0)
                maxEndingHere = 0;
        }

        return maxEndingSoFar;
    }
}
