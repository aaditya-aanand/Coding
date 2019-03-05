/*
Given an array A of integers and another non negative integer k, find if there exists 2 indices i and j such that A[i] - A[j] = k, i != j.

Example :

Input :

A : [1 5 3]
k : 2
Output :

1
as 3 - 1 = 2

Return 0 / 1 for this problem.
*/

public class Solution 
{
    public int diffPossible(final int[] A, int B) 
    {
        HashSet<Integer> set = new HashSet<Integer>();
        boolean dup = false;

        for(int i = 0; i<A.length; i++)
        {
            if(set.contains(A[i]))
                dup = true;

            else
                set.add(A[i]);
        }
            
        if(B == 0 && !dup)
            return 0;

        for(int i = 0; i<A.length; i++)
        {
            if(set.contains(A[i]-B))
                return 1;
        }

        return 0;
    }
}
