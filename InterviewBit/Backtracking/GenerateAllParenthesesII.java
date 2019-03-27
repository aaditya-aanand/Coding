/*
Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses of length 2*n.

For example, given n = 3, a solution set is:

"((()))", "(()())", "(())()", "()(())", "()()()"
Make sure the returned list of strings are sorted.
*/

public class Solution 
{
    public static void generateParenthesisUtil(int n, ArrayList<String> answer, String temp, int numOpen, int numClose)
    {
        if(numOpen == numClose && numClose == n)
        {
            answer.add(temp);
            return;
        }

        if(numOpen > n || numClose > numOpen)
            return;

        generateParenthesisUtil(n, answer, temp + "(", numOpen+1, numClose);
        generateParenthesisUtil(n, answer, temp + ")", numOpen, numClose+1);
    }

    public ArrayList<String> generateParenthesis(int A) 
    {
        ArrayList<String> answer = new ArrayList<String>();
        String temp = "";
        int numOpen = 0;
        int numClose = 0;
        
        generateParenthesisUtil(A, answer, temp, numOpen, numClose);
        
        return answer;
    }
}
