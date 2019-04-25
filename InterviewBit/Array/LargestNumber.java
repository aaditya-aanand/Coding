/*
Given a list of non negative integers, arrange them such that they form the largest number.

For example:

Given [3, 30, 34, 5, 9], the largest formed number is 9534330.

Note: The result may be very large, so you need to return a string instead of an integer.
*/

class T
{
    int t;
    public T(int t)
    {
        this.t = t;
    }
}

class sortBy implements Comparator<T>
{
    public int compare(T a, T b)
    {
        int x = (int) Math.log10(a.t);
        int y = (int) Math.log10(b.t);
        
        long ax = (long) (Math.pow(10, y+1)*a.t + b.t);
        long bx = (long) (Math.pow(10, x+1)*b.t + a.t);
        
        if(ax > bx)
            return -1;
        
        return 1;
    }
}

public class Solution 
{
    public String largestNumber(final int[] A) 
    {
        T arr[] = new T[A.length];
        for(int i = 0; i<A.length; i++)
            arr[i] = new T(A[i]);
        
        Arrays.sort(arr, new sortBy());
        if(arr[0].t == 0) return "0";
        
        StringBuilder ans = new StringBuilder();
        
        for(int i = 0; i<A.length; i++)
            ans.append(String.valueOf(arr[i].t));
        
        return ans.toString();
    }
}
