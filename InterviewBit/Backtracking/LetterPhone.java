/*
Given a digit string, return all possible letter combinations that the number could represent.

A mapping of digit to letters (just like on the telephone buttons) is given below.



The digit 0 maps to 0 itself.
The digit 1 maps to 1 itself.

Input: Digit string "23"
Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
Make sure the returned strings are lexicographically sorted.
*/

public class Solution 
{
    public static void letterCombinationsUtil(String A, String arr[], ArrayList<String> result, int index, String temp)
    {
        if(index == A.length())
        {
            result.add(temp);
            return;
        }

        int x = A.charAt(index) - '0';
        for(int j = 0; j<arr[x].length(); j++)
        {
            String dummy = temp + arr[x].charAt(j);
            letterCombinationsUtil(A, arr, result, index+1, dummy);
        }
    }

    public ArrayList<String> letterCombinations(String A) 
    {
        String arr[] = new String[]{"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        ArrayList<String> result = new ArrayList<String>();
        int index = 0;
        String temp = "";

        letterCombinationsUtil(A, arr, result, index, temp);
        return result;
    }
}
