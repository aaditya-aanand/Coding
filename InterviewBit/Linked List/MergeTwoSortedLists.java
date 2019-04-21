/*
Merge two sorted linked lists and return it as a new list. 
The new list should be made by splicing together the nodes of the first two lists, and should also be sorted.

For example, given following linked lists :

  5 -> 8 -> 20 
  4 -> 11 -> 15
  
The merged list should be :

4 -> 5 -> 8 -> 11 -> 15 -> 20
*/

public class Solution 
{
    public ListNode mergeTwoLists(ListNode headA, ListNode headB) 
    {
        ListNode root;
        ListNode curr;
        

        if(headA.val < headB.val)
        {
            curr = headA;
            headA = headA.next;
        }

        else
        {
            curr = headB;
            headB = headB.next;
        }

        root = curr;

        while(headA != null && headB != null)
        {
            if(headA.val < headB.val)
            {
                curr.next = headA;
                curr = curr.next;
                headA = headA.next;
            }

            else
            {
                curr.next = headB;
                curr = curr.next;
                headB = headB.next;    
            }
        }

        curr.next = (headA == null) ? headB : headA;
        return root;
    }
}
