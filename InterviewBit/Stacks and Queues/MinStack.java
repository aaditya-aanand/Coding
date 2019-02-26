/*
Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
push(x) – Push element x onto stack.
pop() – Removes the element on top of the stack.
top() – Get the top element.
getMin() – Retrieve the minimum element in the stack.

Q: What should getMin() do on empty stack? 
A: In this case, return -1.

Q: What should pop do on empty stack? 
A: In this case, nothing. 

Q: What should top() do on empty stack?
A: In this case, return -1
*/

class Solution 
{
    
    Stack<Integer> stack = new Stack<Integer>();
    Stack<Integer> min = new Stack<Integer>();
    
    public void push(int x) 
    {
        if(min.isEmpty() || x <= min.peek())
            min.push(x);
            
        stack.push(x);
    }

    public void pop() 
    {
        if(!stack.isEmpty())
        {
            int x = stack.pop();
            if(min.peek() == x)
                min.pop();
        }
    }

    public int top() 
    {
        return stack.isEmpty() ? -1 : stack.peek();
    }

    public int getMin() 
    {
        return min.isEmpty() ? -1 : min.peek();
    }
}
