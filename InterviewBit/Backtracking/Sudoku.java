/*
Write a program to solve a Sudoku puzzle by filling the empty cells.
Empty cells are indicated by the character '.' 
You may assume that there will be only one unique solution.



A sudoku puzzle,



and its solution numbers marked in red.

Example :

For the above given diagrams, the corresponding input to your program will be

[[53..7....], [6..195...], [.98....6.], [8...6...3], [4..8.3..1], [7...2...6], [.6....28.], [...419..5], [....8..79]]
and we would expect your program to modify the above array of array of characters to

[[534678912], [672195348], [198342567], [859761423], [426853791], [713924856], [961537284], [287419635], [345286179]]
*/

public class Solution 
{
    public static boolean isSafePosition(int num, int r, int c, int sud[][])
    {
        //If num is present in either that row or col, return false
        for(int i = 0; i<9; i++)
        {
            if(sud[i][c] == num || sud[r][i] == num)
                return false;
        }

        //Find the location of the grid
        int gridRow = r/3;
        int gridCol = c/3;

        //Finding the starting row and col of that grid
        int startingRow = gridRow*3;
        int startingCol = gridCol*3;

        //If num is present in that grid, return false
        for(int i = startingRow; i<startingRow+3; i++)
        {
            for(int j = startingCol; j<startingCol+3; j++)
            {
                if(sud[i][j] == num)
                    return false;
            }
        }

        //If everything is okay, return true (this position is safe)
        return true;
    }

    public static boolean solveSudokuUtil(int sudoku[][], int countEmpty)
    {
        if(countEmpty == 0)
            return true;

        int r = -1;
        int c = -1;

    lab:for(int i = 0; i<9; i++)
        {
            for(int j = 0; j<9; j++)
            {
                if(sudoku[i][j] == 0)
                {
                    r = i;
                    c = j;
                    break lab;
                }
            }
        }

        for(int num = 1; num<10; num++)
        {
            if(isSafePosition(num, r, c, sudoku))
            {
                //If it is safe to put num at i, j then put it
                sudoku[r][c] = num;

                //Recursively check whether rest of the sudoku can be filled
                if(solveSudokuUtil(sudoku, countEmpty-1))
                    return true;

                //Backtracking
                sudoku[r][c] = 0;
            }
        }

        return false;
    }

    public void solveSudoku(ArrayList<ArrayList<Character>> a) 
    {
        int sudoku[][] = new int[9][9];
        int countEmpty = 0;

        for(int i = 0; i<9; i++)
        {
            for(int j = 0; j<9; j++)
            {
                if(a.get(i).get(j) == '.')
                {
                    countEmpty++;
                    sudoku[i][j] = 0;
                }

                else
                    sudoku[i][j] = a.get(i).get(j) - '0';
            }
        }

        solveSudokuUtil(sudoku, countEmpty);
        
        for(int i = 0; i<9; i++)
            for(int j = 0; j<9; j++)
                a.get(i).set(j, (char) (sudoku[i][j] + 48));
    }
}
