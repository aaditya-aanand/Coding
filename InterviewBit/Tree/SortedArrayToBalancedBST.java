/*
Given an array where elements are sorted in ascending order, convert it to a height balanced BST.

 Balanced tree : a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1. 
Example :


Given A : [1, 2, 3]
A height balanced BST  : 

      2
    /   \
   1     3
*/

public class Solution 
{
    public static TreeNode sortedArrayToBSTUtil(List<Integer> a, int start, int end)
    {
        if(start > end)
            return null;

        int mid = (start + end)/2;
        TreeNode root = new TreeNode(a.get(mid));

        root.left = sortedArrayToBSTUtil(a, start, mid-1);
        root.right = sortedArrayToBSTUtil(a, mid+1, end);

        return root;
    }

    public TreeNode sortedArrayToBST(final List<Integer> a) 
    {
        return sortedArrayToBSTUtil(a, 0, a.size()-1);
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
