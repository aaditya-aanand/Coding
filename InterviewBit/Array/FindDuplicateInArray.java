/*
Given a read only array of n + 1 integers between 1 and n,
find one number that repeats in linear time using less than O(n) space and traversing the stream sequentially O(1) times.

Sample Input:

[3 4 1 4 1]
Sample Output:

1
If there are multiple possible answers ( like in the sample case above ), output any one.

If there is no duplicate, output -1
*/

public class Solution 
{
    public int repeatedNumber(final List<Integer> a) 
    {
        int n = a.size()-1;
        int sq = (int) Math.sqrt(n);
        int buckets[] = new int[(int) Math.ceil(1.0*n/sq)];

        for(int i = 0; i<a.size(); i++)
        {
            if(a.get(i) > n-sq)
                buckets[buckets.length-1]++;
                
            else
                buckets[(int) Math.ceil(1.0*a.get(i)/sq) - 1]++;
        }
            
        
        int buck = -1;
        for(int i = 0; i<buckets.length; i++)
        {
            if(buckets[i] > sq)
            {
                buck = i;
                break;
            }
        }

        HashSet<Integer> set = new HashSet<Integer>();
        for(int i = 0; i<a.size(); i++)
        {
            int x = a.get(i);
            if(x > buck*sq && x <= (buck+1)*sq)
            {
                if(set.contains(x))
                    return x;

                else
                    set.add(x);
            }
        }

        return -1;
    }
}
