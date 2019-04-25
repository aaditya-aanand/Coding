/*
Given an array A of integers, find the maximum of j - i subjected to the constraint of A[i] <= A[j].

If there is no solution possible, return -1.

Example :

A : [3 5 4 2]

Output : 2 
for the pair (3, 4)
*/

class Point
{
    int a;
    int b;
    
    public Point(int a, int b)
    {
        this.a = a;
        this.b = b;
    }
}

class sortByPoint implements Comparator<Point>
{
    public int compare(Point a, Point b)
    {
        return a.a - b.a;
    }
}

public class Solution {
    
    public int maximumGap(final int[] A) 
    {
        int n = A.length;
        if(n == 0 || n == 1) return n-1;
        
        Point arr[] = new Point[n];
        
        for(int i = 0; i<n; i++)
            arr[i] = new Point(A[i], i);
        
        Arrays.sort(arr, new sortByPoint());
        
        int max_index[] = new int[n];
        max_index[n-1] = arr[n-1].b;
        
        for(int i = n-2; i>=0; i--)
            max_index[i] = Math.max(arr[i].b, max_index[i+1]);
        
        int maxGap = Integer.MIN_VALUE;
        
        for(int i = 0; i<n; i++)
            maxGap = Math.max(maxGap, max_index[i] - arr[i].b);
        
        return maxGap;
    }
}
