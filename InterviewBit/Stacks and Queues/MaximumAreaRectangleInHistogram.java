public class Solution 
{
    public int largestRectangleArea(int[] A) 
    {
        int len = A.length;
        int max = -1;
        
        Stack<Integer> stack = new Stack<Integer>();
        int left[] = new int[len];
        
        for(int i = 0; i<len; i++)
        {
            while(!stack.isEmpty())
            {
                if(A[stack.peek()] >= A[i])
                    stack.pop();
                    
                else
                    break;
            }
            
            left[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }
        
        stack.clear();
        int right[] = new int[len];
        
        for(int i = 0; i<len; i++)
        {
            while(!stack.isEmpty())
            {
                if(A[stack.peek()] >= A[len-1-i])
                    stack.pop();
                    
                else
                    break;
            }
            
            right[len-1-i] = stack.isEmpty() ? len : stack.peek();
            stack.push(len-1-i);
        }
        
        for(int i = 0; i<len; i++)
            max = Math.max(max, A[i]*(right[i]-left[i]-1));
            
        return max;
    }
}
