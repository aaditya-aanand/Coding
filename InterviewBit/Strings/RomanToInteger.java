/*
Given a roman numeral, convert it to an integer.

Input is guaranteed to be within the range from 1 to 3999.

Read more details about roman numerals at Roman Numeric System

Example :

Input : "XIV"
Return : 14
Input : "XX"
Output : 20
*/

public class Solution 
{
    public int romanToInt(String A) 
    {
        HashMap<Character, Integer> romanValues = new HashMap<Character, Integer>();
        romanValues.put('I', 1);
        romanValues.put('V', 5);
        romanValues.put('X', 10);
        romanValues.put('L', 50);
        romanValues.put('C', 100);
        romanValues.put('D', 500);
        romanValues.put('M', 1000);

        Stack<Integer> stack = new Stack<Integer>();
        for(int i = 0; i<A.length(); i++)
        {
            if(!stack.isEmpty() && stack.peek() < romanValues.get(A.charAt(i)))
                stack.push(romanValues.get(A.charAt(i)) - stack.pop());

            else
                stack.push(romanValues.get(A.charAt(i)));
        }

        int ans = 0;
        while(!stack.isEmpty())
            ans += stack.pop();

        return ans;
    }
}
