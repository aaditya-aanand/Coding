/*
Given an array of integers, return the highest product possible by multiplying 3 numbers from the array.
*/

public class Solution 
{
    public int maxp3(int[] A) 
    {
        int n = A.length;
        Arrays.sort(A);

        int all_pos_or_neg = A[n-1]*A[n-2]*A[n-3];
        int some_neg_some_pos = A[0]*A[1]*A[n-1];

        return Math.max(all_pos_or_neg, some_neg_some_pos);
    }
}
