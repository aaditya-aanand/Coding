/*
Given an array of integers, every element appears thrice except for one which occurs once.

Find that element which does not appear thrice.

Note: Your algorithm should have a linear runtime complexity.

Could you implement it without using extra memory?

Example :

Input : [1, 2, 4, 3, 3, 2, 2, 3, 1, 1]
Output : 4
*/

public class Solution 
{
    public int singleNumber(final int[] A) 
    {
        int arr[] = new int[32];
        for(int i = 0; i<A.length; i++)
        {
            String binary = Integer.toBinaryString(A[i]);
            for(int j = binary.length()-1; j>=0; j--)
                arr[32 - (binary.length() - j)] += binary.charAt(j) - '0';
        }

        int ans = 0;
        for(int i = 0; i<32; i++)
        {
            if(arr[i]%3 == 1)
                ans += (int) Math.pow(2, 31-i);
        }
          
        return ans;  
    }
}
