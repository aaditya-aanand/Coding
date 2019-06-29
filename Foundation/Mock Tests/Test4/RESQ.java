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
			int N = in.nextInt();
			
			for(int i = (int) Math.sqrt(N); i>=0; i--)
			{
				if(N%i == 0)
				{
					System.out.println(Math.abs(i - N/i));
					break;
				}
			}
			
		}
	}
}
