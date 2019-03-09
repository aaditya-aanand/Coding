/*
Find the intersection of two sorted arrays.
OR in other words,
Given 2 sorted arrays, find all the elements which occur in both the arrays.

Example :

Input : 
    A : [1 2 3 3 4 5 6]
    B : [3 3 5]

Output : [3 3 5]

Input : 
    A : [1 2 3 3 4 5 6]
    B : [3 5]

Output : [3 5]
NOTE : For the purpose of this problem ( as also conveyed by the sample case ), 
assume that elements that appear more than once in both arrays should be included multiple times in the final output. 
*/

public class Solution 
{
    public ArrayList<Integer> intersect(final List<Integer> A, final List<Integer> B) 
    {
        int a = A.size();
        int b = B.size();

        ArrayList<Integer> ans = new ArrayList<Integer>();

        int i = 0;
        int j = 0;

        
        while(i < a && j < b)
        {
            int x = A.get(i).intValue();
            int y = B.get(j).intValue();
            
            if(x == y)
            {
                ans.add(x);
                i++;
                j++;
            }

            else if(x < y)
                i++;

            else
                j++;
        }

        return ans;
    }
}
