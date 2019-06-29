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

	label:for(int t = 0; t<T; t++)
		{
			int N = in.nextInt();
			int arr[] = new int[N];

			for(int i = 0; i<N; i++)
				arr[i] = in.nextInt();

			int prev = 0;
			int l = 0;
			int r = N-1;

			while(l <= r)
			{
				if(!(arr[l] == arr[r] && (arr[l] - prev) <= 1 && (arr[l] - prev) >= 0 && arr[l] < 8))
				{
					System.out.println("no");
					continue label;
				}

				else
				{
					prev = arr[l];
					l++;
					r--;
				}
			}

			if (prev == 7) System.out.println("yes");
			else System.out.println("no");
		}
		
		in.close();
	}
}
