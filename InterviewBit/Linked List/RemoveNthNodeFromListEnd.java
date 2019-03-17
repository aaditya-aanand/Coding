/*
Given a linked list, remove the nth node from the end of list and return its head.

For example,
Given linked list: 1->2->3->4->5, and n = 2.
After removing the second node from the end, the linked list becomes 1->2->3->5.

 Note:
If n is greater than the size of the list, remove the first node of the list.
Try doing it using constant additional space.
*/

public class Solution 
{
    public ListNode removeNthFromEnd(ListNode A, int B) 
    {
        int len = 0;
        ListNode temp = A;
        ListNode head = A;

        while(temp != null)
        {
            len++;
            temp = temp.next;
        }

        B = (B > len) ? len : B;
        int fromStart = len - B + 1;

        if(fromStart == 1)
            return head.next;

        while(fromStart > 2)
        {
            A = A.next;
            fromStart--;
        }

        ListNode rem = A.next;
        A.next = rem.next;
        rem.next = null;

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
