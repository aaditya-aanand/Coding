/*
Given an array of strings, return all groups of strings that are anagrams. 
Represent a group by a list of integers representing the index in the original list. Look at the sample case for clarification.

Anagram : a word, phrase, or name formed by rearranging the letters of another, such as 'spar', formed from 'rasp' 
Note: All inputs will be in lower-case. 
Example :

Input : cat dog god tca
Output : [[1, 4], [2, 3]]
cat and tca are anagrams which correspond to index 1 and 4. 
dog and god are another set of anagrams which correspond to index 2 and 3.
The indices are 1 based ( the first element has index 1 instead of index 0).

 Ordering of the result : You should not change the relative ordering of the words / phrases 
 */

public class Solution 
{
    public static boolean isAnagram(String s1, String s2)
    {
        char a1[] = s1.toCharArray();
        char a2[] = s2.toCharArray();
        
        Arrays.sort(a1);
        Arrays.sort(a2);
        
        return String.copyValueOf(a1).equals(String.copyValueOf(a2));
    }
    
    public ArrayList<ArrayList<Integer>> anagrams(final List<String> A) 
    {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
        boolean visited[] = new boolean[A.size()];
        
        for(int i = 0; i<A.size(); i++)
        {
            if(!visited[i])
            {
                ArrayList<Integer> result = new ArrayList<Integer>();
                for(int j = i; j<A.size(); j++)
                {
                    if(!visited[j] && isAnagram(A.get(i), A.get(j)))
                    {
                        result.add(j+1);
                        visited[j] = true;
                    }        
                }
                ans.add(result);
            }
        }
        
        return ans;
    }
}
