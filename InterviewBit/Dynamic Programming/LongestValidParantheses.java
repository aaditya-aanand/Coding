/*
Given a string containing just the characters '(' and ')', 
find the length of the longest valid (well-formed) parentheses substring.

For "(()", the longest valid parentheses substring is "()", which has length = 2.

Another example is ")()())", where the longest valid parentheses substring is "()()", which has length = 4.
*/

public class Solution 
{
    public int longestValidParentheses(String A) 
    {
        Stack<Integer> stack = new Stack<Integer>();
        int dp[] = new int[A.length()];
        
        for(int i = 0; i<A.length(); i++)
        {
            char x = A.charAt(i);
            if(x == '(')
            {
                stack.push(i);
                dp[i] = 0;
            }
                
            else if(x == ')')
            {
                if(stack.isEmpty() || A.charAt(stack.peek()) == ')')
                    dp[i] = 0;
                
                else
                {
                    int num = (stack.peek() == 0) ? 0 : dp[stack.peek()-1]; 
                    dp[i] = num + 1 + i - stack.peek();
                    stack.pop();
                }
                    
            }
        }
        
        int dp_max = 0;
        for(int i = 0; i<dp.length; i++)
            dp_max = Math.max(dp_max, dp[i]);
        
        return dp_max;
    }
}
