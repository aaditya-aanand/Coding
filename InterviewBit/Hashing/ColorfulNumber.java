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