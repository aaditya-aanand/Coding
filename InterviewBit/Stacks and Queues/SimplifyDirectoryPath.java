/*
Given an absolute path for a file (Unix-style), simplify it.
*/

public class Solution 
{
    public String simplifyPath(String A) 
    {
        Deque<String> stack = new LinkedList<String>();
        String arr[] = A.split("/");
        int len = arr.length;

        for(int i = 0; i<len; i++)
        {
            if(arr[i].equals("..") && !stack.isEmpty())
                stack.pollLast();

            else if(!arr[i].equals("") && !arr[i].equals(".") && !arr[i].equals(".."))
                stack.addLast(arr[i]);
        }

        StringBuilder ans = new StringBuilder();
        if(stack.isEmpty())
            ans.append("/");
        
        while(!stack.isEmpty())
        {
            ans.append("/");
            ans.append(stack.pollFirst());
        }
        
        return ans.toString();
    }
}
