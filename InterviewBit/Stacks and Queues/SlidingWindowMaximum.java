/*
A long array A[] is given to you. 
There is a sliding window of size w which is moving from the very left of the array to the very right. 
You can only see the w numbers in the window. Each time the sliding window moves rightwards by one position. 
You have to find the maximum for each window.
*/

public class Solution 
{
    public int[] slidingMaximum(final int[] A, int B) 
    {
    	int len = A.length;
    	int ans[] = new int[len-B+1];
    	Deque<Integer> D = new LinkedList<Integer>();

    	for(int i = 0; i<len; i++)
    	{
    		while(!D.isEmpty())
    		{
    			if(A[D.peekLast()] <= A[i])
    				D.pollLast();

    			else
    				break;
    		}

    		D.addLast(i);

    		if(i - D.peekFirst() >= B)
    			D.pollFirst();

    		if(i >= B-1)
    			ans[i - (B-1)] = A[D.peekFirst()];
    	}

    	return ans;
    }
}
