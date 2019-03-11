/*
Given a positive integer, return its corresponding column title as appear in an Excel sheet.

For example:

    1 -> A
    2 -> B
    3 -> C
    ...
    26 -> Z
    27 -> AA
    28 -> AB
*/    
    
public class Solution 
{
    public String convertToTitle(int A) 
    {
        String ans = "";
        while(A > 0)
        {
            int x = A%26;
            ans = (x == 0) ? "Z" + ans : (char) ('A' + x - 1) + ans;
            A = A/26;
            if(x == 0) A--;
        }

        return ans;
    }
}
