/*
You are given with an array of 1s and 0s. And you are given with an integer M, which signifies number of flips allowed.
Find the position of zeros which when flipped will produce maximum continuous series of 1s.

For this problem, return the indices of maximum continuous series of 1s in order.

Example:

Input : 
Array = {1 1 0 1 1 0 0 1 1 1 } 
M = 1

Output : 
[0, 1, 2, 3, 4] 

If there are multiple possible solutions, return the sequence which has the minimum start index.
*/

public class Solution 
{
    //Counts th enumber of zeros in the given range
    public static int numZeros(int start, int end, int arr[], int countZeros[])
    {
        int x = countZeros[end] - countZeros[start];
        return (arr[start] == 0) ? 1 + x : x;
    }

    public int[] maxone(int[] A, int B) 
    {
        int countZeros[] = new int[A.length];
        for(int i = 0; i<A.length; i++)
            countZeros[i] = (A[i] == 0) ? countZeros[Math.max(0, i-1)] + 1 : countZeros[Math.max(0, i-1)]; 
        
        int start = 0;
        int end = 0;
        int max = -1;
        int istart = -1;
        int iend = -1;

        while(start <= end && end < A.length)
        {
            boolean flag = false;
            while(end < A.length && numZeros(start, end, A, countZeros) <= B)
            {
                end++;
                flag = true;
            }
                

            end = (!flag) ? end : end-1; // Reduce end only if it has been incremented one extra time in while loop
            if(max < end-start+1 && numZeros(start, end, A, countZeros) <= B)
            {
                max = end-start+1;
                istart = start;
                iend = end;
            }
            
            if(start == end) end++;
            start++;
        }

        int ans[] = new int[iend-istart+1];
        for(int i = istart; i<=iend; i++)
            ans[i - istart] = i;

        return ans;
    }
}
