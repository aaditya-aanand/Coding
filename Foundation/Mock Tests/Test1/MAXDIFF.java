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
		    int k = in.nextInt();
		    
		    int arr[] = new int[n];
		    int sum = 0;
		    for(int i = 0; i<n; i++)
		    {
		        arr[i] = in.nextInt();
		        sum += arr[i];
		    }
		        
		    Arrays.sort(arr);
		    
		    int sum1 = 0;
		    int sum2 = 0;
		    
		    int j = k;
		    while(j != 0)
		    {
		        sum1 += arr[n-1-k+j];
		        sum2 += arr[k-j];
		        j--;
		    }
		    
		    int ans1 = Math.abs(sum-2*sum1);
		    int ans2 = Math.abs(sum-2*sum2);
		    
		    System.out.println(Math.max(ans1, ans2));
		}
		
		in.close();
	}
}
