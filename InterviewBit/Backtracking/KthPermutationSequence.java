/*
The set [1,2,3,…,n] contains a total of n! unique permutations.

By listing and labeling all of the permutations in order,
We get the following sequence (ie, for n = 3 ) :

1. "123"
2. "132"
3. "213"
4. "231"
5. "312"
6. "321"
Given n and k, return the kth permutation sequence.

For example, given n = 3, k = 4, ans = "231"

Good questions to ask the interviewer :

What if n is greater than 10. How should multiple digit numbers be represented in string?
 In this case, just concatenate the number to the answer.
so if n = 11, k = 1, ans = "1234567891011" 

Whats the maximum value of n and k?
 In this case, k will be a positive integer thats less than INT_MAX.
n is reasonable enough to make sure the answer does not bloat up a lot.
*/

public class Solution 
{
    public static int factorial(int n)
    {
        return (n == 0) ? 1 : n*(factorial(n-1));
    }
 
    public String getPermutation(int A, int B) 
    {
        ArrayList<Integer> numSet = new ArrayList<Integer>();
        
        for(int i = 1; i<=A; i++)
            numSet.add(i);
 
        int i = 0;
        int j = 1;
 
        while(i < numSet.size()-1 && B > 1)
        {
            if(A-1-i > 12)
            {
                j = ++i + 1;
                continue;
            }
            
            int x = factorial(A-1-i);
            if(x >= B)
                j = ++i + 1;
 
            else if(x < B)
            {
                int temp = numSet.get(i);
                numSet.set(i, numSet.get(j));
                numSet.set(j++, temp);
                B = B - x;
            }
        }
 
        StringBuilder sb = new StringBuilder();
        for(int k = 0; k<numSet.size(); k++)
            sb.append(numSet.get(k));
 
        return sb.toString();
    }
}
