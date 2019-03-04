/*
Suppose a sorted array is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7  might become 4 5 6 7 0 1 2 ).

You are given a target value to search. If found in the array, return its index, otherwise return -1.

You may assume no duplicate exists in the array.

Input : [4 5 6 7 0 1 2] and target = 4
Output : 0

NOTE : Think about the case when there are duplicates. Does your current solution work? How does the time complexity change?
*/

public class Solution 
{
    public static int binarySearch(List<Integer> a, int b, int low, int high)
    {
        if(low > high)
            return -1;

        int mid = low + (high-low)/2;

        if(a.get(mid) == b)
            return mid;

        if(a.get(mid) > b)
            return binarySearch(a, b, low, mid-1);

        return binarySearch(a, b, mid+1, high);
    }

    public int search(final List<Integer> a, int b) 
    {
        int low = 0;
        int high = a.size()-1;

        if(a.get(low) < a.get(high))
            return binarySearch(a, b, low, high);

        while(low <= high)
        {
            int mid = low + (high-low)/2;
            int middle = a.get(mid);

            if(middle == b)
                return mid;

            if(middle > a.get(0))
            {
                if(middle > b)
                {
                    if(b > a.get(0))
                        high = mid-1;

                    else
                        low = mid+1;
                }

                else
                    low = mid+1;
            }

            else if(middle < a.get(a.size()-1))
            {
                if(middle > b)
                    high = mid-1;

                else
                {
                    if(b > a.get(a.size()-1))
                        high = mid-1;

                    else
                        low = mid+1;    
                }
            }
        }

        return -1;
    }
}
