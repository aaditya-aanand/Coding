public class Solution 
{
    public int repeatedNumber(final List<Integer> a) 
    {
        int n = a.size()-1;
        int sq = (int) Math.sqrt(n);
        int buckets[] = new int[(int) Math.ceil(1.0*n/sq)]; // Number of buckets to be formed

        for(int i = 0; i<a.size(); i++)
        {
            // Incrementing when the number falls in the last bucket
            if(a.get(i) > n-sq)
                buckets[buckets.length-1]++;
            
            // Incrementing when business is as usual 
            else
                buckets[(int) Math.ceil(1.0*a.get(i)/sq) - 1]++;
        }
            
        
        int buck = -1;
        for(int i = 0; i<buckets.length; i++)
        {
            // If a bucket contains more than sq elements then it has a duplicate
            if(buckets[i] > sq)
            {
                buck = i;
                break;
            }
        }
        
        // Can use bucketing further or use a Hashset, any method will have less than O(n) space complexity 
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

        return 0;
    }
}
