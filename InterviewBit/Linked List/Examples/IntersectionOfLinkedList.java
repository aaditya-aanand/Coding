/*
Write a program to find the node at which the intersection of two singly linked lists begins.

For example, the following two linked lists:


A:          a1 → a2
                   ↘
                     c1 → c2 → c3
                   ↗
B:     b1 → b2 → b3

begin to intersect at node c1.

 Notes:
If the two linked lists have no intersection at all, return null.
The linked lists must retain their original structure after the function returns.
You may assume there are no cycles anywhere in the entire linked structure.
Your code should preferably run in O(n) time and use only O(1) memory.
*/

public class Solution 
{
    public ListNode getIntersectionNode(ListNode a, ListNode b) 
    {
        int len_a = 0;
        int len_b = 0;
        
        ListNode temp = a;
        while(temp != null)
        {
            temp = temp.next;
            len_a++;
        }
        
        temp = b;
        while(temp != null)
        {
            temp = temp.next;
            len_b++;
        }
        
        ListNode larger = (len_a > len_b) ? a : b;
        ListNode smaller = (len_b < len_a) ? b : a;
        
        int len_diff = Math.abs(len_a - len_b);
        while(len_diff > 0)
        {
            larger = larger.next;
            len_diff--;
        }
        
        while(larger != null && smaller != null && !larger.equals(smaller))
        {
            larger = larger.next;
            smaller = smaller.next;
        }
        
        return larger;
    }
}
