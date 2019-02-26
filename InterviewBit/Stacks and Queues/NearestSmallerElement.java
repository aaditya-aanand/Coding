/*
Given an array, find the nearest smaller element G[i] for every element A[i] in the array,
such that the element has an index smaller than i. Elements for which no smaller element exist, consider next smaller element as -1.
*/


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
