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
		    int arr[] = new int[n];
		    int count[] = new int[n];
		    count[n-1] = 1;
		    
		    for(int i = 0; i<n; i++)
		        arr[i] = in.nextInt();
		    
		    int i = n-2;
		    while(i >= 0)
		    {
		        if(arr[i] > 0 && arr[i+1] > 0 || arr[i] < 0 && arr[i+1] < 0)
		            count[i] = 1;
		      
		        else
		            count[i] = count[i+1] + 1;
		            
		        i--;
		    }
		    
		    for(int j = 0; j<n; j++)
		        System.out.print(count[j] + " ");
		        
		    System.out.println();
		}
		
		in.close();
	}
}
