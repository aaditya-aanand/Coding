/*
Given a sorted array of integers, find the starting and ending position of a given target value.

Your algorithm’s runtime complexity must be in the order of O(log n).

If the target is not found in the array, return [-1, -1].

Example:

Given [5, 7, 7, 8, 8, 10]

and target value 8,

return [3, 4].

*/

public class Solution 
{
    public ArrayList<Integer> searchRange(final List<Integer> a, int key) 
    {
        ArrayList<Integer> ans = new ArrayList<Integer>();
        if(key < a.get(0) || key > a.get(a.size()-1))
        {
            ans.add(-1);
            ans.add(-1);
            return ans;
        }

        int low = 0;
        int high = a.size()-1;
        int mid;

        while(low <= high)
        {
            mid = low + (high-low)/2;

            if(a.get(mid) >= key)
                high = mid-1;

            else
                low = mid+1;
        }
        
        if(a.get(low) == key)
            ans.add(low);
        else
            ans.add(-1);

        low = 0;
        high = a.size()-1;
        
        while(low <= high)
        {
            mid = low + (high-low)/2;

            if(a.get(mid) > key)
                high = mid-1;

            else
                low = mid+1;
        }

        if(a.get(high) == key)
            ans.add(high);
        else
            ans.add(-1);
            
        return ans;
    }
}
