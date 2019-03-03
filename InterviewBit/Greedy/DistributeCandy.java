/*
There are N children standing in a line. Each child is assigned a rating value.
You are giving candies to these children subjected to the following requirements:
Each child must have at least one candy.
Children with a higher rating get more candies than their neighbors.
What is the minimum candies you must give?
*/

public class Solution 
{
    public int candy(int[] rating) 
    {
        int n = rating.length;
        int candy[] = new int[n];

        candy[0] = 1;
        for(int i = 1; i<n; i++)
        {
            if(rating[i] > rating[i-1])
                candy[i] = candy[i-1]+1;

            else
                candy[i] = 1;
        }

        for(int i = n-1; i>0; i--)
        {
            if(rating[i] < rating[i-1])
                candy[i-1] = Math.max(candy[i-1], candy[i]+1);
        }

        int ans = 0;
        for(int i = 0; i<n; i++)
            ans += candy[i];

        return ans;
    }
}
