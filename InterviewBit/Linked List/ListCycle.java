/*
Given a linked list, return the node where the cycle begins. If there is no cycle, return null.

Try solving it using constant additional space.

Example :

Input : 

                  ______
                 |     |
                 \/    |
        1 -> 2 -> 3 -> 4

Return the node corresponding to node 3. 
*/

class ListNode 
{
	public int val;
	public ListNode next;
	ListNode(int x) { val = x; next = null; }
}

//Using additional space, namely set
public class Solution 
{
	public ListNode detectCycle(ListNode a) 
	{
		HashSet<ListNode> set = new HashSet<ListNode>();
		while(a != null)
		{
			if (set.contains(a)) {
				return a;
			}
			
			else {
				set.add(a);
				a = a.next;
			}
		}
		
		return null;
	}
}

//Using constant space, namely fast and slow pointer method
public class Solution 
{
	public ListNode detectCycle(ListNode a) 
	{
		ListNode temp = a;
		
		if(a == null)
			return a;
		
		ListNode slow = a;
		ListNode fast = (a.next == null) ? a : a.next;
		
		while(slow != null && fast != null && fast.next != null)
		{
			if(slow == fast)
			{
				int count = 1;
				slow = slow.next;
				fast = fast.next.next;
				
				while(slow != fast)
				{
					count++;
					slow = slow.next;
					fast = fast.next.next;
				}
				
				slow = temp;
				fast = temp;
				
				while(count != 0)
				{
					fast = fast.next;
					count--;
				}
				
				while(slow != fast)
				{
					slow = slow.next;
					fast = fast.next;
				}
				
				return slow;
			}
			
			else 
			{
				slow = slow.next;
				fast = fast.next.next;
			}
		}
		
		return null;
	}
}
