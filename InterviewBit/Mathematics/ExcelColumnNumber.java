/*
Given a column title as appears in an Excel sheet, return its corresponding column number.

Example:

    A -> 1
    
    B -> 2
    
    C -> 3
    
    ...
    
    Z -> 26
    
    AA -> 27
    
    AB -> 28 
*/    
    
public class Solution 
{
    public int titleToNumber(String A) 
    {
        int power = 0;
        int ans = 0;
        for(int i = A.length()-1; i>-1; i--)
            ans = ans + (int) Math.pow(26, power++)*(1 + (A.charAt(i)-'A'));

        return ans;
    }
}
