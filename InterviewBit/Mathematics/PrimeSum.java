/*
Given an even number ( greater than 2 ), return two prime numbers whose sum will be equal to given number.

NOTE A solution will always exist. read Goldbach’s conjecture

Example:


Input : 4
Output: 2 + 2 = 4

If there are more than one solutions possible, return the lexicographically smaller solution.

If [a, b] is one solution with a <= b,
and [c,d] is another solution with c <= d, then

[a, b] < [c, d] 

If a < c OR a==c AND b < d. 
*/

public class Solution 
{
    public int[] primesum(int A) 
    {
        boolean isComposite[] = new boolean[A+1];
        for(int i = 2; i*i < isComposite.length; i++)
        {
            if(!isComposite[i])
            {
                for(int j = i*i; j<isComposite.length; j = j+i)
                    isComposite[j] = true;
            }
            
        }

        HashSet<Integer> primes = new HashSet<Integer>();
        ArrayList<Integer> checks = new ArrayList<Integer>();

        for(int i = 2; i<=A; i++)
        {
            if(!isComposite[i])
            {
                primes.add(i);
                checks.add(i);
            }
                
        }

        for(int x : checks)
        {
            if(primes.contains(A-x))
                return new int[]{x, A-x};
        }

        return new int[]{0, 0};
    }
}
