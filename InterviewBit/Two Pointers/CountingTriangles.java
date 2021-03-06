/*
You are given an array of N non-negative integers, A0, A1 ,…, AN-1.
Considering each array element Ai as the edge length of some line segment, 
count the number of triangles which you can form using these array values.

Notes:

You can use any value only once while forming each triangle. Order of choosing the edge lengths doesn’t matter. Any triangle formed should have a positive area.

Return answer modulo 109 + 7.

For example,

A = [1, 1, 1, 2, 2]

Return: 4
*/

public class Solution 
{
    public int nTriang(int[] A) 
    {
        Arrays.sort(A);
        int ans = 0;

        for(int i = 0; i<A.length-2; i++)
        {
            int k = i+2;
            for(int j = i+1; j<A.length-1; j++)
            {   
                while(k < A.length && A[i] + A[j] > A[k])
                    k++;

                ans = (ans + k - 1 - j)%1000000007;
            }
        }

        return ans;
    }
}
