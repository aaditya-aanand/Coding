/*
Given a singly linked list and an integer K, reverses the nodes of the

list K at a time and returns modified linked list.

NOTE : The length of the list is divisible by K 
Example :

Given linked list 1 -> 2 -> 3 -> 4 -> 5 -> 6 and K=2,

You should return 2 -> 1 -> 4 -> 3 -> 6 -> 5

Try to solve the problem using constant extra space.
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
    
    public ListNode reverseList(ListNode A, int B) 
    {
        int size = 0;
        ListNode temp = A;
        
        while(temp != null)
        {
            size++;
            temp = temp.next;
        }
        
        int start = 1;
        ListNode root = A;
        
        while(start < size)
        {
            int end = start + B - 1;
            root = reverseBetween(root, start, end);
            start += B;
        }
        
        return root;
    }
}
