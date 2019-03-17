/*
Rearrange a given array so that Arr[i] becomes Arr[Arr[i]] with O(1) extra space.

Example:

Input : [1, 0]
Return : [0, 1]
Lets say N = size of the array. Then, following holds true :
All elements in the array are in the range [0, N-1]
N * N does not overflow for a signed integer
*/

public class Solution 
{
    public void arrange(ArrayList<Integer> a) 
    {
        int n = a.size();
        for(int i = 0; i<a.size(); i++)
        {
            int pos = a.get(i);
            if(a.get(pos) > n)
            {
                int earlier = -1 + a.get(pos)/n;
                a.set(i, (a.get(i)+1)*n + earlier);
            }

            else
                a.set(i, (a.get(i)+1)*n + a.get(pos));
        }

        for(int i = 0; i<a.size(); i++)
            a.set(i, a.get(i)%n);
    }
}
