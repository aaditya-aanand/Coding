/*
Given a string, 
find the length of the longest substring without repeating characters.

Example:

The longest substring without repeating letters for "abcabcbb" is "abc", which the length is 3.

For "bbbbb" the longest substring is "b", with the length of 1.
*/

public class Solution 
{
    public int lengthOfLongestSubstring(String A) 
    {
        HashSet<Character> set = new HashSet<Character>();
        int i = 0;
        int j = 0;
        int max = 1;
        
        while(i<=j && j<A.length())
        {
            char xj = A.charAt(j);
            if(set.contains(xj))
            {
                max = Math.max(max,  set.size());
                set.remove(A.charAt(i));
                i++;
            }
            
            else
            {
                set.add(xj);
                j++;
            }        
        }
        
        return Math.max(max, set.size());
    }
}
