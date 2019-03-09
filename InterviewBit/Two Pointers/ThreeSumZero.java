/*
Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? 
Find all unique triplets in the array which gives the sum of zero.

Note:

Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ≤ b ≤ c)
The solution set must not contain duplicate triplets. For example, given array S = {-1 0 1 2 -1 -4}, A solution set is:
(-1, 0, 1)
(-1, -1, 2) 
*/

public class Solution {
    public int[][] threeSum(int[] AA) {
        
        Arrays.sort(AA);
        Vector<Vector<Integer>> arr = new Vector<Vector<Integer>>();
        
        int n = AA.length;
        
        int count = 0;
        for(int i = 0; i<n-2; i++)
        {
            int sum = -AA[i];
            int j = i+1;
            int k = AA.length-1;
            
            while(j < k)
            {
                if(AA[j]+AA[k] > sum)
                    k--;
                
                else if(AA[j]+AA[k] < sum)
                    j++;
                
                else
                {
                    arr.add(new Vector<Integer>());
                    arr.get(count).add(AA[i]);
                    arr.get(count).add(AA[j]);
                    arr.get(count).add(AA[k]);
                    count++;
                    j++;
                    k--;
               }
            }
        }
        
        HashSet<Vector<Integer>> set = new HashSet<Vector<Integer>>();
        for(int i = 0; i<arr.size(); i++)
            set.add(arr.elementAt(i));
        
        int array[][] = new int[set.size()][3];
        int cc = 0;
        for(Vector x : set)
        {
            for(int j = 0; j<3; j++)
            {
                array[cc][j] = (int)x.elementAt(j);
            }
            cc++;
        }
        
        return array;
    }
}
