/*
Reverse a linked list. Do it in-place and in one-pass.

For example:
Given 1->2->3->4->5->NULL,

return 5->4->3->2->1->NULL.
*/

public class Solution 
{
    public ListNode reverseList(ListNode A) 
    {
        if(A == null || A.next == null)
            return A;
        
        ListNode dummy = new ListNode(0);
        dummy.next = A;
        
        ListNode curr = A;
        ListNode curr_next = A.next;
        
        while(curr_next != null)
        {
            ListNode temp = curr_next.next;
            curr_next.next = curr;
            curr = curr_next;
            curr_next = temp;
        }
        
        dummy.next.next = null;
        return curr;
    }
}
