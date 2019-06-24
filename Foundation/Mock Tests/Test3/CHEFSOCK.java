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
		int jc = in.nextInt();
		int sc = in.nextInt();
		int mon = in.nextInt();
		
		int x = (mon-jc)/sc;
		if(x%2 == 0)
		    System.out.println("Lucky Chef");
		    
		else
		    System.out.println("Unlucky Chef");
		
		in.close();
	}
}
