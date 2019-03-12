/*
Given an integer, convert it to a roman numeral, and return a string corresponding to its roman numeral version

Input is guaranteed to be within the range from 1 to 3999.

Example :

Input : 5
Return : "V"

Input : 14
Return : "XIV"
 Note : This question has a lot of scope of clarification from the interviewer. 
 Please take a moment to think of all the needed clarifications and see the expected response using “See Expected Output” 
 For the purpose of this question, https://projecteuler.net/about=roman_numerals has very detailed explanations. 
*/

public class Solution 
{
    public static String toRoman(int n, int arr[], char ar[], HashMap<Integer, String> romanValues)
    {
        if(romanValues.containsKey(n))
            return romanValues.get(n);

        String roman = "";
        for(int i = 0; i<arr.length; i++)
        {
            int x = n/arr[i];
            while(x > 0)
            {
                roman += ar[i];
                x--;
            }

            n = n%arr[i];
        }

        return roman;
    }

    public String intToRoman(int A) 
    {
        HashMap<Integer, String> romanValues = new HashMap<Integer, String>();
        romanValues.put(4, "IV");
        romanValues.put(9, "IX");
        romanValues.put(40, "XL");
        romanValues.put(90, "XC");
        romanValues.put(400, "CD");
        romanValues.put(900, "CM");

        int arr[] = new int[]{1000, 500, 100, 50, 10, 5, 1};
        char ar[] = new char[]{'M', 'D', 'C', 'L', 'X', 'V', 'I'};

        ArrayList<String> ans = new ArrayList<String>();
        int tens = 1;
        while(A > 0)
        {
            int x = (A%10)*tens;
            ans.add(toRoman(x, arr, ar, romanValues));
            A = A/10;
            tens = tens*10;
        }

        String answer = "";
        int i = ans.size()-1;
        while(i > -1)
            answer += ans.get(i--);

        return answer;

    }
}
