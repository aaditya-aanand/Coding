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
		
		label:for(int t = 0; t<T; t++)
		{
			String s = in.next();
			int start = -1, end = -1;
			
			for(int i = 0; i<s.length(); i++)
			{
				if(s.charAt(i) == '1')
				{
					start = i;
					break;
				}
			}
			
			for(int i = s.length()-1; i>=0; i--)
			{
				if(s.charAt(i) == '1')
				{
					end = i;
					break;
				}
			}
			
			if(start != -1)	
			{
				for(int i = start; i<=end; i++)
				{
					if(s.charAt(i) == '0')
					{
						System.out.println("NO");
						continue label;
					}
				}
				
				System.out.println("YES");
			}
			
			else 
				System.out.println("NO");
		}
		
		in.close();
	}
}
