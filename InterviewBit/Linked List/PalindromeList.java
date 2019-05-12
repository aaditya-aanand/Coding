/*
Given a singly linked list, determine if its a palindrome. Return 1 or 0 denoting if its a palindrome or not, respectively.

Notes:

Expected solution is linear in time and constant in space.
For example,

List 1-->2-->1 is a palindrome.
List 1-->2-->3 is not a palindrome.
*/

public class Solution 
{
    public int lPalin(ListNode A) 
    {
        ListNode head = A;
        int size = 0;
        
        while(head != null)
        {
            size++;
            head = head.next;
        }
        
        ListNode temp = A;
        int count = size/2;
        
        while(count != 0)
        {
            temp = temp.next;
            count--;
        }
        
        ListNode curr_next = temp.next;
        while(curr_next != null)
        {
            ListNode ln = curr_next.next;
            curr_next.next = temp;
            temp = curr_next;
            curr_next = ln;
        }
        
        count = size/2;
        while(count > 0)
        {
            if(A.val != temp.val)
                return 0;
            
            else
            {
                A = A.next;
                temp = temp.next;
                count--;
            }
        }
        
        return 1;
    }
}
