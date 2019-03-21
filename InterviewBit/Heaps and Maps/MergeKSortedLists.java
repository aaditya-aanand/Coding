/*
Merge k sorted linked lists and return it as one sorted list.

Example :

1 -> 10 -> 20
4 -> 11 -> 13
3 -> 8 -> 9
will result in

1 -> 3 -> 4 -> 8 -> 9 -> 10 -> 11 -> 13 -> 20
*/

public class Solution 
{
    public ListNode mergeKLists(ArrayList<ListNode> a) 
    {
        TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>();

        for(int i = 0; i<a.size(); i++)
        {
            ListNode ln = a.get(i);
            while(ln != null)
            {
                if(map.containsKey(ln.val))
                    map.put(ln.val, map.get(ln.val) + 1);

                else
                    map.put(ln.val, 1);

                ln = ln.next;
            }
        }

        ListNode root = new ListNode(0);
        ListNode head = root;

        for(Map.Entry<Integer, Integer> entry : map.entrySet())
        {
            int x = entry.getKey();
            int y = map.get(x);
            while(y > 0)
            {
                root.next = new ListNode(x);
                root = root.next;
                y--;
            }
        }

        return head.next;
    }
}

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
