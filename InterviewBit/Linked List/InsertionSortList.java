/*
Sort a linked list using insertion sort.

We have explained Insertion Sort at Slide 7 of Arrays

Insertion Sort Wiki has some details on Insertion Sort as well.

Example :

Input : 1 -> 3 -> 2

Return 1 -> 2 -> 3
*/

public class Solution 
{
    public ListNode insertionSortList(ListNode A) 
    {
        ListNode root = new ListNode(Integer.MIN_VALUE);
        root.next = A;
        
        ListNode curr = root.next;
        ListNode curr_sorted = root;
        int curr_sorted_size = 0;
        
        while(curr != null)
        {
            ListNode temp_prev = root;
            ListNode temp = root.next;
            int count = 0;
            
            while(count < curr_sorted_size && temp.val < curr.val)
            {
                temp_prev = temp_prev.next;
                temp = temp.next;
                count++;
            }
            
            if(count == curr_sorted_size)
            {
                curr_sorted = curr;
                curr = curr.next;
                curr_sorted_size++;
                continue;
            }
            
            curr_sorted.next = curr.next;
            curr.next = temp;
            temp_prev.next = curr;
            curr = curr_sorted.next;
            curr_sorted_size++;
        }
        
        return root.next;
    }
}
