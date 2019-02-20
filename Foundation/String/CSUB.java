import java.util.*;
import java.lang.*;
import java.io.*;

class CSUB
{
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		
		for(int t = 0; t<T; t++)
		{
		    int n = in.nextInt();
		    String str = in.next();
		    
		    long num_ones = 0;
		    for(int i = 0; i<n; i++)
		        num_ones += str.charAt(i) - '0';
		        
		    long ans = num_ones*(num_ones-1)/2 + num_ones;
		    System.out.println(ans);
		}
		
		
		in.close();
	}
}
