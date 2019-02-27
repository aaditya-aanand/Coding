/*
Given an array of size n, find the majority element. The majority element is the element that appears more than floor(n/2) times.
You may assume that the array is non-empty and the majority element always exist in the array.
*/

public class Solution 
{
    public int majorityElement(final int[] A) 
    {
        Arrays.sort(A);
        return A[A.length/2];
    }
}
