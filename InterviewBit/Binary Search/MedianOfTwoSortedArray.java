/*
There are two sorted arrays A and B of size m and n respectively.

Find the median of the two sorted arrays ( The median of the array formed by merging both the arrays ).

The overall run time complexity should be O(log (m+n)).

Sample Input

A : [1 4 5]
B : [2 3]

Sample Output

3
NOTE: IF the number of elements in the merged array is even, then the median is the average of n / 2 th and n/2 + 1th element.
For example, if the array is [1 2 3 4], the median is (2 + 3) / 2.0 = 2.5 
*/

public class Solution 
{
    public double findMedianSortedArrays(final List<Integer> a, final List<Integer> b) 
    {
        if(a.size() > b.size())
            return findMedianSortedArrays(b, a);
        
        double median = 0.0;
        int x = a.size();
        int y = b.size();
        
        int low = 0;
        int high = x;
        
        while(low <= high)
        {
            int px = (low + high)/2;
            int py = (x + y + 1)/2 - px;
            
            int maxLeftX = (px == 0) ? Integer.MIN_VALUE : a.get(px-1);
            int maxLeftY = (py == 0) ? Integer.MIN_VALUE : b.get(py-1);
            
            int minRightX = (px == x) ? Integer.MAX_VALUE : a.get(px);
            int minRightY = (py == y) ? Integer.MAX_VALUE : b.get(py);
            
            if(maxLeftX <= minRightY && maxLeftY <= minRightX)
            {
                median = ((x+y)%2 == 0) ? (Math.max(maxLeftX, maxLeftY) + Math.min(minRightX, minRightY))/2.0 : (double) Math.max(maxLeftX, maxLeftY);
                break;
            }
                
            else 
            {
                if(maxLeftX > minRightY)
                    high = px-1;
                
                else 
                    low = px+1;
            }
        }
        
        return median;
    }
}
