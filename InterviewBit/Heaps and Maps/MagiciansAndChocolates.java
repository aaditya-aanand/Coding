/*
Given N bags, each bag contains Ai chocolates. 
There is a kid and a magician. 
In one unit of time, kid chooses a random bag i, eats Ai chocolates, then the magician fills the ith bag with floor(Ai/2) chocolates.

Given Ai for 1 <= i <= N, find the maximum number of chocolates kid can eat in K units of time.

For example,

K = 3
N = 2
A = 6 5

Return: 14
At t = 1 kid eats 6 chocolates from bag 0, and the bag gets filled by 3 chocolates
At t = 2 kid eats 5 chocolates from bag 1, and the bag gets filled by 2 chocolates
At t = 3 kid eats 3 chocolates from bag 0, and the bag gets filled by 1 chocolate
so, total number of chocolates eaten: 6 + 5 + 3 = 14

Note: Return your answer modulo 10^9+7
*/

public class Solution 
{
    public int nchoc(int A, int[] B) 
    {
        PriorityQueue<Long> pq = new PriorityQueue<Long>(10, Collections.reverseOrder());

        for(int i = 0; i<B.length; i++)
            pq.offer((long)B[i]);

        long ans = 0;
        long m = 1000000007;

        for(int i = 0; i<A; i++)
        {
            long x = pq.poll();
            ans = (ans + x)%m;
            pq.offer(x/2);
        }

        return (int) ans;
    }
}
