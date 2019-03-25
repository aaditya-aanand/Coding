/*
Given a set of distinct integers, S, return all possible subsets.

Note:

Elements in a subset must be in non-descending order.
The solution set must not contain duplicate subsets.
Also, the subsets should be sorted in ascending ( lexicographic ) order.
The list is not necessarily sorted.

Example :

If S = [1,2,3], a solution is:

[
  [],
  [1],
  [1, 2],
  [1, 2, 3],
  [1, 3],
  [2],
  [2, 3],
  [3],
]
*/

public class Solution 
{
    public static void subsetsUtil(ArrayList<Integer> A, ArrayList<ArrayList<Integer>> result, ArrayList<Integer> current, int index)
    {
        for(int i = index; i<A.size(); i++)
        {
            current.add(A.get(i));
            result.add(new ArrayList<Integer>(current));
            subsetsUtil(A, result, current, i+1);
            current.remove(current.size()-1);
        }
    }
    public ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> A) 
    {
        Collections.sort(A);
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> current = new ArrayList<Integer>();
        result.add(new ArrayList<Integer>());
        
        int index = 0;
        subsetsUtil(A, result, current, index);
        return result;
    }
}
