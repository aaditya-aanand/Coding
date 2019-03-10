/*
You are given a string S, and you have to find all the amazing substrings of S.

Amazing Substring is one that starts with a vowel (a, e, i, o, u, A, E, I, O, U).

Input

Only argument given is string S.
Output

Return a single integer X mod 10003, here X is number of Amazing Substrings in given string.
Constraints

1 <= length(S) <= 1e6
S can have special characters
Example

Input
    ABEC

Output
    6

Explanation
	Amazing substrings of given string are :
	1. A
	2. AB
	3. ABE
	4. ABEC
	5. E
	6. EC
	here number of substrings are 6 and 6 % 10003 = 6.
Seen this question in a real interview before
*/

public class Solution 
{
    public int solve(String A) 
    {
        HashSet<Character> vowels = new HashSet<Character>();
        vowels.add('a'); vowels.add('e'); vowels.add('i'); vowels.add('o'); vowels.add('u');
        vowels.add('A'); vowels.add('E'); vowels.add('I'); vowels.add('O'); vowels.add('U');
        int ans = 0;

        for(int i = 0; i<A.length(); i++)
        {
            char x = A.charAt(i);
            if(vowels.contains(x))
                ans = (ans + A.length() - i)%10003;
        }

        return ans;
    }
}
