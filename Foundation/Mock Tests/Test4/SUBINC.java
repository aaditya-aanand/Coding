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
			int N = in.nextInt();
			int arr[] = new int[N];

			for(int i = 0; i<N; i++)
				arr[i] = in.nextInt();

			int prev = 0;
			int last_index = 0;
			long count = 0;

			for(int i = 0; i<N; i++)
			{
				if(arr[i] < prev)
				{
					long n = i - last_index;
					count += n*(n+1)/2;
					last_index = i;
				}

				prev = arr[i];
			}

			long n = N - last_index;
			count += n*(n+1)/2;
			System.out.println(count);
		}
		
		in.close();
	}
}
