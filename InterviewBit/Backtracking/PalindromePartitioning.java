/*
Given a string s, partition s such that every string of the partition is a palindrome.

Return all possible palindrome partitioning of s.

For example, given s = "aab",
Return

  [
    ["a","a","b"]
    ["aa","b"],
  ]
  
Ordering the results in the answer : Entry i will come before Entry j if :
len(Entryi[0]) < len(Entryj[0]) OR
(len(Entryi[0]) == len(Entryj[0]) AND len(Entryi[1]) < len(Entryj[1])) OR
*
*
*
(len(Entryi[0]) == len(Entryj[0]) AND … len(Entryi[k] < len(Entryj[k]))
In the given example,
["a", "a", "b"] comes before ["aa", "b"] because len("a") < len("aa")
*/

public class Solution 
{
    public static boolean isPalindrome(String a, int start, int end)
    {
        while(start < end)
        {
            if(a.charAt(start++) != a.charAt(end--))
                return false;
        }

        return true;
    } 

    public static void partitionUtil(String a, ArrayList<ArrayList<String>> answer, ArrayList<String> current, int index)
    {
        if(index == a.length())
        {
            answer.add(new ArrayList<String>(current));
            return;
        }

        else
        {
            for(int i = index; i<a.length(); i++)
            {
                if(isPalindrome(a, index, i))
                {
                    String temp = a.substring(index, i+1);
                    current.add(temp);
                    partitionUtil(a, answer, current, i+1);
                    current.remove(current.size()-1);
                }
            }
        }
    }

    public ArrayList<ArrayList<String>> partition(String a) 
    {
        ArrayList<ArrayList<String>> answer = new ArrayList<ArrayList<String>>();
        ArrayList<String> current = new ArrayList<String>();
        int index = 0;

        partitionUtil(a, answer, current, index);
        return answer;
    }
}
