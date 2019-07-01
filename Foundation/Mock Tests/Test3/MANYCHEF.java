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
			String s = in.next();
			char arr[] = s.toCharArray();
			
			for(int i = arr.length-1; i>=3; i--)
			{
				if((arr[i] == 'F' || arr[i] == '?') && (arr[i-1] == 'E' || arr[i-1] == '?') && (arr[i-2] == 'H' || arr[i-2] == '?') && (arr[i-3] == 'C' || arr[i-3] == '?'))
				{
					arr[i] = 'F';
					arr[i-1] = 'E';
					arr[i-2] = 'H';
					arr[i-3] = 'C';
					i -= 3;
				}
			}
			
			for(int i = 0; i<arr.length; i++)
				if(arr[i] == '?')
					arr[i] = 'A';
			
			System.out.println(String.copyValueOf(arr));
		}
		
		in.close();
	}
}
