/*
Determine if a Sudoku is valid, according to: http://sudoku.com.au/TheRules.aspx

The Sudoku board could be partially filled, where empty cells are filled with the character ‘.’.

The input corresponding to the above configuration :

["53..7....", "6..195...", ".98....6.", "8...6...3", "4..8.3..1", "7...2...6", ".6....28.", "...419..5", "....8..79"]
A partially filled sudoku which is valid.

Note:
A valid Sudoku board (partially filled) is not necessarily solvable. Only the filled cells need to be validated.

Return 0 / 1 ( 0 for false, 1 for true ) for this problem
*/

public class Solution 
{
    public int isValidSudoku(final String[] A) 
    {
    	int mat[][] = new int[9][9];
    	for(int i = 0; i<9; i++)
    	{
    		for(int j = 0; j<9; j++)
    		{
    			char x = A[i].charAt(j);
    			mat[i][j] = (x == '.') ? 0 : x - '0';
    		}
    	}
    	
    	for(int i = 0; i<9; i++)
    	{
    		HashSet<Integer> row = new HashSet<Integer>();
    		int count = 0;
    		for(int j = 0; j<9; j++)
    		{
    			if(mat[i][j] != 0)
    			{
    				row.add(mat[i][j]);
    				count++;
    			}
    		}
    		
    		if(count != row.size())
    			return 0;
    	}
    	
    	for(int i = 0; i<9; i++)
    	{
    		HashSet<Integer> col = new HashSet<Integer>();
    		int count = 0;
    		for(int j = 0; j<9; j++)
    		{
    			if(mat[j][i] != 0)
    			{
    				col.add(mat[j][i]);
    				count++;
    			}
    		}
    		
    		if(count != col.size())
    			return 0;
    	}
    	
    	int index[][] = new int[][]{{0, 0}, {0, 3}, {0, 6}, {3, 0}, {3, 3}, {3, 6}, {6, 0}, {6, 3}, {6, 6}};
    	for(int b = 0; b<9; b++)
    	{
    		HashSet<Integer> block = new HashSet<Integer>();
    		int count = 0;
    		for(int i = index[b][0]; i<index[b][0]+3; i++)
    		{
    			for(int j = index[b][1]; j<index[b][1]+3; j++)
    			{
    				if(mat[i][j] != 0)
        			{
        				block.add(mat[i][j]);
        				count++;
        			}
    			}
    		}
    		
    		if(count != block.size())
    			return 0;
    	}
    		
    	return 1;
    }
}
