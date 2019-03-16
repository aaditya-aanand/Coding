/*
Given a binary tree, determine if it is a valid binary search tree (BST).

Assume a BST is defined as follows:

The left subtree of a node contains only nodes with keys less than the node’s key.
The right subtree of a node contains only nodes with keys greater than the node’s key.
Both the left and right subtrees must also be binary search trees.
Example :

Input : 
   1
  /  \
 2    3

Output : 0 or False


Input : 
  2
 / \
1   3

Output : 1 or True 
Return 0 / 1 ( 0 for false, 1 for true ) for this problem
*/

public class Solution 
{
    public static void toArrayBSTInorder(TreeNode A, ArrayList<Integer> arr)
    {
        if(A == null)
            return;

        toArrayBSTInorder(A.left, arr);
        arr.add(A.val);
        toArrayBSTInorder(A.right, arr);
    }

    public int isValidBST(TreeNode A) 
    {
        ArrayList<Integer> arr = new ArrayList<Integer>();
        toArrayBSTInorder(A, arr);
        
        for(int i = 1; i<arr.size(); i++)
            if(arr.get(i) <= arr.get(i-1)) //Equal sign because of BST definition in question
                return 0;

        return 1;
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
