/*
Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target. 
Return the sum of the three integers.

Assume that there will only be one solution

Example: 
given array S = {-1 2 1 -4}, 
and target = 1.

The sum that is closest to the target is 2. (-1 + 2 + 1 = 2)
*/

public class Solution 
{
    public int threeSumClosest(int[] A, int B) 
    {
        Arrays.sort(A);
        int min = Integer.MAX_VALUE; // Absolute difference from target number achieved till now 
        int cs = 0; // Closest sum achieved till now

        //Fix two pointers and search for the third one
        for(int i = 0; i<A.length-2; i++)
        {
            int k = A.length-1;
            for(int j = i+1; j<A.length-1; j++)
            {
                int target = B - A[i] - A[j];
                while(k > j && A[k] > target)
                    k--;
                
                // If k is not greater than j, then there is no point
                int a = (k > j) ? Math.abs(B - (A[i] + A[j] + A[k])) : Integer.MAX_VALUE;
                // If k is the last element then k > j holds true, and 'a' must have captured the number
                int b = (k == A.length-1) ? Integer.MAX_VALUE : Math.abs(B - (A[i] + A[j] + A[k+1]));

                if(a < b && a < min)
                {
                    min = a;
                    cs = A[i] + A[j] + A[k];
                }

                else if(b < a && b < min)
                {
                    min = b;
                    cs = A[i] + A[j] + A[k+1];
                }
            }
        }

        return cs;
    }
}
