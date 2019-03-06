/*
Find the longest increasing subsequence of a given sequence / array.

In other words, find a subsequence of array in which the subsequence’s elements are in strictly increasing order, and in which the subsequence is as long as possible. 
This subsequence is not necessarily contiguous, or unique.
In this case, we only care about the length of the longest increasing subsequence.

Example :

Input : [0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15]
Output : 6
The sequence : [0, 2, 6, 9, 13, 15] or [0, 4, 6, 9, 11, 15] or [0, 4, 6, 9, 13, 15]
*/

public class Solution 
{
    public int lis(final int[] arr) 
    {
        int lis[] = new int[arr.length];
        for(int i = 0; i<arr.length; i++)
            lis[i] = 1;

        for(int i = 1; i<arr.length; i++)
        {
            for(int j = 0; j<i; j++)
            {
                if(arr[i] > arr[j])
                    lis[i] = Math.max(lis[i], lis[j]+1);
            }
        }

        int max = -1;
        for(int i = 0; i<lis.length; i++)
            max = Math.max(max, lis[i]);

        return max;
    }
}
