/*
Given a collection of integers that might contain duplicates, S, return all possible subsets.

Note:
Elements in a subset must be in non-descending order.
The solution set must not contain duplicate subsets.
The subsets must be sorted lexicographically.
Example :
If S = [1,2,2], the solution is:

[
[],
[1],
[1,2],
[1,2,2],
[2],
[2, 2]
]
*/

public class Solution 
{
    public static void subsetsUtil(ArrayList<Integer> A, HashSet<ArrayList<Integer>> result, ArrayList<ArrayList<Integer>> answer, ArrayList<Integer> current, int index)
    {
        for(int i = index; i<A.size(); i++)
        {
            current.add(A.get(i));
            ArrayList<Integer> temp = new ArrayList<Integer>(current);

            if(!result.contains(temp))
            {
            	answer.add(new ArrayList<Integer>(current));
            	result.add(new ArrayList<Integer>(current));
            }
            
            subsetsUtil(A, result, answer, current, i+1);
            current.remove(current.size()-1);
        }
    }
    
    public ArrayList<ArrayList<Integer>> subsetsWithDup(ArrayList<Integer> A) 
    {
        Collections.sort(A);
        HashSet<ArrayList<Integer>> result = new HashSet<ArrayList<Integer>>();
        ArrayList<ArrayList<Integer>> answer = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> current = new ArrayList<Integer>();
        answer.add(new ArrayList<Integer>());
        
        int index = 0;
        subsetsUtil(A, result, answer, current, index);
    
        return answer;
    }
}
