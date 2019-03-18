/*
You are given a binary string(i.e. with characters 0 and 1) S consisting of characters S1, S2, …, SN. 
In a single operation, you can choose two indices L and R such that 1 ≤ L ≤ R ≤ N and flip the characters SL, SL+1, …, SR. 
By flipping, we mean change character 0 to 1 and vice-versa.

Your aim is to perform ATMOST one operation such that in final string number of 1s is maximised. 
If you don’t want to perform the operation, return an empty array. Else, return an array consisting of two elements denoting L and R. 
If there are multiple solutions, return the lexicographically smallest pair of L and R.

Notes:

Pair (a, b) is lexicographically smaller than pair (c, d) if a < c or, if a == c and b < d.
For example,

S = 010

Pair of [L, R] | Final string
_______________|_____________
[1 1]          | 110
[1 2]          | 100
[1 3]          | 101
[2 2]          | 000
[2 3]          | 001

We see that two pairs [1, 1] and [1, 3] give same number of 1s in final string. So, we return [1, 1].
Another example,

If S = 111

No operation can give us more than three 1s in final string. So, we return empty array [].
*/

public class Solution 
{
    public int[] flip(String A) 
    {
        int n = A.length();

        int zeros[] = new int[n];
        int ones[] = new int[n];
        int surplus[] = new int[n+1];

        for(int i = 0; i<n; i++)
        {
            int x = A.charAt(i) - '0';

            if(i == 0 && x == 0) 
                zeros[i]++;

            else if(i == 0 && x == 1) 
                ones[i]++;

            else if(x == 0)
            {
                zeros[i] = zeros[i-1] + 1;
                ones[i] = ones[i-1];
            }
                
            else if(x == 1)
            {
                ones[i] = ones[i-1] + 1;
                zeros[i] = zeros[i-1];
            }

            surplus[i+1] = zeros[i] - ones[i];      
        }

        int min_index[] = new int[n+1];
        int min = Integer.MAX_VALUE;
        for(int i = 0; i<n+1; i++)
        {
            if(surplus[i] < min)
            {
                min = surplus[i];
                min_index[i] = i;
            }

            else
                min_index[i] = min_index[i-1];
        }

        if(ones[n-1] == n)
            return new int[]{};

        int start = 0;
        int end = 0;
        int diff = Integer.MIN_VALUE;

        for(int i = 1; i<n+1; i++)
        {
            int x = surplus[i];
            int y = surplus[min_index[i-1]];

            if(x-y > diff)
            {
                diff = x-y;
                start = min_index[i-1] + 1;
                end = i;
            }
        }

        return new int[]{start, end};
    }
}
