import java.util.*;
import java.lang.*;
import java.io.*;

class point
{
	int num;
	int index;

	public point(int num, int index)
	{
		this.num = num;
		this.index = index;
	}
}

class sortBySomething implements Comparator<point> 
{
    public int compare(point a, point b) 
    { 
        return a.num - b.num; 
    } 
} 

class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int K = in.nextInt();
		int P = in.nextInt();

		point arr[] = new point[N];

		for(int i = 0; i<N; i++)
		{
			int x = in.nextInt();
			arr[i] = new point(x, i);
		}

		Arrays.sort(arr, new sortBySomething());
		int parent[] = new int[N];
		parent[arr[0].index] = arr[0].index;

		for(int i = 1; i<N; i++)
		{
			if(arr[i].num - arr[i-1].num <= K)
				parent[arr[i].index] = parent[arr[i-1].index];

			else
				parent[arr[i].index] = arr[i].index;
		}

		for(int i = 0; i<P; i++)
		{
			int a = in.nextInt();
			int b = in.nextInt();

			if(parent[a-1] == parent[b-1])
				System.out.println("Yes");

			else
				System.out.println("No");
		}

		in.close();
	}
}
