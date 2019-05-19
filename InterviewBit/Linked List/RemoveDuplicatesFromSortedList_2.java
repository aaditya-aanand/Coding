/*
Given a sorted linked list, delete all nodes that have duplicate numbers, 
leaving only distinct numbers from the original list.

For example,
Given 1->2->3->3->4->4->5, return 1->2->5.
Given 1->1->1->2->3, return 2->3.
 */
 
public class Solution 
{
    public ListNode deleteDuplicates(ListNode A) 
    {
        ListNode last = new ListNode(Integer.MIN_VALUE);
        last.next = A;
        ListNode root = last;
        
        while(A != null && A.next != null)
        {
            if(A.val == A.next.val)
            {
                ListNode temp = A;
                while(temp != null && temp.val == A.val)
                    temp = temp.next;
                
                A = temp;
                last.next = temp;
                
                if(A != null && A.next != null && A.val != A.next.val)
                    last = A; 
            }
            
            else
            {
                if(last.val != A.val)
                {
                    last.next = A;
                    last = A;
                }
                
                A = A.next;
            }
        }
        
        return root.next;
    }
}
