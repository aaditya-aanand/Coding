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
		    int x = in.nextInt();
		    int y = in.nextInt();
		    int k = in.nextInt();
		    int n = in.nextInt();
		    
		    boolean flag = false;
		    for(int i = 0; i<n; i++)
		    {
		        int p = in.nextInt();
		        int c = in.nextInt();
		        
		        if(p >= x-y && c <= k)
		            flag |= true;
		    }
		        
		    if(flag)
		        System.out.println("LuckyChef");
		        
		    else
		        System.out.println("UnluckyChef");
		}
		
		in.close();

	}
}
