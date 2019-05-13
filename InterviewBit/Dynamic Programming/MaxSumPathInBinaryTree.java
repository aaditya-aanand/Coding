/*
Given a binary tree, find the maximum path sum.

The path may start and end at any node in the tree.

Example :

Given the below binary tree,

       1
      / \
     2   3
Return 6.
*/

public class Solution 
{
    public static int maxPathSumUtil(TreeNode A, int arr[])
    {
        if(A == null)
            return 0;
        
        int left = maxPathSumUtil(A.left, arr);
        int right = maxPathSumUtil(A.right, arr);
        arr[0] = Math.max(arr[0], A.val + Math.max(left, 0) + Math.max(right, 0));
        
        return A.val + Math.max(Math.max(left, 0), Math.max(right, 0));
    }
    
    public int maxPathSum(TreeNode A) 
    {
        int arr[] = new int[1];
        arr[0] = Integer.MIN_VALUE;
        maxPathSumUtil(A, arr);
        return arr[0];
    }
}
