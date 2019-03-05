/*
Implement the next permutation, which rearranges numbers into the numerically next greater permutation of numbers.

If such arrangement is not possible, it must be rearranged as the lowest possible order ie, sorted in an ascending order.

The replacement must be in-place, do not allocate extra memory.

Examples:

1,2,3 → 1,3,2

3,2,1 → 1,2,3

1,1,5 → 1,5,1

20, 50, 113 → 20, 113, 50
Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.

Warning : DO NOT USE LIBRARY FUNCTION FOR NEXT PERMUTATION.
*/

public class Solution 
{
    public void nextPermutation(ArrayList<Integer> a) 
    {
        int n = a.size();
        int pivot = -1;
        for(int i = n-2; i>=0; i--)
        {
            if(a.get(i) < a.get(i+1))
            {
                pivot = i;
                break;
            }
        }

        int secPivot = n-1;
        if(pivot != -1)
        {
            for(int i = pivot+1; i<n; i++)
            {
                if(a.get(i) <= a.get(pivot))
                {
                    secPivot = i-1;
                    break;
                }
            }
            int temp = a.get(secPivot);
            a.set(secPivot, a.get(pivot));
            a.set(pivot, temp);
        }
        
        int start = pivot+1;
        int end = n-1;
        while(start < end)
        {
            int temp = a.get(start);
            a.set(start++, a.get(end));
            a.set(end--, temp); 
        }
    }
}
