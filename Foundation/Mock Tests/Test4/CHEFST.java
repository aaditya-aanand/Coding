/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		
		for(int t = 0; t<T; t++)
		{
			long n1 = in.nextLong();
			long n2 = in.nextLong();
			long m = in.nextLong();
			
			long min = Math.min(n1, n2);
			long max = Math.max(n1, n2);
			
			if(m*(m+1)/2 > min)
				System.out.println(max-min);
			
			else
				System.out.println(min + max - m*(m+1));
		}
		
		in.close();
	}
}
