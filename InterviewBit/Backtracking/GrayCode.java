/*
The gray code is a binary numeral system where two successive values differ in only one bit.

Given a non-negative integer n representing the total number of bits in the code, print the sequence of gray code. 
A gray code sequence must begin with 0.

For example, given n = 2, return [0,1,3,2]. Its gray code sequence is:

00 - 0
01 - 1
11 - 3
10 - 2
There might be multiple gray code sequences possible for a given n.
Return any such sequence.
*/

//Backtracking based approach
public class Solution 
{
	public static void grayCodeUtil(int a, int dum[], ArrayList<Integer> arr)
	{
		if(a == 0)
		{
			arr.add(dum[0]);
			System.out.println(dum[0]);
			return;
		}

		grayCodeUtil(a-1, dum, arr);
		dum[0] = dum[0]^(1<<(a-1));
		grayCodeUtil(a-1, dum, arr);
	}

    public ArrayList<Integer> grayCode(int a) 
    {
    	ArrayList<Integer> arr = new ArrayList<Integer>();
    	int dum[] = new int[1]; //We need the pass the reference of the variable rather than the variable itself
    	grayCodeUtil(a, dum, arr);
    	return arr;
    }
}

//Formula based approach
public class Solution 
{
    public ArrayList<Integer> grayCode(int a) 
    {
        ArrayList<Integer> arr = new ArrayList<Integer>();
        for(int i = 0; i<(1<<a); i++)
            arr.add(i^(i>>1));

        return arr;
    }
}
