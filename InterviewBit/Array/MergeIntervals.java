/*
Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).

You may assume that the intervals were initially sorted according to their start times.

Example 1:

Given intervals [1,3],[6,9] insert and merge [2,5] would result in [1,5],[6,9].

Example 2:

Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] would result in [1,2],[3,10],[12,16].

This is because the new interval [4,9] overlaps with [3,5],[6,7],[8,10].

Make sure the returned intervals are also sorted.
*/

public class Solution 
{
    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) 
    {
        int n = intervals.size();
        for(int i = 0; i<intervals.size(); i++)
        {
            if(intervals.get(i).start > newInterval.start)
            {
                intervals.add(i, newInterval);
                break;
            }
        }

        if(n == intervals.size())
        {
            intervals.add(newInterval);
            return intervals;
        }

        ArrayList<Interval> ans = new ArrayList<Interval>();
        ans.add(intervals.get(0));

        int i = 0;
        int j = 0;
        while(i < intervals.size())
        {
            int s1 = ans.get(j).start;
            int s2 = intervals.get(i).start;

            int e1 = ans.get(j).end;
            int e2 = intervals.get(i).end;

            if(s2 <= e1)
            {
                ans.remove(j);
                ans.add(new Interval(s1, Math.max(e1, e2)));
                i++;
            }

            else
            {
                ans.add(intervals.get(i));
                j++;
                i++;
            }
        }

        return ans;
    }
}
