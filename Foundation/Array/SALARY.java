import java.util.*;
import java.lang.*;
import java.io.*;

class SALARY
{
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		
		for(int t = 0; t<T; t++)
		{
		    int n = in.nextInt();
		    int wages[] = new int[n];
		    int min_wage = Integer.MAX_VALUE;
		    
		    for(int i = 0; i<n; i++)
		    {
		        wages[i] = in.nextInt();
		        min_wage = Math.min(min_wage, wages[i]);
		    }
		    
		    int ans = 0;
		    for(int i = 0; i<n; i++)
		        ans += (wages[i] - min_wage);
		        
		    System.out.println(ans);
		}
		
		in.close();
	}
}
