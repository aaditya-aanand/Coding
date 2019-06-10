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
		    int n = in.nextInt();
		    String s = in.next();
		    
		    long count = 0;
		    for(int i = 0; i<s.length(); i++)
		        count = (s.charAt(i) == '1') ? count+1 : count;
		        
		    System.out.println(count + count*(count-1)/2);
		}
	}
}
