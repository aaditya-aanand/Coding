/*
Evaluate the value of an arithmetic expression in Reverse Polish Notation.
Valid operators are +, -, *, /. Each operand may be an integer or another expression. 
*/

public class Solution {
    public int evalRPN(String[] A) 
    {
        Stack<Integer> stack = new Stack<Integer>();
        HashSet<Character> set = new HashSet<Character>();
        set.add('-'); set.add('+'); set.add('*'); set.add('/');
        
        int len = A.length;
        for(int i = 0; i<len; i++)
        {
            char x = A[i].charAt(0);
            if(A[i].length() == 1 && set.contains(x))
            {
                if(x == '-')
                stack.push(-1*stack.pop()+stack.pop());
                
                else if(x == '+')
                stack.push(stack.pop()+stack.pop());
                
                else if(x == '*')
                stack.push(stack.pop()*stack.pop());
                
                else
                {
                    int temp = stack.pop();
                    stack.push(stack.pop()/temp);
                }
            }

            else
                stack.push(Integer.valueOf(A[i]));
        }
        
        return stack.pop();
    }
}
