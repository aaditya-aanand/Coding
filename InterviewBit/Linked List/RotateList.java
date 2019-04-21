/*
Given a list, rotate the list to the right by k places, where k is non-negative.

For example:

Given 1->2->3->4->5->NULL and k = 2,
return 4->5->1->2->3->NULL.
*/

public class Solution 
{
    public ListNode rotateRight(ListNode A, int B) 
    {
        int len = 1;
        ListNode temp = A;

        while(A.next != null)
        {
            len++;
            A = A.next;
        }

        int pos = (len - (B%len))%len;
        if(pos == 0) return temp;

        A.next = temp;
        A = temp;

        while(pos > 1)
        {
            A = A.next;
            pos--;
        }

        temp = A.next;
        A.next = null;

        return temp;
    }
}
