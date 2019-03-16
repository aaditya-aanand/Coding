/*
Given a binary tree, return the inorder traversal of its nodes’ values.

Example :
Given binary tree

   1
    \
     2
    /
   3
return [1,3,2].

Using recursion is not allowed.
*/

public class Solution 
{
    public int[] inorderTraversal(TreeNode A) 
    {

        Vector<Integer> ans = new Vector<Integer>();
        Stack<TreeNode> S = new Stack<TreeNode>();
        
        TreeNode curr = A;
        while(!(curr == null && S.isEmpty()))
        {
            while(curr != null)
            {
                S.push(curr);
                curr = curr.left;
            }
            
            TreeNode temp = S.pop();
            ans.add(temp.val);
            if(temp.right != null)
                curr = temp.right;
        }
        
        int arr[] = new int[ans.size()];
        for(int i = 0; i<arr.length; i++)
            arr[i] = ans.elementAt(i);
            
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
