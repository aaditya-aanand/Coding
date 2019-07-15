import java.util.*;
import java.lang.*;
import java.io.*;

class Codechef
{
	public static int gcd(int a, int b)
	{
		return (b == 0) ? a : gcd(b, a%b);
	}

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

			for(int i = 0; i<N; i++)
				arr[0] = gcd(arr[0], arr[i]);
			
			System.out.println(arr[0]);
		}

		in.close();
	}
}
