/*
You are given an array A containing N integers. 
The special product of each ith integer in this array is defined as the product of the following:<ul>

LeftSpecialValue: For an index i, it is defined as the index j such that A[j]>A[i] (i>j). 
If multiple A[j]’s are present in multiple positions, the LeftSpecialValue is the maximum value of j. 

RightSpecialValue: For an index i, it is defined as the index j such that A[j]>A[i] (j>i). 
If multiple A[j]s are present in multiple positions, the RightSpecialValue is the minimum value of j.

Write a program to find the maximum special product of any integer in the array.

Input: You will receive array of integers as argument to function.

Return: Maximum special product of any integer in the array modulo 1000000007.

Note: If j does not exist, the LeftSpecialValue and RightSpecialValue are considered to be 0.

Constraints 1 <= N <= 10^5 1 <= A[i] <= 10^9
*/

public class Solution 
{
    public int maxSpecialProduct(int[] arr) 
    {
        int n = arr.length;
        int maxLeft[] = new int[n];
        int maxRight[] = new int[n];

        Stack<Integer> stack_left_index = new Stack<Integer>();

        for(int i = 0; i<n; i++)
        {
            while(!stack_left_index.isEmpty() && arr[stack_left_index.peek()] <= arr[i])
                stack_left_index.pop();
            
            maxLeft[i] = stack_left_index.isEmpty() ? 0 : stack_left_index.peek();
            stack_left_index.push(i);
        }

        Stack<Integer> stack_right_index = new Stack<Integer>();
        
        for(int i = n-1; i>0; i--)
        {
            while(!stack_right_index.isEmpty() && arr[stack_right_index.peek()] <= arr[i])
                    stack_right_index.pop();
            
            maxRight[i] = stack_right_index.isEmpty() ? 0 : stack_right_index.peek();    
            stack_right_index.push(i);
        }
        
        long ans = 0;
        for(int i = 0; i<n; i++)
            ans = Math.max(ans, (long)maxLeft[i]*(long)maxRight[i]);

        return (int) (ans%1000000007);
    }
}
