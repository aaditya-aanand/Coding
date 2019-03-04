/*
You have to paint N boards of length {A0, A1, A2, A3 … AN-1}. 
There are K painters available and you are also given how much time a painter takes to paint 1 unit of board. 
You have to get this job done as soon as possible under the constraints that any painter will only paint contiguous sections of board.

2 painters cannot share a board to paint. That is to say, a board
cannot be painted partially by one painter, and partially by another.
A painter will only paint contiguous boards. Which means a
configuration where painter 1 paints board 1 and 3 but not 2 is
invalid.

Return the ans % 10000003

Input :
K : Number of painters
T : Time taken by painter to paint 1 unit of board
L : A List which will represent length of each board

Output: return minimum time to paint all boards % 10000003
Example

Input : 
  K : 2
  T : 5
  L : [1, 10]
Output : 50
*/

public class Solution 
{
    public static boolean isPossible(int arr[], long time, long painters, long T)
    {
        long temp_time = time;
        for(int i = 0; i<arr.length; i++)
        {
            if(arr[i]*T <= temp_time)
                temp_time -= arr[i]*T;

            else
            {
                temp_time = time;
                painters--;

                if(painters == 0)
                    return false;

                if(arr[i]*T <= temp_time)
                    temp_time -= arr[i]*T;

                else
                    return false;
            }
        }

        return true;
    }

    public static long floorSearch(long low, long high, int arr[], long painters, long T)
    {
        long mid; 
        while(low <= high) 
        { 
            mid = low + (high-low)/2;
    
            if(isPossible(arr, mid, painters, T)) 
                high = mid-1;

            else
                low = mid+1;
        } 
      
        return low;
    }

    public long paint(int A, int B, int[] C) 
    {
        long K = A;
        long T = B;
        long n = C.length;
        long sum = C[0];
        long maximum = C[0];

        for(int i = 1; i<n; i++)
        {
            sum = sum + C[i];
            maximum = Math.max(maximum, C[i]);
        }
            
        long low = maximum*T;
        long high = sum*T;
        
        return floorSearch(low, high, C, K, T)%10000003l;
    }
}
