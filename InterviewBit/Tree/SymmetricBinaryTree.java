/*
Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

Example :

    1
   / \
  2   2
 / \ / \
3  4 4  3
The above binary tree is symmetric. 
But the following is not:

    1
   / \
  2   2
   \   \
   3    3
Return 0 / 1 ( 0 for false, 1 for true ) for this problem
*/

public class Solution 
{
    public boolean isSymmetricUtil(TreeNode A, TreeNode B)
    {
        if(A == null && B == null)
            return true;

        if(A == null && B != null)
            return false;

        if(A != null && B == null)
            return false;

        if(A.val != B.val)
            return false;

        return isSymmetricUtil(A.left, B.right) && isSymmetricUtil(A.right, B.left);
    }

    public int isSymmetric(TreeNode A) 
    {
        if(A == null)
            return 1;

        return isSymmetricUtil(A.left, A.right) ? 1 : 0;
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
