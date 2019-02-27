import java.util.*;
import java.io.*;
import java.lang.*;

class CEILRCPT {
	public static void main(String args[])
	{
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		
		Vector<Integer> price = new Vector<Integer>();
		int k = 0;
		while(1<<k < 4096)
		{
			price.add(1<<k);
			k++;
		}
		
		for(int i = 0; i<T; i++)
		{
			int x = in.nextInt();
			int s = price.size();
			
			int count = 0;
			for(int j = s-1; j>=0; j--)
			{
				if(price.elementAt(j) <= x)
				{
					int temp = (x/price.elementAt(j))*price.elementAt(j);
					count += x/price.elementAt(j);
					x -= temp;
				}
			}
			
			System.out.println(count);
		}
	}
}
