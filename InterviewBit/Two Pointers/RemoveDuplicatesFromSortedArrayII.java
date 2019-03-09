/*
Remove Duplicates from Sorted Array

Given a sorted array, remove the duplicates in place such that each element can appear atmost twice and return the new length.

Do not allocate extra space for another array, you must do this in place with constant memory.

Note that even though we want you to return the new length, make sure to change the original array as well in place

For example,
Given input array A = [1,1,1,2],

Your function should return length = 3, and A is now [1,1,2].
*/

public class Solution 
{
    public int removeDuplicates(ArrayList<Integer> a) 
    {
        int i = 2;
        int j = 2;
        while(i < a.size())
        {

            if(a.get(i).intValue() != a.get(j-1).intValue() || a.get(i).intValue() != a.get(j-2).intValue())
                a.set(j++, a.get(i));

            i++;
        }

        // Removing from the back ensures that remove operation is O(1)
        while(a.size() > j)
            a.remove(a.size()-1);

        return a.size();
    }
}
