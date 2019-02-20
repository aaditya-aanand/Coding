import java.util.*;
import java.lang.*;
import java.io.*;

class COPS
{
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		
		for(int t = 0; t<T; t++)
		{
		    int M = in.nextInt();
		    int x = in.nextInt();
		    int y = in.nextInt();
		    
		    boolean visited[] = new boolean[101];
		    visited[0] = true;
		    
		    for(int i = 0; i<M; i++)
		    {
		        int m = in.nextInt();
		        for(int j = Math.max(1, m-x*y); j<=Math.min(100, m+x*y); j++)
		            visited[j] = true;
		    }
		    
		    int sum = 0;
		    for(int i = 0; i<visited.length; i++)
		    {
		        if(!visited[i])
		            sum++;
		    }
		    
		    System.out.println(sum);
		}
		
		in.close();
	}
}
