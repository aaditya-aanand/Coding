/*
For Given Number N find if its COLORFUL number or not

Return 0/1

COLORFUL number:

A number can be broken into different contiguous sub-subsequence parts. 
Suppose, a number 3245 can be broken into parts like 3 2 4 5 32 24 45 324 245. 
And this number is a COLORFUL number, since product of every digit of a contiguous subsequence is different
Example:

N = 23
2 3 23
2 -> 2
3 -> 3
23 -> 6
this number is a COLORFUL number since product of every digit of a sub-sequence are different. 

Output : 1
*/

public class Solution 
{
    public int colorful(int A) 
    {
    	String s = String.valueOf(A);
    	int len = s.length();
    	HashSet<Integer> set = new HashSet<Integer>();
    	
    	for(int i = 1; i<=len; i++)
    	{
    		for(int j = 0; j<=len-i; j++)
    		{
    			int prod = 1;
    			for(int k = j; k<j+i; k++)
    				prod = prod*(s.charAt(k) - '0');
    			
    			if(set.contains(prod))
    				return 0;
    			
    			else
    				set.add(prod);
    		}
    	}
    	
    	return 1;
    }
}
