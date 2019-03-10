/*
Given a collection of intervals, merge all overlapping intervals.

For example:

Given [1,3],[2,6],[8,10],[15,18],

return [1,6],[8,10],[15,18].

Make sure the returned intervals are sorted.
*/

class sortByStartIndex implements Comparator<Interval> 
{
    public int compare(Interval a, Interval b) 
    { 
        return a.start - b.start; 
    } 
} 
 
public class Solution 
{
    public ArrayList<Interval> merge(ArrayList<Interval> intervals) 
    {
        Collections.sort(intervals, new sortByStartIndex());

        int i = 1;
        while(i < intervals.size())
        {
            int s1 = intervals.get(i-1).start;
            int e1 = intervals.get(i-1).end;

            int s2 = intervals.get(i).start;
            int e2 = intervals.get(i).end;

            if(s1 <= e2 && s2 <= e1)
            {
                Interval iv = new Interval(s1, Math.max(e1, e2));
                intervals.remove(i-1);
                intervals.remove(i-1);
                intervals.add(i-1, iv);
            }

            else
                i++;
        }

        return intervals;
    }
}
