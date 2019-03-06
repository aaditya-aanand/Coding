/*
Given an array of integers, find the length of longest subsequence which is first increasing then decreasing.

**Example: **

For the given array [1 11 2 10 4 5 2 1]

Longest subsequence is [1 2 10 4 2 1]

Return value 6
*/

public class Solution 
{
    public int longestSubsequenceLength(final int[] arr) 
    {
        int n = arr.length;
        int lis_lr[] = new int[n];
        int lis_rl[] = new int[n];

        for(int i = 0; i<n; i++)
        {
            lis_lr[i] = 1;
            lis_rl[i] = 1;
        }

        for(int i = 1; i<n; i++)
        {
            for(int j = 0; j<i; j++)
            {
                if(arr[i] > arr[j])
                    lis_lr[i] = Math.max(lis_lr[i], lis_lr[j]+1);
            }
        }

        for(int i = n-2; i>=0; i--)
        {
            for(int j = n-1; j>i; j--)
            {
                if(arr[i] > arr[j])
                    lis_rl[i] = Math.max(lis_rl[i], lis_rl[j]+1);
            }
        }

        int max = 0;
        for(int i = 0; i<n; i++)
            max = Math.max(max, lis_lr[i]+lis_rl[i]-1);

        return max;
    }
}
