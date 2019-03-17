/*
Given a sorted linked list, delete all duplicates such that each element appear only once.

For example,
Given 1->1->2, return 1->2.
Given 1->1->2->3->3, return 1->2->3.
*/

public class Solution 
{
    public ListNode deleteDuplicates(ListNode A) 
    {
        ListNode head = A;
        ListNode prev = (A.next != null) ? A : null;
        A = A.next;
            
        while(A != null)
        {
            if(A.val == prev.val)
            {
                prev.next = A.next;
                A = prev.next;
            }

            else
            {
                prev = A;
                A = A.next;
            }
        }

        return head;
    }
}
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
