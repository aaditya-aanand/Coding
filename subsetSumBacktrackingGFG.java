/*
Given a set of numbers, 
check whether it can be partitioned into two subsets such that the sum of elements in both subsets is same or not.

Input:The first line contains an integer 'T' denoting the total number of test cases. Each test case constitutes of two lines. 
First line contains 'N', representing the number of elements in the set and the second line contains the elements of the set.

Output: Print YES if the given set can be partioned into two subsets such that the sum of elements in both subsets is equal, 
else print NO.

Constraints: 

1 <= T<= 100
1 <= N<= 100
0 <= arr[i]<= 1000

                   
Example:

Input:
2
4
1 5 11 5
3
1 3 5 

Output:

YES
NO
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG 
{
	public static boolean solveSubset(int arr[], int sum, boolean visited[])
	{
		if(sum == 0)
			return true;

		if(sum < 0)
			return false;

		for(int i = 0; i<visited.length; i++)
		{
			if(!visited[i])
			{
				visited[i] = true;

				if(solveSubset(arr, sum-arr[i], visited))
					return true;

				visited[i] = false;
			}
		}
		
		return false;
	}
	public static void main (String[] args) 
	{
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();

		for(int t = 0; t<T; t++)
		{
			int n = in.nextInt();
			int arr[] = new int[n];
			boolean visited[] = new boolean[n];

			int sum = 0;
			for(int i = 0; i<n; i++)
			{
				arr[i] = in.nextInt();
				sum += arr[i];
			}

			if(sum%2 != 0)
				System.out.println("NO");

			else
			{
				boolean x = solveSubset(arr, sum/2, visited);
				if(x) System.out.println("YES");
				else System.out.println("NO");
			}
		}
	}
}
