/*
N light bulbs are connected by a wire. Each bulb has a switch associated with it, 
however due to faulty wiring, a switch also changes the state of all the bulbs to the right of current bulb. 
Given an initial state of all bulbs, find the minimum number of switches you have to press to turn on all the bulbs. 
You can press the same switch multiple times.

Note : 0 represents the bulb is off and 1 represents the bulb is on.
*/

public class Solution 
{
    public int bulbs(int[] A) 
    {
        if(A.length == 0)
            return 0;
        
        int prev = A[A.length-1];
        int count = (A[0] == 0) ? 1 : 0;

        for(int i = A.length-2; i>-1; i--)
        {
            if(prev != A[i])
            {
                count++;
                prev = A[i];
            }
        }

        return count;
    }
}
