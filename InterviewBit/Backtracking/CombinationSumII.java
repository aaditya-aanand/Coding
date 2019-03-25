/*
Given a collection of candidate numbers (C) and a target number (T), 
find all unique combinations in C where the candidate numbers sums to T.

Each number in C may only be used once in the combination.

Note:
All numbers (including target) will be positive integers.
Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
The solution set must not contain duplicate combinations.
Example :

Given candidate set 10,1,2,7,6,1,5 and target 8,

A solution set is:

[1, 7]
[1, 2, 5]
[2, 6]
[1, 1, 6]
Warning : DO NOT USE LIBRARY FUNCTION FOR GENERATING COMBINATIONS.
Example : itertools.combinations in python.
If you do, we will disqualify your submission retroactively and give you penalty points.
*/

public class Solution 
{
    public static void combinationSumUtil(ArrayList<Integer> A, int sum, ArrayList<Integer> curr, HashSet<ArrayList<Integer>> ans, int index)
    {
        if(sum == 0)
        {
            ans.add(new ArrayList<Integer>(curr));
            return;
        }

        if(sum < 0)    return;

        while(index < A.size())
        {
            curr.add(A.get(index));
            combinationSumUtil(A, sum - A.get(index), curr, ans, index+1);
            curr.remove(curr.size()-1);
            index++;
        }
    }

    public ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> A, int B) 
    {
        Collections.sort(A);

        HashSet<ArrayList<Integer>> ans = new HashSet<ArrayList<Integer>>();
        ArrayList<ArrayList<Integer>> answer = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> curr = new ArrayList<Integer>();
        int index = 0;

        combinationSumUtil(A, B, curr, ans, index);
        for(ArrayList<Integer> x : ans) answer.add(x);
        return answer;
    }
}
