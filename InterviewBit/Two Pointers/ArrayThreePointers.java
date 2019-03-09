/*
You are given 3 arrays A, B and C. All 3 of the arrays are sorted.

Find i, j, k such that :
max(abs(A[i] - B[j]), abs(B[j] - C[k]), abs(C[k] - A[i])) is minimized.
Return the minimum max(abs(A[i] - B[j]), abs(B[j] - C[k]), abs(C[k] - A[i]))

**abs(x) is absolute value of x and is implemented in the following manner : **

      if (x < 0) return -x;
      else return x;
Example :

Input : 
        A : [1, 4, 10]
        B : [2, 15, 20]
        C : [10, 12]

Output : 5 
         With 10 from A, 15 from B and 10 from C. 
*/

public class Solution 
{
    public int minimize(final int[] A, final int[] B, final int[] C) 
    {
        int i = 0;
        int j = 0; 
        int k = 0;
        int min = Integer.MAX_VALUE;

        while(i < A.length && j < B.length && k < C.length)
        {
            min = Math.min(min, Math.max(Math.max(Math.abs(A[i]-B[j]), Math.abs(B[j]-C[k])), Math.abs(C[k]-A[i])));
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
