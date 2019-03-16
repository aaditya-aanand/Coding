/*
Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.

An example is the root-to-leaf path 1->2->3 which represents the number 123.

Find the total sum of all root-to-leaf numbers % 1003.

Example :

    1
   / \
  2   3
The root-to-leaf path 1->2 represents the number 12.
The root-to-leaf path 1->3 represents the number 13.

Return the sum = (12 + 13) % 1003 = 25 % 1003 = 25.
*/

public class Solution 
{
    public static int mod(String num, int m)
    {
        int res = 0;
        for(int i = 0; i<num.length(); i++)
            res = (res*10 + (num.charAt(i) - '0'))%m;

        return res;
    }

    public static boolean isLeaf(TreeNode A)
    {
        return A != null && A.left == null && A.right == null;
    }

    public void sumNumbersUtil(TreeNode A, StringBuilder num, ArrayList<String> ans)
    {
        if(A == null)
            return;

        num.append(A.val);

        if(isLeaf(A))
            ans.add(num.toString());

        sumNumbersUtil(A.left, new StringBuilder(num), ans);
        sumNumbersUtil(A.right, new StringBuilder(num), ans);
    }

    public int sumNumbers(TreeNode A) 
    {
        StringBuilder num = new StringBuilder();
        ArrayList<String> ans = new ArrayList<String>();

        sumNumbersUtil(A, num, ans);

        int value = 0;
        for(int i = 0; i<ans.size(); i++)
        {
            int x = mod(ans.get(i), 1003);
            value = (value + x)%1003;
        }

        return value;
    }
}
