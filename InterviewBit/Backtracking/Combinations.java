/*
Given two integers n and k, return all possible combinations of k numbers out of 1 2 3 ... n.

Make sure the combinations are sorted.

To elaborate,

Within every entry, elements should be sorted. [1, 4] is a valid entry while [4, 1] is not.
Entries should be sorted within themselves.
Example :
If n = 4 and k = 2, a solution is:

[
  [1,2],
  [1,3],
  [1,4],
  [2,3],
  [2,4],
  [3,4],
]
 Warning : DO NOT USE LIBRARY FUNCTION FOR GENERATING COMBINATIONS.
Example : itertools.combinations in python.
If you do, we will disqualify your submission retroactively and give you penalty points.
*/

public class Solution 
{
    public static void subsetsUtil(ArrayList<Integer> A, ArrayList<ArrayList<Integer>> answer, ArrayList<Integer> current, int index, int k)
    {
        for(int i = index; i<A.size(); i++)
        {
            current.add(A.get(i));
            if(current.size() == k)
                answer.add(new ArrayList<Integer>(current));
            
            subsetsUtil(A, answer, current, i+1, k);
            current.remove(current.size()-1);
        }
    }
    
    public ArrayList<ArrayList<Integer>> combine(int A, int B)
    {
        ArrayList<Integer> arr = new ArrayList<Integer>();
        for(int i = 1; i<=A; i++) arr.add(i);

        ArrayList<ArrayList<Integer>> answer = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> current = new ArrayList<Integer>();
        
        int index = 0;
        subsetsUtil(arr, answer, current, index, B);
    
        return answer;
    }
}
