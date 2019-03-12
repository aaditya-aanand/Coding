/*
Given an input string, reverse the string word by word.

Example:

Given s = "the sky is blue",

return "blue is sky the".

A sequence of non-space characters constitutes a word.
Your reversed string should not contain leading or trailing spaces, even if it is present in the input string.
If there are multiple spaces between words, reduce them to a single space in the reversed string.
*/

public class Solution 
{
    public String reverseWords(String a) 
    {
        ArrayList<String> ans = new ArrayList<String>();
        a.trim();

        String prev = "";
        for(int i = 0; i<a.length(); i++)
        {
            if(a.charAt(i) != ' ')
                prev += a.charAt(i);

            else if(a.charAt(i) == ' ' && !prev.equals(""))
            {
                ans.add(prev);
                prev = "";
            }
        }

        if(!prev.equals(""))
            ans.add(prev);

        String answer = " ";
        for(int i = ans.size()-1; i>=0; i--)
            answer += ans.get(i) + " ";

        return answer.trim();
    }
}
