/*
Given a binary search tree, write a function to find the kth smallest element in the tree.

Example :

Input : 
  2
 / \
1   3

and k = 2

Return : 2

As 2 is the second smallest element in the tree.
NOTE : You may assume 1 <= k <= Total number of nodes in BST 
*/

public class Solution 
{   
    public static void inorderBST(TreeNode A, ArrayList<Integer> ans)
    {
        if(A == null)
            return;

        inorderBST(A.left, ans);
        ans.add(A.val);
        inorderBST(A.right, ans);
    }

    public int kthsmallest(TreeNode A, int B) 
    {
        ArrayList<Integer> ans = new ArrayList<Integer>();
        inorderBST(A, ans);

        return ans.get(B-1);
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
