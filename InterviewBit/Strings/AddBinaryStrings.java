/*
Given two binary strings, return their sum (also a binary string).

Example:

a = "100"

b = "11"
Return a + b = “111”.
*/

public class Solution 
{
    public String addBinary(String A, String B) 
    {
        int a = A.length();
        int b = B.length();

        String small = (a > b) ? B : A;
        String big = (a > b) ? A : B;

        int zero = big.length() - small.length();
        while(zero > 0)
        {
            small = '0' + small;
            zero--;
        }

        String ans = "";
        int carry = 0;
        for(int i = small.length()-1; i>=0; i--)
        {
            int sm = small.charAt(i) - '0';
            int bi = big.charAt(i) - '0';

            int curr = (sm + bi + carry)%2;
            carry = (sm + bi + carry)/2;

            ans = String.valueOf(curr) + ans;
        }

        if(carry != 0)
            ans = String.valueOf(carry) + ans;

        return ans;
    }
}
