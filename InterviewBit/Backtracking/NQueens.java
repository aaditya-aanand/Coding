/*
The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.

N Queens: Example 1

Given an integer n, return all distinct solutions to the n-queens puzzle.

Each solution contains a distinct board configuration of the n-queens’ placement, 
where 'Q' and '.' both indicate a queen and an empty space respectively.

For example,
There exist two distinct solutions to the 4-queens puzzle:

[
 [".Q..",  // Solution 1
  "...Q",
  "Q...",
  "..Q."],

 ["..Q.",  // Solution 2
  "Q...",
  "...Q",
  ".Q.."]
]
*/

public class Solution 
{
    public static boolean isSafePosition(int row, int col, int board[][])
    {
        for(int i = 0; i<board.length; i++)
            if(board[i][col] != 0 || board[row][i] != 0)
                return false;

        for(int i = 0; i<board.length; i++)
        {
            for(int j = 0; j<board.length; j++)
                if(board[i][j] != 0 && (((i-j) == (row-col) || (i+j) == (row+col))))
                    return false;
        }

        return true;
    }

    public static boolean NQueenUtil(int board[][], int n, ArrayList<ArrayList<String>> ans)
    {
        if(n == 0)
        {
            ArrayList<String> temp = new ArrayList<String>();

            for(int r = 0; r<board.length; r++)
            {
                String s = "";
                for(int c = 0; c<board.length; c++)
                {
                    if(board[r][c] == 1)
                        s += "Q";

                    else
                        s += ".";
                }
                temp.add(s);
            }
            
            ans.add(temp);
            return true;
        }

        boolean result = false;
        for(int i = 0; i<board.length; i++)
        {
            if(isSafePosition(i, n-1, board))
            {
                board[i][n-1] = 1;
                result = NQueenUtil(board, n-1, ans) || result;
                board[i][n-1] = 0;
            }
        }

        return result;
    }

    public ArrayList<ArrayList<String>> solveNQueens(int n) 
    {
        ArrayList<ArrayList<String>> ans = new ArrayList<ArrayList<String>>();
        int board[][] = new int[n][n];

        NQueenUtil(board, n, ans);
        return ans;
    }
}
