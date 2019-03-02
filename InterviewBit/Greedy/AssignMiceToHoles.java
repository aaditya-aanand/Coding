/*
There are N Mice and N holes are placed in a straight line. 
Each hole can accomodate only 1 mouse. 
A mouse can stay at his position, move one step right from x to x + 1, or move one step left from x to x − 1.
Any of these moves consumes 1 minute.
Assign mice to holes so that the time when the last mouse gets inside a hole is minimized.
*/

public class Solution 
{
    public int mice(int[] A, int[] B) 
    {
        Arrays.sort(A);
        Arrays.sort(B);

        int max = -1;
        for(int i = 0; i<A.length; i++)
            max = Math.max(max, Math.abs(A[i]-B[i]));

        return max;
    }
}
