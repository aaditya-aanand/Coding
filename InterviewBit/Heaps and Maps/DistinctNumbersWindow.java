/*
You are given an array of N integers, A1, A2 ,…, AN and an integer K. Return the of count of distinct numbers in all windows of size K.

Formally, 
return an array of size N-K+1 where i’th element in this array contains number of distinct elements in sequence Ai, Ai+1 ,…, Ai+k-1.

Note:

If K > N, return empty array.
For example,

A=[1, 2, 1, 3, 4, 3] and K = 3

All windows of size K are

[1, 2, 1]
[2, 1, 3]
[1, 3, 4]
[3, 4, 3]

So, we return an array [2, 3, 3, 2].
*/

public class Solution 
{
    public int[] dNums(int[] A, int B) 
    {
        if(B > A.length)
            return new int[]{};

        int curr = 0;
        int ans[] = new int[A.length - B + 1];
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

        for(int k = 0; k<B; k++)
        {
            if(map.containsKey(A[k]))
                map.put(A[k], map.get(A[k]) + 1);

            else
            {
                curr++;
                map.put(A[k], 1);
            }
        }

        int i = 0;
        int j = B-1;

        while(j < A.length)
        {
            ans[i] = curr;
            int x = A[i++];

            j++;
            
            if(j >= A.length)
                break;

            int y = A[j];

            if(map.get(x) > 1)
                map.put(x, map.get(x) - 1);

            else
            {
                map.remove(x);
                curr--;
            }

            if(map.containsKey(y))
                map.put(y, map.get(y) + 1);

            else
            {
                map.put(y, 1);
                curr++;
            }
        }

        return ans;
    }
}
