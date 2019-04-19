/*
A linked list is given such that each node contains an additional random pointer which could point to any node in the list 
or NULL.

Return a deep copy of the list.

Example

Given list

   1 -> 2 -> 3
   
with random pointers going from

  1 -> 3
  2 -> 1
  3 -> 1
  
You should return a deep copy of the list. The returned answer should not contain the same node as the original list, 
but a copy of them. The pointers in the returned list should not link to any node in the original input list.
*/

public class Solution 
{
    public RandomListNode copyRandomList(RandomListNode head) 
    {
        HashMap<Integer, RandomListNode> map = new HashMap<Integer, RandomListNode>();
        RandomListNode head_copy = head;
        RandomListNode root = new RandomListNode(head.label);
        map.put(root.label, root);
        RandomListNode temp = root;
        
        
        while(head != null)
        {    
            if(head.next != null)
            {
                temp.next = new RandomListNode(head.next.label);
                map.put(temp.next.label, temp.next);
            }
                
            head = head.next;
            temp = temp.next;
        }
        
        temp = root;
        head = head_copy;
        
        while(head != null)
        {    
            if(head.random != null)
                temp.random = map.get(head.random.label);
            
            head = head.next;
            temp = temp.next;
        }
        
        return root;
    }
}
