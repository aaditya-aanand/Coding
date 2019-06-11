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
			int p = in.nextInt();
			int count = p/2048;
			p = p%2048;
			
			while(p > 0)
			{
				int x = (int) (Math.log10(p)/Math.log10(2));
				int y = 1<<x;
				count++;
				p -= y;
			}
			
			System.out.println(count);
		
		}
		in.close();
	}
}
