/*
Given an array of N integers, find the pair of integers in the array which have minimum XOR value. Report the minimum XOR value.

Examples : 
Input 
0 2 5 7 
Output 
2 (0 XOR 2) 
Input 
0 4 7 9 
Output 
3 (4 XOR 7)

Constraints: 
2 <= N <= 100 000 
0 <= A[i] <= 1 000 000 000
*/

public class Solution 
{
    public int findMinXor(int[] A) 
    {
        Arrays.sort(A);
        int minXor = Integer.MAX_VALUE;
        for(int i = 1; i<A.length; i++)
            minXor = Math.min(minXor, A[i]^A[i-1]);

        return minXor;
    }
}
