/*
Given a collection of numbers, return all possible permutations.

Example:

[1,2,3] will have the following permutations:

[1,2,3]
[1,3,2]
[2,1,3] 
[2,3,1] 
[3,1,2] 
[3,2,1]

NOTE
No two entries in the permutation sequence should be the same.

For the purpose of this problem, assume that all the numbers in the collection are unique.
Warning : DO NOT USE LIBRARY FUNCTION FOR GENERATING PERMUTATIONS.
 
Example : next_permutations in C++ / itertools.permutations in python.
If you do, we will disqualify your submission retroactively and give you penalty points. 
*/

public class Solution 
{
    public static void permuteUtil(int A[], int ans[][], int left, int right, int count[])
    {
        if(left == right)
            ans[count[0]++] = A;

        else
        {
            for(int i = left; i<=right; i++)
            {
                int temp[] = new int[A.length];

                for(int j = 0; j<A.length; j++)
                    temp[j] = A[j];

                temp[left] = A[i];
                temp[i] = A[left];

                permuteUtil(temp, ans, left+1, right, count);
            }
        }
    }

    public static int factorial(int n)
    {
        if(n == 0)
            return 1;

        return n*factorial(n-1);
    }

    public int[][] permute(int[] A) 
    {
        int n = A.length;
        int ans[][] = new int[factorial(n)][n];
        int count[] = new int[1];
        
        permuteUtil(A, ans, 0, n-1, count);

        return ans;
    }
}
