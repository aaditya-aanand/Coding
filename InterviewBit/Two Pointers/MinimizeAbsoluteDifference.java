/*
Given three sorted arrays A, B and Cof not necessarily same sizes.

Calculate the minimum absolute difference between the maximum and minimum number from the triplet a, b, c 
such that a, b, c belongs arrays A, B, C respectively.
i.e. minimize | max(a,b,c) - min(a,b,c) |.

Example :

Input:

A : [ 1, 4, 5, 8, 10 ]
B : [ 6, 9, 15 ]
C : [ 2, 3, 6, 6 ]
Output:

1
Explanation: We get the minimum difference for a=5, b=6, c=6 as | max(a,b,c) - min(a,b,c) | = |6-5| = 1.
*/

public class Solution 
{
    public int solve(int[] A, int[] B, int[] C) 
    {
        int i = 0;
        int j = 0; 
        int k = 0;
        int min = Integer.MAX_VALUE;

        while(i < A.length && j < B.length && k < C.length)
        {
            int a = Math.max(Math.max(A[i], B[j]), C[k]);
            int b = Math.min(Math.min(A[i], B[j]), C[k]);
            min = Math.min(min, Math.abs(a-b));
            int temp_min = Math.min(Math.min(A[i], B[j]), C[k]);

            if(A[i] == temp_min)
                i++;

            else if(B[j] == temp_min)
                j++;

            else
                k++;
        }

        return min;
    }
}
