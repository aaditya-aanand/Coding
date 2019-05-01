/*
Given a string, find the rank of the string amongst its permutations sorted lexicographically. 
Assume that no characters are repeated.

Example :

Input : 'acb'
Output : 2

The order permutations with letters 'a', 'c', and 'b' : 
abc
acb
bac
bca
cab
cba
The answer might not fit in an integer, so return your answer % 1000003
*/

public class Solution 
{
    public static int factorial(int n, int m)
    {
        int ans = 1;
        for(int i = 1; i<=n; i++)
            ans = ((ans%m)*(i%m))%m;
        
        return ans;
    }
    
    public static int numSmallChars(char x, String S, int j)
    {
        int count = 0;
        for(int i = j; i<S.length(); i++)
        {
            if(S.charAt(i) < x)
                count++;
        }
        
        return count;
    }
    
    public int findRank(String A) 
    {
        int ans = 0;
        int m = 1000003;
        for(int i = 0; i<A.length(); i++)
            ans = (ans + (numSmallChars(A.charAt(i), A, i)*factorial(A.length()-1-i, m))%m)%m;
        
        return ans + 1;
    }
}
