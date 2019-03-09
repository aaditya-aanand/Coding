/*
Remove duplicates from Sorted Array
Given a sorted array, remove the duplicates in place such that each element appears only once and return the new length.

Note that even though we want you to return the new length, make sure to change the original array as well in place

Do not allocate extra space for another array, you must do this in place with constant memory.

 Example: 
Given input array A = [1,1,2],
Your function should return length = 2, and A is now [1,2]. 
*/

public class Solution 
{
    public int removeDuplicates(ArrayList<Integer> a) 
    {
        int i = 1;
        int j = 1;
        while(i < a.size())
        {

            if(a.get(i).intValue() != a.get(j-1).intValue())
                a.set(j++, a.get(i));

            i++;
        }

        while(a.size() > j)
            a.remove(a.size()-1);

        return a.size();
    }
}
