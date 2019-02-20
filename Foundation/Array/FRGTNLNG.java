import java.util.*;
import java.lang.*;
import java.io.*;

class FRGTNLNG
{
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		
		for(int t = 0; t<T; t++)
		{
		    int n = in.nextInt();
		    int k = in.nextInt();
		    
		    String words[] = new String[n];
		    for(int i = 0; i<n; i++)
		        words[i] = in.next();
		        
		    HashSet<String> set = new HashSet<String>();
		    
		    for(int i = 0; i<k; i++)
		    {
		        int l = in.nextInt();
		        for(int j = 0; j<l; j++)
		            set.add(in.next());
		    }
		    
		    for(int i = 0; i<n; i++)
		    {
		        String w = words[i];
		        if(set.contains(w))
		            System.out.print("YES ");
		        else
		            System.out.print("NO ");
		    }
		    
		    System.out.println();
		        
		}
		
		in.close();
	}
}
