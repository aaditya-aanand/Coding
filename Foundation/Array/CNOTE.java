import java.util.*;
import java.lang.*;
import java.io.*;

class CNOTE
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
		    
		    int pages[] = new int[n];
		    int price[] = new int[n];
		    
		    int max_pages = -1;
		    for(int i = 0; i<n; i++)
		    {
		        pages[i] = in.nextInt();
		        price[i] = in.nextInt();
		        
		        if(price[i] <= k)
		            max_pages = Math.max(max_pages, pages[i]);
		    }
		    
		    int req_pages = x-y;
		    
		    if(max_pages >= req_pages)
		        System.out.println("LuckyChef");
		        
		    else
		        System.out.println("UnluckyChef");
		    
		}
		
		in.close(); 
	}
}
