/*
Given a binary tree, return the postorder traversal of its nodes’ values.

Example :

Given binary tree

   1
    \
     2
    /
   3
return [3,2,1].

Using recursion is not allowed.
*/

public class Solution 
{
    public ArrayList<Integer> postorderTraversal(TreeNode A) 
    {
        
        ArrayList<Integer> arr = new ArrayList<Integer>();
        Stack<TreeNode> S1 = new Stack<TreeNode>();
        Stack<TreeNode> S2 = new Stack<TreeNode>();
        
        S1.push(A);
        while(!S1.isEmpty())
        {
            TreeNode temp = S1.pop();
            S2.push(temp);
            
            if(temp.left != null)
                S1.push(temp.left);
                
            if(temp.right != null)
                S1.push(temp.right);

        }
        
        while(!S2.isEmpty())
            arr.add(S2.pop().val);
            
        return arr;
    }
}

/**
 * Definition for binary tree
 * class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) {
 *      val = x;
 *      left=null;
 *      right=null;
 *     }
 * }
 */
