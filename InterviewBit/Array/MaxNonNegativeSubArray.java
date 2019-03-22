/*
Find out the maximum sub-array of non negative numbers from an array.
The sub-array should be continuous. 
That is, a sub-array created by choosing the second and fourth element and skipping the third element is invalid.

Maximum sub-array is defined in terms of the sum of the elements in the sub-array. 
Sub-array A is greater than sub-array B if sum(A) > sum(B).

Example:

A : [1, 2, 5, -7, 2, 3]
The two sub-arrays are [1, 2, 5] [2, 3].
The answer is [1, 2, 5] as its sum is larger than [2, 3]

NOTE: If there is a tie, then compare with segment's length and return segment which has maximum length
NOTE 2: If there is still a tie, then return the segment with minimum starting index
*/

public class Solution 
{
    public int[] maxset(int[] A) 
    {
        ArrayList<Integer> indices = new ArrayList<Integer>();

        int n = A.length;
        long sum[] = new long[n];
        boolean start = false;
        
        for(int i = 0; i<n; i++)
        {
            sum[i] = (i == 0) ? A[i] : sum[i-1] + A[i];

            if(A[i] >= 0 && !start)
            {
                indices.add(i);
                start = true;
            }

            else if(A[i] < 0 && start)
            {
                indices.add(i-1);
                start = false;
            }
        }

        if(start) indices.add(n-1);

        long max = Long.MIN_VALUE;
        int istart = 0;
        int iend = -1;

        for(int i = 0; i<indices.size(); i = i+2)
        {
            int s = indices.get(i);
            int e = indices.get(i+1);

            long sumRange = sum[e] - sum[s] + A[s];
            if(sumRange > max || ((sumRange == max) && ((e-s) > (iend-istart))))
            {
                max = sumRange;
                istart = s;
                iend = e;
            }
        }

        int ans[] = new int[iend-istart+1];
        for(int i = istart; i<=iend; i++)
            ans[i-istart] = A[i];

        return ans;
    }
}
