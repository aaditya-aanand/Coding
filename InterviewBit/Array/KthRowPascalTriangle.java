/*
Given an index k, return the kth row of the Pascal’s triangle.

Pascal’s triangle : To generate A[C] in row R, sum up A’[C] and A’[C-1] from previous row R - 1.

Example:

Input : k = 3

Return : [1,3,3,1]
NOTE : k is 0 based. k = 0, corresponds to the row [1]. 
NOTE : Could you optimize your algorithm to use only O(k) extra space?
*/

public class Solution 
{
    public int[] getRow(int A) 
    {
        A++;
        int pascal[] = new int[A];
        int dummy[] = new int[A];

        for(int i = 0; i<A; i++)
        {
            for(int j = 0; j<i+1; j++)
            {
                if(i%2 == 0)
                {
                    if(j == 0 || j == i)
                        pascal[j] = 1;

                    else
                        pascal[j] = dummy[j] + dummy[j-1];
                }

                else
                {
                    if(j == 0 || j == i)
                        dummy[j] = 1;

                    else
                        dummy[j] = pascal[j] + pascal[j-1];
                }
                
            }
        }

        return (A%2 == 0) ? dummy : pascal;

    }
}
