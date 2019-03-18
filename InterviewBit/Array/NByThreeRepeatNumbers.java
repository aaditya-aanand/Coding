/*
You’re given a read only array of n integers. 
Find out if any integer occurs more than n/3 times in the array in linear time and constant additional space.

If so, return the integer. If not, return -1.

If there are multiple solutions, return any one.

Example :

Input : [1 2 3 1 1]
Output : 1 
1 occurs 3 times which is more than 5/3 times.
*/

public class Solution 
{
    public int repeatedNumber(final List<Integer> arr) 
    {
        int n = arr.size();

        if(n == 0)
            return -1;

        if(n == 1)
            return arr.get(0);

        int a = arr.get(0);
        int ac = 1;

        int b = Integer.MIN_VALUE;
        int bc = 0;

        for(int i = 1; i<arr.size(); i++)
        {
            if(arr.get(i) == a && ac != 0)
                ac++;

            else if(arr.get(i) == b && bc != 0)
                bc++;

            else if(ac == 0)
            {
                a = arr.get(i);
                ac = 1;
            }

            else if(bc == 0)
            {
                b = arr.get(i);
                bc = 1;
            }

            else
            {
                ac--;
                bc--;
            }
        }

        int count_a = 0;
        int count_b = 0;
        
        for(int i = 0; i<n; i++)
        {
            count_a = (arr.get(i) == a) ? count_a+1 : count_a;
            count_b = (arr.get(i) == b) ? count_b+1 : count_b;
        }
            
        if(count_a > n/3)
            return a;

        if(count_b > n/3)
            return b;

        return -1;
    }
}
