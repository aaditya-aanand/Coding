import java.util.*;
import java.io.*;
import java.lang.*;

class MAXDIFF {
	public static void main(String args[])
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
			for(int i = 0; i<Math.min(k, n-k); i++)
				sum -= 2*arr[i];
				
			System.out.println(sum);
		}
	}
}
