/*
Given an unsorted array, find the maximum difference between the successive elements in its sorted form.

Try to solve it in linear time/space.

Example :

Input : [1, 10, 5]
Output : 5 
Return 0 if the array contains less than 2 elements.

You may assume that all the elements in the array are non-negative integers and fit in the 32-bit signed integer range.
You may also assume that the difference will not overflow.
*/

public class Solution 
{
    public int maximumGap(final int[] A) 
    {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        
        for(int i = 0; i<A.length; i++)
        {
            min = Math.min(min, A[i]);
            max = Math.max(max, A[i]);
        }
        
        if(A.length < 2 || min == max) return 0;
        
        double gap = 1.0*(max - min)/(A.length - 1);
        
        int bucket[][] = new int[A.length-1][2];
        boolean visited[] = new boolean[A.length-1];
        
        for(int i = 0; i<A.length; i++)
        {
            int index = (int) Math.min((A[i] - min)/gap, A.length-2);
            
            bucket[index][0] = (!visited[index]) ? A[i] : Math.min(bucket[index][0], A[i]);
            bucket[index][1] = (!visited[index]) ? A[i] : Math.max(bucket[index][1], A[i]);
            
            visited[index] = true;
        }
        
        int maxgap = Integer.MIN_VALUE;
        int prev = -1;
        
        for(int i = 0; i<bucket.length; i++)
        {
            if(visited[i] && prev == -1)
                prev = bucket[i][1];
            
            else if(visited[i] && prev != -1)
            {
                maxgap = Math.max(maxgap, bucket[i][0] - prev);
                prev = bucket[i][1];
            }

        }
        
        return Math.max(maxgap, bucket[A.length-2][1] - bucket[A.length-2][0]);
    }   
}
