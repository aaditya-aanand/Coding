/*
Given a non-negative number represented as an array of digits,

add 1 to the number ( increment the number represented by the digits ).

The digits are stored such that the most significant digit is at the head of the list.

Example:

If the vector has [1, 2, 3]

the returned vector should be [1, 2, 4]

as 123 + 1 = 124.

 NOTE: Certain things are intentionally left unclear in this question which you should practice asking the interviewer.
For example, for this problem, following are some good questions to ask :
Q : Can the input have 0’s before the most significant digit. Or in other words, is 0 1 2 3 a valid input?
A : For the purpose of this question, YES
Q : Can the output have 0’s before the most significant digit? Or in other words, is 0 1 2 4 a valid output?
A : For the purpose of this question, NO. Even if the input has zeroes before the most significant digit.
*/

public class Solution 
{
    public int[] plusOne(int[] A) 
    {
        int start = -1;
        for(int i = 0; i<A.length; i++)
        {
            if(A[i] != 0)
            {
                start = i;
                break;
            }
        }

        if(start == -1)
            return new int[]{1}; 

        int carry = 1;
        for(int i = A.length-1; i>=start; i--)
        {
            int temp = carry;
            carry = (A[i] + temp)/10;
            A[i] = (A[i] + temp)%10;
        }

        int ans[] = (carry == 0) ? new int[A.length-start] : new int[A.length-start+1];
        
        if(carry == 0)
        {
            for(int i = 0; i<ans.length; i++)
                ans[i] = A[start+i];
        }

        else
        {
            ans[0] = carry;
            for(int i = 1; i<ans.length; i++)
                ans[i] = A[start+i-1];
        }
           
        return ans; 
    }
}
