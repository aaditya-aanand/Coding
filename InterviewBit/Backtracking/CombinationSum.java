/*
Given a set of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

The same repeated number may be chosen from C unlimited number of times.

Note:
All numbers (including target) will be positive integers.
Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
The combinations themselves must be sorted in ascending order.
CombinationA > CombinationB iff (a1 > b1) OR (a1 = b1 AND a2 > b2) OR … (a1 = b1 AND a2 = b2 AND … ai = bi AND ai+1 > bi+1)
The solution set must not contain duplicate combinations. 

Example, 
Given candidate set 2,3,6,7 and target 7,
A solution set is:

[2, 2, 3]
[7]

Warning : DO NOT USE LIBRARY FUNCTION FOR GENERATING COMBINATIONS.
Example : itertools.combinations in python.
If you do, we will disqualify your submission retroactively and give you penalty points. 
*/

public class Solution 
{
    public static void combinationSumUtil(ArrayList<Integer> A, int sum, ArrayList<Integer> curr, ArrayList<ArrayList<Integer>> ans, int index)
    {
        if(sum == 0)
        {
            ArrayList<Integer> temp = new ArrayList<Integer>();
            for(int i = 0; i<curr.size(); i++) temp.add(curr.get(i));
            ans.add(temp);
            return;
        }

        if(sum < 0)    return;

        while(index < A.size())
        {
            curr.add(A.get(index));
            combinationSumUtil(A, sum - A.get(index), curr, ans, index);
            curr.remove(curr.size()-1);
            index++;
        }
    }

    public ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> A, int B) 
    {
        HashSet<Integer> set = new HashSet<Integer>();

        for(int i = 0; i<A.size(); i++) set.add(A.get(i));
        A.clear();
        for(int x : set) A.add(x);
        Collections.sort(A);

        ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> curr = new ArrayList<Integer>();
        int index = 0;

        combinationSumUtil(A, B, curr, ans, index);
        return ans;
    }
}
