/*
Given an integer array, 
find if an integer p exists in the array such that the number of integers greater than p in the array equals to p
If such an integer is found return 1 else return -1.
*/

public class Solution 
{
    public int solve(int[] A) 
    {
        Arrays.sort(A);
        int n = A.length;

        for(int i = 0; i<n; i++)
        {
            if(A[i] == n-1-i && i+1 < n && A[i] != A[i+1])
                return 1;
        }

        return A[n-1] == 0 ? 1 : -1;
    }
}
