/*
Given a BST node, return the node which has value just greater than the given node.

Example:

Given the tree

               100
              /   \
            98    102
           /  \
         96    99
          \
           97
Given 97, you should return the node corresponding to 98 as thats the value just greater than 97 in the tree.
If there are no successor in the tree ( the value is the largest in the tree, return NULL).

Using recursion is not allowed.

Assume that the value is always present in the tree.
*/

public class Solution 
{
    public TreeNode getSuccessor(TreeNode a, int b) 
    {
        TreeNode ans = null;
        int min = Integer.MAX_VALUE;
        while(a != null)
        {
            if(a.val > b)
            {
                if(a.val < min)
                {
                    ans = a;
                    min = a.val;
                }

                a = a.left;
            }

            else
                a = a.right;
        }

        return ans;
    }
}

/**
 * Definition for binary tree
 * class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
