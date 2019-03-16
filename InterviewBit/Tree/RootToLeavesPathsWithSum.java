/*
Given a binary tree and a sum, find all root-to-leaf paths where each path’s sum equals the given sum.

For example:
Given the below binary tree and sum = 22,

              5
             / \
            4   8
           /   / \
          11  13  4
         /  \    / \
        7    2  5   1
return

[
   [5,4,11,2],
   [5,8,4,5]
]
*/

public class Solution 
{
    public static boolean isLeaf(TreeNode A)
    {
        return A != null && A.left == null && A.right == null;
    }

    public static void pathSumUtil(TreeNode A, int B, HashMap<TreeNode, TreeNode> parent, ArrayList<ArrayList<Integer>> ans)
    {
        if(A == null)
            return;

        if(isLeaf(A) && A.val == B)
        {
            ArrayList<Integer> a = new ArrayList<Integer>();
            TreeNode curr = A;

            while(parent.containsKey(curr) && parent.get(curr) != null)
            {
                a.add(0, curr.val);
                curr = parent.get(curr);
            }

            a.add(0, curr.val);
            ans.add(a);
        }

        if(A.left != null)
            parent.put(A.left, A);

        if(A.right != null)
            parent.put(A.right, A);

        pathSumUtil(A.left, B-A.val, parent, ans);
        pathSumUtil(A.right, B-A.val, parent, ans);
    }

    public ArrayList<ArrayList<Integer>> pathSum(TreeNode A, int B) 
    {
        HashMap<TreeNode, TreeNode> parent = new HashMap<TreeNode, TreeNode>();
        ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();

        pathSumUtil(A, B, parent, ans);
        return ans;
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
