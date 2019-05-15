/*
Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Determine if you are able to reach the last index.

For example:
A = [2,3,1,1,4], return 1 ( true ).

A = [3,2,1,0,4], return 0 ( false ).

Return 0/1 for this problem
*/

public class Solution 
{
    public int canJump(int[] A) 
    {
        int farthest_possible_index = 0;
        for(int i = 0; i<A.length; i++)
        {
            if(i <= farthest_possible_index)
                farthest_possible_index = Math.max(farthest_possible_index, i + A[i]);
            
            else
                break;
        }
        
        return (farthest_possible_index >= A.length-1) ? 1 : 0;
    }
}
