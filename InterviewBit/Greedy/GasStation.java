/*
There are N gas stations along a circular route, where the amount of gas at station i is gas[i].
You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from station i to its next station (i+1). 
You begin the journey with an empty tank at one of the gas stations.

Return the minimum starting gas station’s index if you can travel around the circuit once, otherwise return -1.

You can only travel in one direction. i to i+1, i+2, ... n-1, 0, 1, 2..
Completing the circuit means starting at i and ending up at i again.
*/

public class Solution 
{ 
    public int canCompleteCircuit(final int[] A, final int[] B) 
    {
        int n = A.length;
        int totalGas = 0;
        int totalCost = 0;

        for(int i = 0; i<n; i++)
        {
            totalGas += A[i];
            totalCost += B[i];
        }

        if(totalCost > totalGas)
            return -1;

        else
        {
            int index = 0;
            int lastTank = 0;
            int minNegativeTank = Integer.MAX_VALUE;
            for(int i = 1; i<n; i++)
            {
                int presentTank = lastTank + A[i-1] - B[i-1];
                lastTank = presentTank;
                if(presentTank < 0 && presentTank < minNegativeTank)
                {
                    minNegativeTank = presentTank;
                    index = i;
                }
            }

            return index;
        }
    }
}
