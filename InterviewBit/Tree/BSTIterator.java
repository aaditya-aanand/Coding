/*
Implement an iterator over a binary search tree (BST). Your iterator will be initialized with the root node of a BST.

The first call to next() will return the smallest number in BST. Calling next() again will return the next smallest number in the BST, and so on.

 Note: next() and hasNext() should run in average O(1) time and uses O(h) memory, where h is the height of the tree.
Try to optimize the additional space complexity apart from the amortized time complexity. 
*/

/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class Solution 
{
    int index;
    ArrayList<Integer> sorted = new ArrayList<Integer>();

    public Solution(TreeNode root) 
    {
        inorderBST(root, this.sorted);
        this.index = 0;
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() 
    {
        return this.index < this.sorted.size();
    }

    /** @return the next smallest number */
    public int next() 
    {
        index++;
        return sorted.get(-1 + this.index);
    }

    public static void inorderBST(TreeNode root, ArrayList<Integer> sorted)
    {
        if(root == null)
            return;

        inorderBST(root.left, sorted);
        sorted.add(root.val);
        inorderBST(root.right, sorted);
    }
}

/**
 * Your Solution will be called like this:
 * Solution i = new Solution(root);
 * while (i.hasNext()) System.out.print(i.next());
 */
