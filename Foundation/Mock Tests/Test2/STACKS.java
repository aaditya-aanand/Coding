/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
    public static int ceil(int start, int end, int array[], int key)
    {
    	if(key >= array[end])
    		return end+1;
    
    	if(key < array[start])
    		return start;
    
    	int mid = start + (end-start)/2;
    	
    	if(key >= array[mid])
    		return ceil(mid+1, end, array, key);

    	return ceil(start, mid, array, key);
    }

	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();

		for(int t = 0; t<T; t++)
		{
			int N = in.nextInt();
			int array[] = new int[N];

			for(int i = 0; i<N; i++)
				array[i] = in.nextInt();

			int ans[] = new int[N];
			ans[0] = array[0];
			int size = 1;

			for(int i = 1; i<N; i++)
			{
				int index = ceil(0, size-1, ans, array[i]);
				ans[index] = array[i];
				if(index == size)
				    size++;
			}

			System.out.print(size + " ");

			for(int i = 0; i<size; i++)
				System.out.print(ans[i] + " ");
				
			System.out.println();
		}

		in.close();
	}
}
