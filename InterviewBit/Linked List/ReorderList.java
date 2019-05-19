/*
Given a singly linked list

    L: L0 → L1 → … → Ln-1 → Ln,
reorder it to:

    L0 → Ln → L1 → Ln-1 → L2 → Ln-2 → …
You must do this in-place without altering the nodes’ values.

For example,
Given {1,2,3,4}, reorder it to {1,4,2,3}.
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
    
    public ListNode reorderList(ListNode A) 
    {
        int size = 0;
        ListNode temp = A;
        
        while(temp != null)
        {
            size++;
            temp = temp.next;
        }
        
        if(size < 3)
            return A;
        
        else
        {
            int start = (size+1)/2;
            temp = A;
            
            while(start > 1)
            {
                temp = temp.next;
                start--;
            }
            
            ListNode B = temp.next;
            temp.next = null;
            
            ListNode rev = reverseList(B);
            ListNode curr_A = A;
            ListNode curr_rev = rev;
            boolean flag = true;
            
            while(curr_A != null && curr_rev != null)
            {
                if(flag)
                {
                    ListNode t = curr_A.next;
                    curr_A.next = curr_rev;
                    curr_A = t;
                    flag = false;
                }
                
                else
                {
                    ListNode t = curr_rev.next;
                    curr_rev.next = curr_A;
                    curr_rev = t;
                    flag = true;
                }
            }
            
            return A;
        }
    }
}
