/*
You are climbing a stair case. It takes n steps to reach to the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

Example :

Input : 3
Return : 3

Steps : [1 1 1], [1 2], [2 1]
*/

public class Solution {
    public int climbStairs(int A) 
    {
        int a = 1;
        int b = 2;
        
        int n = A-2;
        while(n > 0)
        {
            int temp = a+b;
            a = b;
            b = temp;
            n--;
        }
        
        return (A == 1) ? a : b;
    }
}
