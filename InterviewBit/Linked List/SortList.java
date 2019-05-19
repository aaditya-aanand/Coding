/*
Sort a linked list in O(n log n) time using constant space complexity.

Example :

Input : 1 -> 5 -> 4 -> 3

Returned list : 1 -> 3 -> 4 -> 5
*/

public class Solution 
{
    public static ListNode merge(ListNode a, ListNode b)
    {
        ListNode dummy = new ListNode(0);
        ListNode root = dummy;
        
        while(a != null && b != null)
        {
            if(a.val < b.val)
            {
                dummy.next = a;
                dummy = dummy.next;
                a = a.next;
            }
            
            else
            {
                dummy.next = b;
                dummy = dummy.next;
                b = b.next;
            }
        }
        
        if(a == null)
            dummy.next = b;
        
        else if(b == null)
            dummy.next = a;
        
        return root.next;
    }
    
    public static ListNode divideListNode(ListNode A)
    {
        int size = 0;
        ListNode temp = A;
        
        while(temp != null)
        {
            size++;
            temp = temp.next;
        }
        
        int count = size/2 - 1;
        temp = A;
        
        while(count > 0)
        {
            temp = temp.next;
            count--;
        }
        
        ListNode res = temp.next;
        temp.next = null;
        return res;
    }
    
    public static ListNode sortListUtil(ListNode a, ListNode b)
    {
        if(a == null)
            return b;
        
        if(b == null)
            return a;
        
        ListNode aa = divideListNode(a);
        ListNode bb = divideListNode(b);
        
        return merge(sortListUtil(a, aa), sortListUtil(b, bb));
    }
    
    public ListNode sortList(ListNode A) 
    {
        ListNode B = divideListNode(A);
        return sortListUtil(A, B);
    }
}
