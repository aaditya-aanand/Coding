public class Solution {
    public int[] prevSmaller(int[] A) {
        int len = A.length;
        int arr[] = new int[len];
        
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(A[0]);
        arr[0] = -1;
        
        for(int i = 1; i<len; i++)
        {
            if(stack.isEmpty())
            {
                stack.push(A[i]);
                arr[i] = -1;
            }
            
            else
            {
                while(!stack.isEmpty())
                {
                    if(A[i] <= stack.peek())
                        stack.pop();
                        
                    else
                        break;
                }
                
                arr[i] = stack.isEmpty() ? -1 : stack.peek();
                stack.push(A[i]);
            }
        }
        
        return arr;
        
    }
}
