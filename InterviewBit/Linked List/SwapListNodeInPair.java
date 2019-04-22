/*
Given a linked list, swap every two adjacent nodes and return its head.

For example,
Given 1->2->3->4, you should return the list as 2->1->4->3.

Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed.
*/

public class Solution 
{
    public ListNode swapPairs(ListNode A) 
    {
        if(A == null || A.next == null)
            return A;
        
        ListNode root = new ListNode(0);
        ListNode prev = root;
        
        ListNode a = A;
        ListNode b = A.next;
        
        while(a != null && b != null)
        {
            ListNode temp = b.next;
            b.next = a;
            a.next = temp;
            prev.next = b;
            prev = a;
            
            a = temp;
            if(a != null)
                b = a.next;
        }
        
        return root.next;
    }
}
