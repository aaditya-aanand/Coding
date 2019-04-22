/*
Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target? 
Find all unique quadruplets in the array which gives the sum of target.

Note:
Elements in a quadruplet (a,b,c,d) must be in non-descending order. (ie, a ≤ b ≤ c ≤ d)
The solution set must not contain duplicate quadruplets.

Example : 
Given array S = {1 0 -1 0 -2 2}, and target = 0
A solution set is:

    (-2, -1, 1, 2)
    (-2,  0, 0, 2)
    (-1,  0, 0, 1)
    
Also make sure that the solution set is lexicographically sorted.
Solution[i] < Solution[j] iff Solution[i][0] < Solution[j][0] OR 
(Solution[i][0] == Solution[j][0] AND ... Solution[i][k] < Solution[j][k])
*/

public class Solution 
{
    public ArrayList<ArrayList<Integer>> fourSum(ArrayList<Integer> A, int B) 
    {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
        HashSet<ArrayList<Integer>> set = new HashSet<ArrayList<Integer>>();
        Collections.sort(A);
        
        for(int i = 0; i<A.size(); i++)
        {
            for(int j = i+1; j<A.size(); j++)
            {
                int target = B - A.get(i) - A.get(j);
                int start = j+1;
                int end = A.size()-1;
                
                while(start < end)
                {
                    if(A.get(start) + A.get(end) < target)
                        start++;
                    
                    else if(A.get(start) + A.get(end) > target)
                        end--;
                    
                    else
                    {
                        ArrayList<Integer> res = new ArrayList<Integer>();
                        res.add(A.get(i));
                        res.add(A.get(j));
                        res.add(A.get(start));
                        res.add(A.get(end));
                        
                        if(!set.contains(res))
                        {
                            set.add(res);
                            ans.add(res);
                        }
                        
                        start++;
                        end--;
                    }
                }
            }
        }
        
        return ans;
    }
}
