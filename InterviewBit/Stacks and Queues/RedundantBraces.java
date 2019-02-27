/*
Write a program to validate if the input string has redundant braces?
0 > NO
1 > YES
*/

public class Solution 
{
    public int braces(String A) 
    {
        int len = A.length();
        Stack<Character> stack = new Stack<Character>();

        int ans = 0;
    lab:for(int i = 0; i<len; i++)
        {
            if(A.charAt(i) == ')')
            {
                int count = 0;
                while(stack.peek() != '(')
                {
                    stack.pop();
                    count++;
                }
                    
                if(count <= 1)
                {
                    ans = 1;
                    break;
                }
                
                stack.pop();
            }

            else
                stack.push(A.charAt(i));
        }

        return ans;
    }
}
