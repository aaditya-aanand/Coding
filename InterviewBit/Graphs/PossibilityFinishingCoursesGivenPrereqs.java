/*
There are a total of N courses you have to take, labeled from 1 to N. Some courses may have prerequisites, 
for example to take course 2 you have to first take course 1, which is expressed as a pair: [1,2]. 

Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses. 
return 1/0 if it is possible/not possible.

The list of prerequisite pair are given in two integer arrays B and C where B[i] is a prerequisite for C[i].

 Example: If N = 3 and the prerequisite pairs are [1,2] and [2,3], then you can finish courses in the following order: 
 1, 2 and 3. But if N = 2 and the prerequisite pairs are [1,2] and [2,1], 
 then it is not possible for you to finish all the courses. 
 */

public class Solution 
{
    public static boolean dfs(Vector<Vector<Integer>> graph, int source, HashSet<Integer> set, boolean visited[])
    {
        if(set.contains(source))
            return true;
        
        set.add(source);
        visited[source] = true;
        
        for(int x : graph.get(source))
        {
            if(dfs(graph, x, set, visited))
                return true;
        }
            
        set.remove(source);

        return false;
    }
    
    public int solve(int A, ArrayList<Integer> B, ArrayList<Integer> C) 
    {
        Vector<Vector<Integer>> graph = new Vector<Vector<Integer>>();
        for(int i = 0; i<A+1; i++)
            graph.add(new Vector<Integer>());
        
        for(int i = 0; i<B.size(); i++)
            graph.get(B.get(i)).add(C.get(i));
        
        boolean visited[] = new boolean[A+1];
        boolean flag = false;
        
        for(int i = 1; i<graph.size(); i++)
        {
            if(!visited[i])
            {
                HashSet<Integer> set = new HashSet<Integer>();
                flag |= dfs(graph, i, set, visited);
                if(flag) return 0;
            }
        }
        
        return 1;
    }
}
