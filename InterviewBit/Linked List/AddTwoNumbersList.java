/*
You are given two linked lists representing two non-negative numbers. 
The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8

    342 + 465 = 807
Make sure there are no trailing zeros in the output list
So, 7 -> 0 -> 8 -> 0 is not a valid response even though the value is still 807.
*/

public class Solution 
{
    public ListNode addTwoNumbers(ListNode A, ListNode B) 
    {
        ListNode root = new ListNode(0);
        ListNode ans = root;
        
        int carry = 0;
        while(A != null || B != null)
        {
            int a = (A == null) ? 0 : A.val;
            int b = (B == null) ? 0 : B.val;
            
            int num = (a + b + carry)%10;
            carry = (a + b + carry)/10;
            
            root.next = new ListNode(num);
            root = root.next;
            
            if(A != null) A = A.next;
            if(B != null) B = B.next;
        }
        
        root.next = (carry == 0) ? null : new ListNode(carry);
        return ans.next;
    }
}
