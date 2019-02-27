import java.util.*;
import java.io.*;

class TACHSTCK {
	public static void main(String[] arg) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int d = in.nextInt();
		
		int arr[] = new int[n];
		
		for(int i = 0; i<n; i++)
			arr[i] = in.nextInt();
			
		Arrays.sort(arr);
		int p1 = 0;
		int p2 = 1;
		int count = 0;
		while(p2 < n)
		{
			if(Math.abs(arr[p1]-arr[p2]) <= d)
			{
				count++;
				p1 += 2;
				p2 += 2;
			}
			
			else
			{
				p1++;
				p2++;
			}
		}
		
		System.out.println(count);
	}
}
