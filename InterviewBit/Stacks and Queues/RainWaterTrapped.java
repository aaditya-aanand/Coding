/*
Given n non-negative integers representing an elevation map where the width of each bar is 1,
compute how much water it is able to trap after raining.
*/

/* Non stack based approach */

public class Solution 
{
    public int trap(final int[] A) 
    {
        int len = A.length;
        int left_max[] = new int[len];
        int right_max[] = new int[len];
        
        int l_max = -1;
        int r_max = -1;
        for(int i = 0; i<len; i++)
        {
            l_max = Math.max(l_max, A[i]);
            r_max = Math.max(r_max, A[len-1-i]);
            left_max[i] = l_max;
            right_max[len-1-i] = r_max;
        }
        
        int ans = 0;
        for(int i = 0; i<len; i++)
            ans += (Math.min(left_max[i], right_max[i])-A[i]);

        return ans;
    }
}

/* Stack based approach */

public class Solution 
{
    public int trap(final int[] A) 
    {
        int len = A.length;
        Stack<Integer> stack = new Stack<Integer>();
        int ans = 0;
        for(int i = 0; i<len; i++)
        {
            while(!stack.isEmpty() && A[i] >= A[stack.peek()])
            {
                int x = stack.pop();
                ans = stack.isEmpty() ? ans : ans + (Math.min(A[i], A[stack.peek()]) - A[x])*(i - stack.peek() - 1);
            }
            stack.push(i);
        }

        return ans;
    }
}

