/*
Given an unsorted integer array, find the first missing positive integer.

Example:

Given [1,2,0] return 3,

[3,4,-1,1] return 2,

[-8, -7, -6] returns 1

Your algorithm should run in O(n) time and use constant space.
*/

public class Solution 
{
    public int firstMissingPositive(int[] A) 
    {
        int index_neg = Integer.MAX_VALUE;
        int index_pos = Integer.MIN_VALUE;

        for(int i = 0; i<A.length; i++)
        {
            if(A[i] <= 0)
            {
                index_neg = i;
                break;
            }
        }

        for(int i = A.length-1; i>=0; i--)
        {
            if(A[i] > 0)
            {
                index_pos = i;
                break;
            }
        }

        while(index_neg < index_pos)
        {
            int temp = A[index_neg];
            A[index_neg] = A[index_pos];
            A[index_pos] = temp;

            while(A[index_neg] > 0)
                index_neg++;

            while(A[index_pos] <= 0)
                index_pos--;
        }
        
        for(int i = 0; i<=index_pos; i++)
        {
            int x = Math.abs(A[i]);
            if(x <= A.length)
                A[x-1] = -1*Math.abs(A[x-1]);
        }
            
        int missing = Math.max(-1, index_pos) + 2;
        for(int i = 0; i<=index_pos; i++)
        {
            if(A[i] > 0)
            {
                missing = i+1;
                break;
            }
        }

        return missing;
    }
}
