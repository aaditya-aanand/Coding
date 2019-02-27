import java.util.*;
import java.io.*;
import java.lang.*;

class CHEFST {
	public static void main(String args[])
	{
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		
		for(int t = 0; t<T; t++)
		{
			long n1 = in.nextLong();
			long n2 = in.nextLong();
			long m = in.nextLong();
			
			if(m*(m+1)/2 <= Math.min(n1, n2))
				System.out.println(n1+n2-m*(m+1));
				
			else
				System.out.println(Math.abs(n1-n2));
		}
	}
}
