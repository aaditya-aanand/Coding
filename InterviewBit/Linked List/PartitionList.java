/*
Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.

You should preserve the original relative order of the nodes in each of the two partitions.

For example,
Given 1->4->3->2->5->2 and x = 3,
return 1->2->2->4->3->5.
*/

public class Solution 
{
    public ListNode partition(ListNode A, int B) 
    {
        ListNode lowerListNode = new ListNode(0);
        ListNode higherListNode = new ListNode(0);
        
        ListNode head1 = lowerListNode;
        ListNode head2 = higherListNode;
        
        while(A != null)
        {
            if(A.val < B)
            {
                head1.next = new ListNode(A.val);
                head1 = head1.next;
            }
            
            else 
            {
                head2.next = new ListNode(A.val);
                head2 = head2.next;
            }
            
            A = A.next;
        }
        
        head1.next = higherListNode.next;
        return lowerListNode.next;
    }
}
