/*
Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Your goal is to reach the last index in the minimum number of jumps.

Example :
Given array A = [2,3,1,1,4]

The minimum number of jumps to reach the last index is 2. (Jump 1 step from index 0 to 1, then 3 steps to the last index.)

If it is not possible to reach the end index, return -1.
*/

// DP TLE Solution
public class Solution 
{
    public int jump(int[] A) 
    {
        int n = A.length;
        
        int min_step[] = new int[n];
        for(int i = 0; i<n; i++)
            min_step[i] = Integer.MAX_VALUE;
        
        min_step[0] = 0;
        for(int i = 1; i<n; i++)
        {
            for(int j = i-1; j>=0; j--)
            {
                if(min_step[j] != Integer.MAX_VALUE && A[j] + j >= i)
                    min_step[i] = Math.min(min_step[i], min_step[j] + 1);
            }
        }
        
        return (min_step[n-1] == Integer.MAX_VALUE) ? -1 : min_step[n-1];
    }
}

//Greedy AC solution
public class Solution 
{
    public int jump(int[] A) 
    {
        if(A.length == 1)
            return 0;
            
        int farthest_possible_index = 0;
        int prev = 0;
        int steps = 0;
        
        int max = -1;
        while(true)
        {
            int i = prev;
            while(i <= farthest_possible_index)
            {
                max = Math.max(max, i + A[i]);
                i++;
                
                if(max >= A.length-1)
                    return steps+1;
            }
            
            if(max == prev)
                return -1;
            
            prev = farthest_possible_index + 1;
            farthest_possible_index = max;
            steps++;
        }
    }
}
