/*
Given a sequence of matrices, find the most efficient way to multiply these matrices together. The problem is not actually to perform the multiplications, but merely to decide in which order to perform the multiplications. There are many options to multiply a chain of matrices because matrix multiplication is associative i.e. no matter how one parenthesize the product, the result will be the same.

Example:
 if you had four matrices A, B, C, and D, you would have:

    (ABC)D = (AB)(CD) = A(BCD) = ....
However, the order in which one parenthesize the product affects the number of simple arithmetic operations needed to compute the product, or the efficiency.

For example:

A: 10 × 30 matrix
B : 30 × 5 matrix
C : 5 × 60 matrix
Then,
     (AB)C = (10×30×5) + (10×5×60) 
           = 1500 + 3000 
           = 4500 operations
     A(BC) = (30×5×60) + (10×30×60) 
           = 9000 + 18000 
           = 27000 operations.
Given an array arr[] which represents the chain of matrices such that the ith matrix Ai is of dimension arr[i-1] x arr[i]. Your task is to write a function that should print the minimum number of multiplications needed to multiply the chain.

  Input: p[] = {40, 20, 30, 10, 30}   
  Output: 26000  
  There are 4 matrices of dimensions 40x20, 
  20x30, 30x10 and 10x30. Let the input 4 
  matrices be A, B, C and D.  The minimum 
  number of multiplications are obtained 
  by putting parenthesis in following way
  (A(BC))D --> 20*30*10 + 40*20*10 + 40*10*30

  Input: p[] = {10, 20, 30, 40, 30} 
  Output: 30000 
  There are 4 matrices of dimensions 10x20, 
  20x30, 30x40 and 40x30. Let the input 4 
  matrices be A, B, C and D.  The minimum 
  number of multiplications are obtained by 
  putting parenthesis in following way
  ((AB)C)D --> 10*20*30 + 10*30*40 + 10*40*30
Input:
The first line of the input contains an integer T, denoting the number of test cases. Then T test case follows. The first line of each test case contains an integer N, denoting the number of elements in the array.
Then next line contains N space separated integers denoting the values of the element in the array.

Output:
For each test case the print the minimum number of operations needed to multiply the chain.

Constraints:
1<=T<=100
2<=N<=100
1<=A[]<=500

Example:
Input:
2
5
1 2 3 4 5
3
3 3 3
Output:
38
27
*/

import java.util.*;
import java.io.*;

class GFG
{
	public static void main(String args[])
	{
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();

		for(int t = 0; t<T; t++)
		{
			int n = in.nextInt();
			int arr[] = new int[n];

			for(int i = 0; i<n; i++)
				arr[i] = in.nextInt();


			int dp[][] = new int[n-1][n-1];

			for(int i = 1; i<dp.length; i++)
			{
				int r = 0;
				int c = i;

				while(r < dp.length && c < dp[0].length)
				{
					int min = Integer.MAX_VALUE;
					for(int k = r; k<c; k++)
						min = Math.min(min, dp[r][k] + dp[k+1][c] + arr[r]*arr[k+1]*arr[c+1]);

					dp[r++][c++] = min;
				}
			}

			System.out.println(dp[0][n-2]);
		}
		
		in.close();
	}
}
