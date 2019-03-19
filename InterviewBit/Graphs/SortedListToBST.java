/*
Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.

 A height balanced BST : a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1. 
Example :


Given A : 1 -> 2 -> 3
A height balanced BST  :

      2
    /   \
   1     3
*/

public class Solution 
{
    public static TreeNode sortedArrayToBSTUtil(ArrayList<Integer> a, int start, int end)
    {
        if(start > end)
            return null;

        int mid = (start + end)/2;
        TreeNode root = new TreeNode(a.get(mid));

        root.left = sortedArrayToBSTUtil(a, start, mid-1);
        root.right = sortedArrayToBSTUtil(a, mid+1, end);

        return root;
    }

    public TreeNode sortedListToBST(ListNode a) 
    {
        ArrayList<Integer> arr = new ArrayList<Integer>();
        while(a != null)
        {
            arr.add(a.val);
            a = a.next;
        }

        return sortedArrayToBSTUtil(arr, 0, arr.size()-1);
    }
}
