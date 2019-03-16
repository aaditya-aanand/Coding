/*
Given a binary tree, return the preorder traversal of its nodes’ values.

Example :
Given binary tree

   1
    \
     2
    /
   3
return [1,2,3].

Using recursion is not allowed.
*/

public class Solution 
{
    public int[] preorderTraversal(TreeNode A) 
    {
        
        Vector<Integer> ans = new Vector<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        
        stack.push(A);
        while(!stack.isEmpty())
        {
            TreeNode temp = stack.pop();
            ans.add(temp.val);
            
            if(temp.right != null)
                stack.add(temp.right);
                
            if(temp.left != null)
                stack.add(temp.left);
        }
        
        int arr[] = new int[ans.size()];
        for(int i = 0; i<arr.length; i++)
            arr[i] = ans.elementAt(i);
            
        return arr;
        
    }
}

