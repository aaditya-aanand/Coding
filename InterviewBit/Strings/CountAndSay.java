/*
The count-and-say sequence is the sequence of integers beginning as follows:

1, 11, 21, 1211, 111221, ...
1 is read off as one 1 or 11.
11 is read off as two 1s or 21.

21 is read off as one 2, then one 1 or 1211.

Given an integer n, generate the nth sequence.

Note: The sequence of integers will be represented as a string.

Example:

if n = 2,
the sequence is 11.
*/

public class Solution 
{
    public String countAndSay(int A) 
    {
        String ans[] = new String[A];
        ans[0] = "1";

        for(int i = 1; i<A; i++)
        {
            String s = "";
            char prev = ans[i-1].charAt(0);
            int count = 1;
            for(int j = 1; j<ans[i-1].length(); j++)
            {
                if(ans[i-1].charAt(j) == prev)
                    count++;

                else
                {
                    s = s + String.valueOf(count) + prev;
                    prev = ans[i-1].charAt(j);
                    count = 1;
                }
            }

            s = s + String.valueOf(count) + prev;
            ans[i] = s;
        }

        return ans[ans.length-1];
    }
}
