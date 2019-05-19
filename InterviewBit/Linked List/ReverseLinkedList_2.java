/*
Reverse a linked list from position m to n. Do it in-place and in one-pass.

For example:
Given 1->2->3->4->5->NULL, m = 2 and n = 4,

return 1->4->3->2->5->NULL.

 Note:
Given m, n satisfy the following condition:
1 ≤ m ≤ n ≤ length of list. Note 2:
Usually the version often seen in the interviews is reversing the whole linked list 
which is obviously an easier version of this question. 
*/

public class Solution 
{
    public ListNode reverseBetween(ListNode A, int B, int C) 
    {
        ListNode dummy = new ListNode(0);
        ListNode head = dummy;
        dummy.next = A;
        int cmb = C-B;
        
        while(B > 1)
        {
            dummy = dummy.next;
            B--;
        }
        
        ListNode prev = dummy;
        dummy = dummy.next;
        ListNode curr = dummy;
        ListNode curr_next = dummy.next;
        
        while(cmb > 0)
        {
            ListNode temp = curr_next.next;
            curr_next.next = curr;
            curr = curr_next;
            curr_next = temp;
            cmb--;
        }
        
        dummy.next = curr_next;
        prev.next = curr;
        
        return head.next;
    }
}
